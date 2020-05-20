import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    private ArrayList<Block> blockArray;
    
    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        blockArray = new ArrayList<Block>();
        this.keyManager = new KeyManager();
        this.mouseManager = new MouseManager();
    }
    
    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener( keyManager );
        display.getFrame().addMouseListener( mouseManager );
        display.getFrame().addMouseMotionListener( mouseManager );
        display.getCanvas().addMouseListener( mouseManager );
        display.getCanvas().addMouseMotionListener( mouseManager );
        Assets.init();
    }
    
    private void tick(){
        if (mouseManager.isLeftPressed()) {
            if (keyManager.elementString.equals( "earth" )) {
                blockArray.add( new EarthBlock(mouseManager.getMouseX(), mouseManager.getMouseY()) );
            } else if (keyManager.elementString.equals( "water" )) {
                blockArray.add( new WaterBlock(mouseManager.getMouseX(), mouseManager.getMouseY()) );
            } else if (keyManager.elementString.equals( "ice" )) {
                blockArray.add( new IceBlock(mouseManager.getMouseX(), mouseManager.getMouseY()) );
            } else {
                blockArray.add( new FireBlock(mouseManager.getMouseX(), mouseManager.getMouseY()) );
            }
         }
        //System.out.println(keyManager.elementString);
        //System.out.println(mouseManager.getMouseX() + ", " + mouseManager.getMouseY());
//        if (mouseManager.isLeftPressed()) {
//            System.out.println("ooga booga");
//        }
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!
        for (int i = 0; i < blockArray.size(); i++) {
            blockArray.get( i ).render( g );
        }
        g.drawImage(Assets.water, 10, 10, null);
        
        //End Drawing!
        bs.show();
        g.dispose();
    }
    
public void run(){
        
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000){
                System.out.println("fps: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        
        stop();
        
    }
    
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
