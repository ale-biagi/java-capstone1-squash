package java_course.capstone1.squash.controller;

import java_course.capstone1.squash.model.Direction;
import java_course.capstone1.squash.model.GameObject;
import processing.event.KeyEvent;

public class PaddleController extends GameObjectController {

	// this is the controller class for a paddle
	
	// it exposes its super class constructor...
	public PaddleController(GameObject gameObject) {
		super(gameObject);
	}

	// ...and additionally handle the key pressing event
	public void handleEvent(KeyEvent event) {
		// get the code for the pressed key
		int keyCode = event.getKeyCode();
		if (keyCode != 32 && keyCode != 37 && keyCode != 39) return;
		
		if(keyCode == 32) {
			// stop moving the object when the "space" key is hit
			gameObject.keepMoving = false;
		} else {
			// change the object direction when the left or right "arrow" keys are hit
			gameObject.direction = (keyCode == 37) ? Direction.LEFT : Direction.RIGHT;
			// start moving the object
			gameObject.keepMoving = true;
		}
	}
}
