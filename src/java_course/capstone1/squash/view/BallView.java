package java_course.capstone1.squash.view;

import java_course.capstone1.squash.model.GameObject;
import java_course.capstone1.squash.model.Screen;
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
		// with no more balls the game is over
		if (this.object.scorer.balls < 0) {
			display.fill(255,0,0);
			display.stroke(255);
			display.rect((Screen.WIDTH - 450)/2,
						this.object.scorer.size.height + ((Screen.HEIGHT - this.object.scorer.size.height)/2) - 50,
						450,
						100);
			display.textSize(48);
			display.fill(255);
			display.text("GAME OVER",((Screen.WIDTH - 450)/2) + 90, this.object.scorer.size.height + ((Screen.HEIGHT - this.object.scorer.size.height)/2) + 18);
			display.redraw();
            return;
		}
		
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
