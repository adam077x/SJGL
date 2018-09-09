package sjgl;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import sjgl.window.Window;

public class SJGL extends Canvas implements Runnable{
	public int ticks;
	private Thread thread;
	private boolean running = false;
	
	public SJGL(int width, int height, String title) {
		new Window(width, height, title, this);
		
		/*
		 * A value that restrains ticks per seconds
		 * */
		
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
		running = true;
	}
	
	private synchronized void stop() {
		onClose();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		running = false;
	}
	
	/*
	 * Functions that users of this library will use.
	 * */
	
	public void onStart() {}
	
	public void onClose() {}
	
	public void onUpdate() {}

	public void onRender(Graphics g) {}
	
	void render() {
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
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = ticks;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		/*
		 * Game loop (will cap ticks per second, while you can have unlimited frames per second)
		 * */
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				onUpdate();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

}
