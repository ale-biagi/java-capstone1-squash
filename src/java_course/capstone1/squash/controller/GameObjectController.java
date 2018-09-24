package java_course.capstone1.squash.controller;

import java_course.capstone1.squash.model.GameObject;

public abstract class GameObjectController {
	
	// this is the base abstract class for every game object (element) controller
	// all controllers must have a game object assigned to them...
	protected GameObject gameObject;

	public GameObjectController(GameObject gameObject) {
		// ...which is done here in the constructor...
		this.gameObject = gameObject;
	}
	
	// ... and must at least be able to call the object's "move" method
	public void move() {
		gameObject.move();
	}
}
