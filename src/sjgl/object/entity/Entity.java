package sjgl.object.entity;

import sjgl.graphics.Graphics;
import sjgl.object.GameObject;
import sjgl.vectors.Vector2;
import sjgl.vectors.Vector2f;

public abstract class Entity implements GameObject {

	protected Vector2 position, size;
	protected Vector2f velocity;
	
	public Entity(Vector2 position, Vector2 size) {
		this.position = position;
		this.size = size;
		velocity = new Vector2f(0, 0);
	}
	
	@Override
	public abstract void onRender(Graphics g);

	@Override
	public abstract void onUpdate();
}
