package sjgl.window;

import javax.swing.JFrame;

import sjgl.SJGL;

public class Window {
	private JFrame f;
	
	//TODO: Add more preferences for the window.
	
	public Window(int width, int height, String title, SJGL sjgl) {
		f = new JFrame(title);
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.add(sjgl);
		f.setVisible(true);
	}
}
