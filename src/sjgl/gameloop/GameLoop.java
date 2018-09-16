package sjgl.gameloop;

import java.awt.Toolkit;

import sjgl.SJGL;

public class GameLoop {
	public GameLoop(SJGL sjgl) {
		//this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = sjgl.getSjgl().getTicks();
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
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
			lastTime = now;
			while(delta >= 1){
				sjgl.getSjgl().onUpdate();
				updates++;
				delta--;
			}
			sjgl.getSjgl().render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frames = 0;
				updates = 0;
			}
			if(sjgl.getSjgl().isSync()) {
				Toolkit.getDefaultToolkit().sync();
			}
		}
		sjgl.getSjgl().stop();
	}
}
