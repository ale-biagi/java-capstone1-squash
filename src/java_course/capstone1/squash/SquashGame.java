package java_course.capstone1.squash;

import java_course.capstone1.squash.controller.*;
import java_course.capstone1.squash.model.*;
import java_course.capstone1.squash.view.*;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class SquashGame extends PApplet {

	// define the screen elements (screen objects) and their respective controllers
	private ScoreBoard scoreBoard;
	private ScreenObjectController scoreBoardController;
	
	private Background background;
	private ScreenObjectController backgroundController;
	
	// define the game elements (game objects) and their respective controllers
	private Paddle paddle;
	private PaddleController paddleController;

	private Ball ball;
	private BallController ballController;
	
	@Override
	public void settings() {
		// setup screen size and frame rate
		// OBS: modify the values of the constants WIDTH and HEIGHT in the Screen class to change screen size
		size(Screen.WIDTH, Screen.HEIGHT);
	}

	@Override
	public void setup() {  
		frameRate(30);

		scoreBoard = new ScoreBoard();
		scoreBoardController = new ScreenObjectController(scoreBoard);
		new ScoreBoardView(this, scoreBoard).update();
		
		// create the background with respective controller and view (observer)
		background = new Background();
		backgroundController = new ScreenObjectController(background);
		new BackgroundView(this, background).update();
		
		// create the paddle with respective controller and view (observer)
		paddle = new Paddle(scoreBoard);
		paddleController = new PaddleController(paddle);
		new PaddleView(this, paddle).update();
		
		// create the ball with respective controller and view (observer)
		ball = new Ball(paddle, scoreBoard);
		ballController = new BallController(ball);
		new BallView(this, ball).update();
	}

	@Override
	public void draw() {
		// infinite loop that keeps refreshing the background and moving game elements
		scoreBoardController.draw();
		backgroundController.draw();
        paddleController.move();
        ballController.move();
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		// restart game if it was over
		if (scoreBoard.balls < 0 && event.getKeyCode() == 17) {
			scoreBoard.score = 0;
			scoreBoard.balls = 2;
			ball.keepMoving = true;
		}
		
		// handle the key pressing event
		paddleController.handleEvent(event);
	}
}
