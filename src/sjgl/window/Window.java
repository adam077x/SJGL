package sjgl.window;

import javax.swing.JFrame;

import sjgl.SJGL;

public class Window {
	private JFrame f;

	public Window(int width, int height, String title, boolean resizable, int closeOp, boolean visible, SJGL sjgl) {
		f = new JFrame(title);
		f.setSize(width, height);
		f.setDefaultCloseOperation(closeOp);
		f.setResizable(resizable);
		f.add(sjgl);
		f.setVisible(visible);
	}
}
