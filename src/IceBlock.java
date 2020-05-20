import java.awt.Graphics;

public class IceBlock extends Block
{
    public IceBlock(float x, float y) {
        super(x, y);
    }
    
    public void tick() {
        
    }
    
    public void render (Graphics g) {
        g.drawImage(Assets.ice, (int)x, (int)y, null);
    }
    
}
