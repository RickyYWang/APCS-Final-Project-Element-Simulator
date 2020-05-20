import java.awt.Graphics;

public class EarthBlock extends Block
{
    public EarthBlock(float x, float y) {
        super(x, y);
    }
    
    public void tick() {
        
    }
    
    public void render (Graphics g) {
        g.drawImage(Assets.earth, (int)x, (int)y, null);
    }
    
}
