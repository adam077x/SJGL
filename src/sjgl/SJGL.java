package sjgl;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import sjgl.gameloop.GameLoop;
import sjgl.input.Keyboard;
import sjgl.input.Mouse;
import sjgl.window.Window;

public abstract class SJGL extends Canvas implements Runnable{
	private static final long serialVersionUID = -1606451883329577588L;
	
	public int ticks; // A value that restrains ticks per seconds
	public boolean sync = true;
	private Thread thread;
	private boolean running = false;
	private SJGL sjgl = this;
	
	public SJGL(int width, int height, String title) {
		new Window(width, height, title, false, JFrame.EXIT_ON_CLOSE, true, this);
		
		ticks = 60;
		start();
	}
	
	public SJGL(int width, int height, String title, boolean resizable, int closeOp, boolean visible) {
		new Window(width, height, title, resizable, closeOp, visible, this);
		
		ticks = 60;
		start();
	}

	private synchronized void start() {
		
		/*
		 * This code will be executed when program starts.
		 * */
		
		onStart();
		thread = new Thread(this);
		thread.start();
		this.addKeyListener(new Keyboard());
		this.addMouseListener(new Mouse());
		setRunning(true);
	}
	
	public synchronized void stop() {
		if(running) return;
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
	 * */
	
	public abstract void onStart();
	
	public abstract void onClose();
	
	public abstract void onUpdate();

	public abstract void onRender(Graphics g);
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		onRender(g);
		
		bs.show();
		g.dispose();
	}
	
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
}
