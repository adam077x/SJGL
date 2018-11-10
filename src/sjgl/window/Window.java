package sjgl.window;

import java.awt.Toolkit;

import javax.swing.JFrame;

import sjgl.SJGL;

public class Window {
	public static JFrame f;

	public Window(int width, int height, String title, boolean resizable, int closeOp, boolean visible, boolean fullscreen, SJGL sjgl) {
		f = new JFrame(title);
		if(!fullscreen) {
			f.setSize(width, height);
		}else {
			f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
			f.setUndecorated(true);
		}
		f.setDefaultCloseOperation(closeOp);
		f.setResizable(resizable);
		f.add(sjgl);
		f.setVisible(visible);
	}
}
