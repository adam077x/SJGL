package sjgl.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import sjgl.SJGL;

public class Keyboard implements KeyListener {
	private SJGL sjgl;
	
	public Keyboard(SJGL sjgl) {
		this.sjgl = sjgl;
	}
	
	public void keyPressed(KeyEvent e) {
		sjgl.onKeyPress(e);
	}

	public void keyReleased(KeyEvent e) {
		sjgl.onKeyRelease(e);
	}

	public void keyTyped(KeyEvent e) {

	}
}