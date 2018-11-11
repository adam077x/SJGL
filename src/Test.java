import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

import sjgl.SJGL;
import sjgl.audio.PlayWavSound;
import sjgl.computerinfo.ComputerInfo;
import sjgl.gameloop.GameLoop;
import sjgl.graphics.Graphics;
import sjgl.image.ImageLoader;
import sjgl.image.SpriteSheet;
import sjgl.object.GameObject;
import sjgl.object.entity.Entity;
import sjgl.text.Text;
import sjgl.vectors.Vector2;
import sjgl.window.Window;

/*
 * This class is for testing SJGL.
 * */

public class Test extends SJGL {
	private static final long serialVersionUID = 3597315792225837761L;

	private BufferedImage image;
	private BufferedImage sprite1;
	private SpriteSheet ss;
	private int x = 350, y = 350;
	private int velX, velY;
	
	public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public Test() {
		createDisplay(700, 700, false,"test");
	}

	public void onStart() {
		GameLoop.syncronized = false;
		System.out.println("Start");
		
		ImageLoader loader = new ImageLoader();
		image = loader.loadImage("/test.png");
		ss = new SpriteSheet("/spriteSheet.png", 16);
		sprite1 = ss.grabSprite(0, 0);
		System.out.println(ComputerInfo.homeDir);
		entities.add(new testEntity());
	}

	public void onClose() {
		System.out.println("Close");
	}

	public void onUpdate() {
		x += velX;
		y += velY;
		
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).onUpdate();
		}
	}

	public void onRender() {
		Text text = new Text(new Vector2(10, 10), "test", new Font("Arial", 20, 20));
		Graphics g = new Graphics();
		g.clearScreen(Color.CYAN);
		
		for(int i = 0; i < entities.size(); i++) {
			 entities.get(i).onRender(g);
		}
		
		text.onRender(g);
		
		g.fillRect(x, y, 50, 50, Color.RED);
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
		if (e.getKeyCode() == KeyEvent.VK_F) {
			PlayWavSound.PlaySound(new File("Pickup_Coin.wav"));
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
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	class testObject implements GameObject{
		
		@Override
		public void onRender(Graphics g) {
			g.fillRect(100, 100, 100, 100, Color.WHITE);
		}

		@Override
		public void onUpdate() {
		}
		
	}
	
	class testEntity extends Entity {

		public testEntity() {
			super(new Vector2(10, 10), new Vector2(50, 50));
			velocity.x = 5;
			velocity.y = 5;
		}
		
		@Override
		public void onRender(Graphics g) {
			g.fillRect(position.x, position.y, size.x, size.y, Color.GREEN);
		}

		@Override
		public void onUpdate() {
			position.x += velocity.x;
			position.y += velocity.y;
		}
	}
}