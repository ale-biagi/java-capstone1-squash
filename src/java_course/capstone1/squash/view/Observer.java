package java_course.capstone1.squash.view;

import java_course.capstone1.squash.model.GameObject;
import processing.core.PApplet;

public abstract class Observer {
	
	// this is the base abstract class for all "observers" (views)
	
	// every view must updates elements in the screen
	// so it needs to have it (the "screen" hereby called "display") assigned...
	protected PApplet display;	
	protected GameObject object;
	
	public Observer(PApplet display, GameObject object) {
		// ...therefore it's done here in the constructor...
		this.display = display;
		
		// ...as well have it attached to the object that's going to be "observed"
		object.attach(this);
		this.object = object;
	}
	
	// finally and observer must "update" the screen in its own way
	public abstract void update();
}
