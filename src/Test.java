import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import sjgl.SJGL;
import sjgl.image.ImageLoader;
import sjgl.image.SpriteSheet;
import sjgl.input.Keyboard;
import sjgl.input.Mouse;
import sjgl.window.Window;

/*
 * This class is for testing SJGL.
 * */

public class Test extends SJGL{
	
	private BufferedImage image;
	private BufferedImage sprite1;
	private SpriteSheet ss;
	
	public Test() {
		super(800, 800, "test");
		setTicks(60);
	}
	
	public void onStart() {
		System.out.println("Start");
		
		ImageLoader loader = new ImageLoader();
		image = loader.loadImage("/test.png"); 
		ss = new SpriteSheet("/spriteSheet.png", 16);
		sprite1 = ss.grabSprite(0, 0);
	}
	
	public void onClose() {
		System.out.println("Close");
	}
	
	public void onUpdate() {

	}
	
	public void onRender(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 800, 800);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(sprite1, 0, 0, null);
		//g2d.drawImage(ss.grabSprite(1, 1), 0, 0, null);
		
		if(Keyboard.isKeyDown(KeyEvent.VK_F)) {
			System.out.println("test");
		}
		
		if(Mouse.isPressed()) {
			System.out.println(Mouse.getX());
		}
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
