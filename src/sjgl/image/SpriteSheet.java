package sjgl.image;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private static BufferedImage spriteSheet;
	private String path; // Destination path to an image
	private ImageLoader loader;
	
	private int size;
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		loader = new ImageLoader();
		this.size = size;
	}
	
	public BufferedImage grabSprite(int xGrid, int yGrid) {
		
        if (spriteSheet == null) {
            spriteSheet = loader.loadImage(path);
        }

        return spriteSheet.getSubimage(xGrid * size, yGrid * size, size, size);
    }
}
