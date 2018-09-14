import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import sjgl.SJGL;
import sjgl.image.ImageLoader;
import sjgl.input.Keyboard;

/*
 * This class is for testing SJGL.
 * */

public class Test extends SJGL{
	
	private BufferedImage image;
	
	public Test() {
		super(800, 800, "test");
		this.ticks = 60;
		ImageLoader loader = new ImageLoader();
		image = loader.loadImage("/test.png"); 
	}
	
	public void onStart() {
		System.out.println("Start");
	}
	
	public void onClose() {
		System.out.println("Close");
	}
	
	public void onUpdate() {
		//System.out.println("update");
	}
	
	public void onRender(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 800, 800);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, null);
		
		if(Keyboard.key == KeyEvent.VK_F) {
			System.out.println("test");
		}
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
