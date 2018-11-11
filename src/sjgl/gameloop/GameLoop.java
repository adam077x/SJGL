package sjgl.gameloop;

import java.awt.Toolkit;

import sjgl.SJGL;
import sjgl.display.Display;

public class GameLoop {
	private static int updates;
	private static int frames;
	public static boolean syncronized = false;
	
	public GameLoop(SJGL sjgl) {
		//this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = Display.ticks;
		double amountOfRender = Display.render;
		double ns = 1000000000 / amountOfTicks;
		double render = 1000000000 / amountOfRender;
		double delta = 0;
		double deltaRender = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		sjgl.setRunning(true);
		
		/*
		 * Game loop (will cap ticks per second, while you can have unlimited frames per second)
		 * */
		
		while(sjgl.isRunning()){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			deltaRender += (now - lastTime) / render;
			lastTime = now;
			while(delta >= 1){
				sjgl.tick();
				updates++;
				delta--;
			}
			while(deltaRender >= 1){
				sjgl.render();
				frames++;
				deltaRender--;
			}
			
			if(System.currentTimeMillis() - timer > 1000){
				this.updates = updates;
				this.frames = frames;
				timer += 1000;
				frames = 0;
				updates = 0;
			}
			
			if(syncronized) {
				Toolkit.getDefaultToolkit().sync(); // Synchronize graphical state
			}
		}
		sjgl.stop();
	}

	public static int getUpdates() {
		return updates;
	}

	public static int getFPS() {
		return frames;
	}
}
