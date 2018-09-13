import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import sjgl.SJGL;
import sjgl.input.Keyboard;

/*
 * This class is for testing SJGL.
 * */

public class Test extends SJGL{
	
	public Test() {
		super(800, 800, "test");
		this.ticks = 60;
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
		
		if(Keyboard.key == KeyEvent.VK_F) {
			System.out.println("test");
		}
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
