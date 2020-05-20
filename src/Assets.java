import java.awt.image.BufferedImage;

public class Assets {
    
    private static final int width = 16, height = 16;
    
    public static BufferedImage earth, water, ice, fire;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        
        earth = sheet.crop(0, 0, width, height);
        water = sheet.crop(width, 0, width, height);
        ice = sheet.crop(width * 2, 0, width, height);
        fire = sheet.crop(width * 3, 0, width, height);
    }
    
}