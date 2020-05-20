import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    
    private boolean[] keys;
    public String elementString;
    
    public KeyManager(){
        elementString = "earth";
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q ) {
            elementString = "earth";
        } else if (e.getKeyCode() == KeyEvent.VK_W ) {
            elementString = "water";
        } else if (e.getKeyCode() == KeyEvent.VK_E ) {
            elementString = "ice";
        } else if (e.getKeyCode() == KeyEvent.VK_R ) {
            elementString = "fire";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

}