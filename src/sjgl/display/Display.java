package sjgl.display;

import javax.swing.JFrame;

import sjgl.SJGL;
import sjgl.window.Window;

public class Display {
	public SJGL sjgl;
	
	public static int ticks; // A value that restrains ticks per seconds
	public static int render;
	
	public Display(SJGL sjgl) {
		this.sjgl = sjgl;
	}
	
	public void createDisplay(int width, int height, boolean fullscreen, String title) {
		new Window(width, height, title, false, JFrame.EXIT_ON_CLOSE, true, fullscreen, sjgl);
		
		render = 1000;
		ticks = 60;
		sjgl.start();
	}
	
	public void createDisplay(int width, int height, String title, boolean resizable, int closeOp, boolean fullscreen, boolean visible) {
		new Window(width, height, title, resizable, closeOp, visible, fullscreen, sjgl);
		
		render = 1000;
		ticks = 60;
		sjgl.start();
	}

}
