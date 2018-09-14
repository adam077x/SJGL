package sjgl.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{
	private static boolean pressed = false;
	private static boolean clicked = false;
	private static boolean entered = false;
	private static int x, y;
	
	public void mouseClicked(MouseEvent e) {
		clicked = true;
		x = e.getX();
		y = e.getY();
	}

	public void mouseEntered(MouseEvent e) {
		entered = true;
		x = e.getX();
		y = e.getY();
	}

	public void mouseExited(MouseEvent e) {
		entered = false;
		x = e.getX();
		y = e.getY();
	}

	public void mousePressed(MouseEvent e) {
		pressed = true;
		x = e.getX();
		y = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		pressed = false;
		x = e.getX();
		y = e.getY();
	}

	public static boolean isPressed() {
		return pressed;
	}

	public static boolean isClicked() {
		return clicked;
	}

	public static boolean isEntered() {
		return entered;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}
}
