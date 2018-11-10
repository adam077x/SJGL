package sjgl.gameloop;

import sjgl.SJGL;

public class GameLoop {
	private static int updates;
	private static int frames;
	
	public GameLoop(SJGL sjgl) {
		//this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = sjgl.getSjgl().getTicks();
		double amountOfRender = sjgl.getSjgl().getRender();
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
