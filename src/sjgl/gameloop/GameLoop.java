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
		sjgl.getSjgl().setRunning(true);
		
		/*
		 * Game loop (will cap ticks per second, while you can have unlimited frames per second)
		 * */
		
		while(sjgl.getSjgl().isRunning()){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			deltaRender += (now - lastTime) / render;
			lastTime = now;
			while(delta >= 1){
				sjgl.getSjgl().tick();
				updates++;
				delta--;
			}
			while(deltaRender >= 1){
				sjgl.getSjgl().render();
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
		sjgl.getSjgl().stop();
	}

	public static int getUpdates() {
		return updates;
	}

	public static int getFPS() {
		return frames;
	}
}
