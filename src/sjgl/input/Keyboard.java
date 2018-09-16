package sjgl.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Keyboard implements KeyListener {
	public static ArrayList<Integer> keys = new ArrayList<Integer>();

	public void keyPressed(KeyEvent e) {
		keys.add(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		for(int i = 0; i < keys.size(); i++) {
			keys.remove(keys.get(i));
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public static boolean isKeyDown(int k) {
		for (int i = 0; i < keys.size(); i++) {
			if (k == keys.get(i).intValue()) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isKeyUp(int k) {
		for (int i = 0; i < keys.size(); i++) {
			if (k == keys.get(i).intValue()) {
				return false;
			}
		}
		return true;
	}
}