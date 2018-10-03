package java_course.capstone1.squash.view;

import java_course.capstone1.squash.model.ScreenObject;
import processing.core.PApplet;

public class BackgroundView extends Observer {

	// this observer observes the state and behavior of the screen background to update the screen
	// so it needs to have a background object assigned...
	
	public BackgroundView(PApplet display, ScreenObject screen) {
		// ...which is done by its supper class constructor
		super(display, screen);
	}

	@Override
	public void update() {
		// the background is drawn as a "rectangle" at the screen
		display.fill(screen.color.red, screen.color.green, screen.color.blue);
		display.stroke(screen.color.red, screen.color.green, screen.color.blue);
		display.rect(this.screen.screenPosition.x, 
					this.screen.screenPosition.y, 
					this.screen.size.width, 
					this.screen.size.height);
 	    display.redraw();
	}
}
