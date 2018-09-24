package java_course.capstone1.squash.view;

import java_course.capstone1.squash.model.GameObject;
import processing.core.PApplet;

public class BallView extends Observer {
	
	// this observer observes the state and behavior of a ball to update the screen
	// so it needs to have a ball object assigned...

	public BallView(PApplet display, GameObject object) {
		// ...which is done by its supper class constructor
		super(display, object);
	}

	@Override
	public void update() {
		// a ball is drawn as an "ellipse" at the screen
		display.fill(255,255,255);
		display.stroke(0);
		display.ellipse(this.object.screenPosition.x,
						this.object.screenPosition.y,
						this.object.size.width,
						this.object.size.height);
		display.redraw();
	}
	
}
