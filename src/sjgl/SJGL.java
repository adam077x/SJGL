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
		ticks = 60;
		start();
	}

	private synchronized void start() {
		if(running) return;
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	private synchronized void stop() {
		if(!running) return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		running = false;
	}
	
	public void FixedUpdate() {}

	public void Update() {}

	public void Render(Graphics g) {}

	void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		Render(g);
		
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
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				FixedUpdate();
				updates++;
				delta--;
			}
			render();
			Update();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

}
