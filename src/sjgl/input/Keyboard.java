package sjgl.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	public static int key;
	
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
	}

	public void keyReleased(KeyEvent e) {
		key = 0;
	}

	public void keyTyped(KeyEvent e) {
		key = e.getKeyCode();
	}
}
