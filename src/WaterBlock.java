import java.awt.Graphics;

public class WaterBlock extends Block
{
    public WaterBlock(float x, float y) {
        super(x, y);
    }
    
    public void tick() {
        
    }
    
    public void render (Graphics g) {
        g.drawImage(Assets.water, (int)x, (int)y, null);
    }
    
}
