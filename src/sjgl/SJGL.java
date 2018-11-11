package sjgl;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import sjgl.gameloop.GameLoop;
import sjgl.input.Keyboard;
import sjgl.input.Mouse;
import sjgl.object.GameObject;
import sjgl.window.Window;

public abstract class SJGL extends Canvas implements Runnable {
	private static final long serialVersionUID = -1606451883329577588L;

	private int ticks; // A value that restrains ticks per seconds
	private int render;
	
	private Thread thread;
	private boolean running = false;
	
	private SJGL sjgl = this;
	
	public static Graphics2D g2d;
	public static Graphics g;
	
	public void createDisplay(int width, int height, boolean fullscreen,String title) {
		new Window(width, height, title, false, JFrame.EXIT_ON_CLOSE, true, fullscreen, this);
		
		render = 1000;
		ticks = 60;
		start();
	}
	
	public void createDisplay(int width, int height, String title, boolean resizable, int closeOp, boolean fullscreen, boolean visible) {
		new Window(width, height, title, resizable, closeOp, visible, fullscreen, this);
		
		render = 1000;
		ticks = 60;
		start();
	}

	private synchronized void start() {

		/*
		 * This code will be executed when program starts.
		 */

		onStart();
		thread = new Thread(this);
		thread.start();
		this.addKeyListener(new Keyboard(this));
		this.addMouseListener(new Mouse(this));
		setRunning(true);
	}

	public synchronized void stop() {
		if (running)
			return;
		onClose();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setRunning(false);
	}

	/*
	 * Functions that users of this library will use.
	 */

	public abstract void onStart(); // This function will be executed every time the program is opened

	public abstract void onClose(); // This function will be executed when the program/application is closed

	public abstract void onUpdate(); // This function is executed 60 times a second

	public abstract void onRender(); // This function is executed as many times as possible. (Depends on the power of your computer)
	
	public void onKeyPress(KeyEvent e) {}
	
	public void onKeyRelease(KeyEvent e) {}
	
	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		g2d = (Graphics2D) g;
		sjgl.graphics.Graphics g2 = new sjgl.graphics.Graphics();
		
		onRender();
		
		bs.show();
		g.dispose();
	}
	
	public void tick() {
		onUpdate();
	}

	/*
	 * Some getters and setters
	 */

	public void run() {
		new GameLoop(this);
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public SJGL getSjgl() {
		return sjgl;
	}
	
	public int getRender() {
		return render;
	}

	public int getTicks() {
		return ticks;
	}

	public void setTicks(int ticks) {
		this.ticks = ticks;
	}
	
	public float getVersion() {
		return 1.3f;
	}
}
