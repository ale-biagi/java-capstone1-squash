package java_course.capstone1.squash;

import java_course.capstone1.squash.controller.*;
import java_course.capstone1.squash.model.*;
import java_course.capstone1.squash.view.*;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class SquashGame extends PApplet {

	// define the game elements (game objects) and their respective controllers
	private Paddle paddle;
	private PaddleController paddleController;

	private Ball ball;
	private BallController ballController;
	
	@Override
	public void settings() {
		// setup screen size
		// OBS: modify the values of the constants WIDTH and HEIGHT in the Screen class to change screen size
		size(Screen.WIDTH, Screen.HEIGHT);
	}

	@Override
	public void setup() {  
		frameRate(30);
		
		// create the paddle with respective controller and view (observer)
		paddle = new Paddle();
		paddleController = new PaddleController(paddle);
		new PaddleView(this, paddle).update();
		
		// create the ball with respective controller and view (observer)
		ball = new Ball(paddle);
		ballController = new BallController(ball);
		new BallView(this, ball).update();
	}

	@Override
	public void draw() {
		// infinite loop that keeps refreshing the background and moving game elements
		this.background(204);
        paddleController.move();
        ballController.move();
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		// handle the key pressing event
		paddleController.handleEvent(event);
	}
}
