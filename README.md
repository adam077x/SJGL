# SJGL
SJGL is a library that makes game development in Java easier.

## Here is some example code for start

```Java
import java.awt.Color;

import sjgl.SJGL;
import sjgl.display.Display;
import sjgl.graphics.Graphics;

public class Main extends SJGL {

	public Main() {
		Display display = new Display(this);
		display.createDisplay(800, 600, false, "Example for SJGL");
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
		g.clearScreen(Color.BLACK);
		
		g.fillOval(10, 10, 150, 120, Color.CYAN);
	}

	@Override
	public void onUpdate() {
		// NOTE: This function will be executed 60 times per second
	}
}
```
[Download SJGL 1.4.1](http://github.com/adam077x/SJGL/releases/download/1.4.1/sjgl1.4.1.jar)

[Download JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
