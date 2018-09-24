package java_course.capstone1.squash;

import processing.core.PApplet;

public class Main {

	public static void main(String[] args) {
		// start the game application in full screen mode
		PApplet.main(new String[]{"--present", SquashGame.class.getName()});
	}

}
