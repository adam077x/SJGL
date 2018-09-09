import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import sjgl.SJGL;
import sjgl.window.Window;

public class Test extends SJGL{
	
	public Test() {
		super(800, 800, "test");
		this.ticks = 60;
	}
	
	public void FixedUpdate() {
		//System.out.println("hi");
	}
	
	public void Render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 800, 800);
		
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
