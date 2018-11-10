package sjgl.object;

import sjgl.graphics.Graphics;

public interface GameObject {
	public void onRender(Graphics g);
	public void onUpdate();
}
