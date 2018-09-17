package sjgl.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sjgl.SJGL;

public class Mouse implements MouseListener{
	private SJGL sjgl;
	
	public Mouse(SJGL sjgl) {
		this.sjgl = sjgl;
	}
	
	public void mouseClicked(MouseEvent e) {
		sjgl.mouseClicked(e);
	}

	public void mouseEntered(MouseEvent e) {
		sjgl.mouseEntered(e);
	}

	public void mouseExited(MouseEvent e) {
		sjgl.mouseExited(e);
	}

	public void mousePressed(MouseEvent e) {
		sjgl.mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) {
		sjgl.mouseReleased(e);
	}
}
