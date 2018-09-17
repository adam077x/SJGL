import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
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

public class Test extends SJGL {
	private static final long serialVersionUID = 3597315792225837761L;

	private BufferedImage image;
	private BufferedImage sprite1;
	private SpriteSheet ss;
	private int x, y, velX, velY;

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
		x += velX;
		y += velY;
	}

	public void onRender(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 800, 800);

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(sprite1, 0, 0, null);
		// g2d.drawImage(ss.grabSprite(1, 1), 0, 0, null);

		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 50);
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			velX = -5;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			velX = 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			velY = -5;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			velY = 5;
		}
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			velX = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			velX = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			velY = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			velY = 0;
		}
	}

	public static void main(String[] args) {
		new Test();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
