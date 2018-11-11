package sjgl.text;

import java.awt.Color;
import java.awt.Font;

import sjgl.SJGL;
import sjgl.graphics.Graphics;
import sjgl.object.GameObject;
import sjgl.vectors.Vector2;

public class Text implements GameObject{
	public Vector2 position;
	public String text;
	public Font font;
	
	public Text(Vector2 position, String text, Font font) {
		this.position = position;
		this.text = text;
		this.font = font;
	}

	@Override
	public void onRender(Graphics g) {
		SJGL.g.setFont(font);
		g.drawString(text, 50, 50, Color.WHITE);
	}

	@Override
	public void onUpdate() {
		
	}

}
