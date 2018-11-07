package sjgl.graphics;

import java.awt.Color;
import java.awt.Image;

import sjgl.SJGL;

public class Graphics {
	public static int graphicsLib; // 0 - Java Swing 
								   // 1 - LWJGL (not implemented yet)
	
	public void fillRect(int x, int y, int width, int height, Color color) {
		if(graphicsLib == 0) {
			SJGL.g.setColor(color);
			SJGL.g.fillRect(x, y, width, height);
		}
	}
	
	public void drawRect(int x, int y, int width, int height, Color color) {
		if(graphicsLib == 0) {
			SJGL.g.setColor(color);
			SJGL.g.drawRect(x, y, width, height);
		}
	}
	
	public void fillOval(int x, int y, int width, int height, Color color) {
		if(graphicsLib == 0) {
			SJGL.g.setColor(color);
			SJGL.g.fillOval(x, y, width, height);
		}
	}
	
	public void drawImage(Image img, int x, int y, int width, int height, Color color) {
		if(graphicsLib == 0) {
			SJGL.g.setColor(color);
			SJGL.g.drawImage(img, x, y, width, height, null);
		}
	}
	
	public void drawOval(int x, int y, int width, int height, Color color) {
		if(graphicsLib == 0) {
			SJGL.g.setColor(color);
			SJGL.g.drawOval(x, y, width, height);
		}
	}
	
	public void drawString(String str, int x, int y, Color color) {
		if(graphicsLib == 0) {
			SJGL.g.setColor(color);
			SJGL.g.drawString(str, x, y);
		}
	}
}
