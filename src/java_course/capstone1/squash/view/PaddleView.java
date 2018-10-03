package java_course.capstone1.squash.view;

import java_course.capstone1.squash.model.GameObject;
import processing.core.PApplet;

public class PaddleView extends Observer {

	// this observer observes the state and behavior of a paddle to update the screen
	// so it needs to have a paddle object assigned...
	
	public PaddleView(PApplet display, GameObject object) {
		// ...which is done by its supper class constructor
		super(display, object);
	}

	@Override
	public void update() {
		// a paddle is drawn as a "rectangle" at the screen
		display.fill(0);
		display.stroke(255,255,255);
		display.rect(this.object.screenPosition.x, 
					this.object.screenPosition.y, 
					this.object.size.width, 
					this.object.size.height);
		display.redraw();
	}
	
}
