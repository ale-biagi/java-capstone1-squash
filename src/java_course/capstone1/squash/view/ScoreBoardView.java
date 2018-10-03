package java_course.capstone1.squash.view;

import java_course.capstone1.squash.model.ScoreBoard;
import java_course.capstone1.squash.model.Screen;
import java_course.capstone1.squash.model.ScreenObject;
import processing.core.PApplet;

public class ScoreBoardView extends Observer {

	// this observer observes the state and behavior of the score board to update the screen
	// so it needs to have a score board object assigned...
	
	public ScoreBoardView(PApplet display, ScreenObject screen) {
		// ...which is done by its supper class constructor
		super(display, screen);
	}

	@Override
	public void update() {
		// the score board is drawn as a "rectangle" at the screen
		// panel
		display.fill(screen.color.red, screen.color.green, screen.color.blue);
		display.stroke(0, 0, 0);
		display.rect(this.screen.screenPosition.x, 
					this.screen.screenPosition.y, 
					this.screen.size.width, 
					this.screen.size.height);
		
		// score text
		display.fill(0);
		display.textSize(24);
		display.text("SCORE: " + ((ScoreBoard) this.screen).displayScore(), 12, 34);
		
		// remaining balls
		display.fill(255);
		int x = Screen.WIDTH - 100;
		for (int i = 0; i < ((ScoreBoard) this.screen).balls; i++) {
			display.ellipse(x, 25, 30, 30);
			x += 35;
		}

		// draw everything
 	    display.redraw();
	}
}
