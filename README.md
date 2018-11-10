# SJGL
SJGL is a library that makes game development in Java easier.

## Here is some example code for start

```Java
import java.awt.Color;

import sjgl.SJGL;
import sjgl.graphics.Graphics;

public class Main extends SJGL {

	public Main() {
		createDisplay(800, 600, "Example for SJGL");
	}
	
	public static void main(String[] args) {
		new Main();
	}
 
	@Override
	public void onStart() {
		
	}
 
	@Override
	public void onClose() {
		
	}

	@Override
	public void onRender() {
		Graphics g = new Graphics(); // NOTE: Be sure that you import the sjgl.graphics.Graphics class instead of java.awt.Graphics
		g.fillRect(0, 0, 800, 600, Color.BLACK);
		
		g.fillOval(10, 10, 150, 120, Color.CYAN);
	}

	@Override
	public void onUpdate() {
		// NOTE: This function will be executed 60 times per second
	}
}
```
[Download SJGL 1.3 Beta](http://github.com/adam077x/SJGL/releases/download/1.3b/sjgl1.3b.jar)
