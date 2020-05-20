import java.awt.Graphics;

public class FireBlock extends Block
{
    public FireBlock(float x, float y) {
        super(x, y);
    }
    
    public void tick() {
        
    }
    
    public void render (Graphics g) {
        g.drawImage(Assets.fire, (int)x, (int)y, null);
    }
    
}
