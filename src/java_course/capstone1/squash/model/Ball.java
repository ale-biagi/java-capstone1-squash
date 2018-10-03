package java_course.capstone1.squash.model;

import java.util.Random;

public class Ball extends GameObject {

	// ball is a game object and, thus, have all its standard attributes and behaviors
	
	// but ball is an element that can bounce when it "hits" another element (game object)
	// so we associate that "hitting" element to it
	private GameObject bouncer;
	
	// these constructors just expose the super class constructors
	public Ball(ScoreBoard scorer, ScreenPosition screenposition, Size size, int direction) {
		super(scorer, screenposition, size, direction);
	}

	public Ball(ScoreBoard scorer, ScreenPosition screenposition, Size size) {
		super(scorer, screenposition, size);
	}

	public Ball(GameObject bouncer, ScoreBoard scorer) {
		// paddle is constructed with a default size of 30 x 30 pixel and an arbitrary initial position
		super(scorer, new ScreenPosition(0, 10), new Size(30, 30));
		
		// the element which will make the ball bounce is passed in the constructor and assigned to a private attribute
		this.bouncer = bouncer;
		// ball is always moving
		this.keepMoving = true;
		// and a random "x" coordinate is determine for it at the screen as well a moving direction
		this.renew();
	}
	
	private void renew() {
		// a random "x" coordinate is determine at the screen as well a moving direction
		Random rand = new Random();
		
		this.screenPosition.x = rand.nextInt(Screen.WIDTH - this.size.width - 5) + 10;
		this.screenPosition.y = 67;
		
		int d = (rand.nextInt(3) + 1) * 2;
		while (d == this.direction) { d = (rand.nextInt(3) + 1) * 2; }
		this.direction = d;

		// one ball less
		this.scorer.balls--;
	}
	
	@Override
	protected void bounce() {
		// this is the bounce specific behavior of a ball
		// some auxiliary calculations are done to help check whether it hit something or fell off screen
		int rightUpperX = (this.screenPosition.x + this.size.width) - 10;
		int rightLowerY = (this.screenPosition.y + this.size.height) - 10;
		
		int bouncerRightUpperX = this.bouncer.screenPosition.x + this.bouncer.size.width;

		if (rightLowerY >= Screen.HEIGHT) {
			// ball feel off screen
			this.renew();
			return;
		}
		
		// this is needed to generate random directions
		Random rand = new Random();

		if (this.screenPosition.x <= 10	||
			this.screenPosition.y <= 67	||
			rightUpperX >= Screen.WIDTH) {
			// ball hit screen bounds
			if (this.screenPosition.x <= 10) {
				// ball hit left bound
				int opposite = 	(this.direction == Direction.LEFT) ? Direction.RIGHT : 
								(this.direction == Direction.LEFT_UP) ? Direction.RIGHT_DOWN : 
								(this.direction == Direction.LEFT_DOWN) ? Direction.RIGHT_UP : 
								this.direction;
				int d = (rand.nextInt(7) + 1);
				while(d == 2 || d == 3 || d == 4 || d == 5 || d == opposite) { d = (rand.nextInt(7) + 1); }
				this.direction = d;
			} else {
				if (this.screenPosition.y <= 67) {
					// ball hit upper bound
					int opposite = 	(this.direction == Direction.UP) ? Direction.DOWN : 
									(this.direction == Direction.LEFT_UP) ? Direction.RIGHT_DOWN : 
									(this.direction == Direction.RIGHT_UP) ? Direction.LEFT_DOWN : 
									this.direction;
					int d = (rand.nextInt(3) + 1) * 2;
					while(d == opposite) { d = (rand.nextInt(3) + 1) * 2; }
					this.direction = d;
					 
					// some points should be earned (the closest to the middle, the higher the score)
					int points = (this.screenPosition.x <= (Screen.WIDTH / 2)) ? (this.screenPosition.x * 100) / (Screen.WIDTH / 2) : ((Screen.WIDTH / 2) * 100) / this.screenPosition.x;
					this.scorer.score += points;
				} else {
					// ball hit right bound
					int opposite = 	(this.direction == Direction.RIGHT) ? Direction.LEFT : 
									(this.direction == Direction.RIGHT_UP) ? Direction.LEFT_DOWN : 
									(this.direction == Direction.RIGHT_DOWN) ? Direction.LEFT_UP : 
									this.direction;
					int d = rand.nextInt(5);
					while(d == 1 || d == 2 || d == 3 || d == opposite) { d = rand.nextInt(5); }
					this.direction = d;
				}
			}
		} else {
			// ball may hit paddle
			if (rightLowerY >= this.bouncer.screenPosition.y) {
				if (this.screenPosition.x >= this.bouncer.screenPosition.x && rightUpperX <= bouncerRightUpperX) {
					// ball is within paddle body range and hit it's surface
					int opposite = 	(this.direction == Direction.DOWN) ? Direction.UP : 
									(this.direction == Direction.LEFT_DOWN) ? Direction.RIGHT_UP : 
									(this.direction == Direction.RIGHT_DOWN) ? Direction.LEFT_UP : 
									this.direction;
					int d = ((rand.nextInt(3) + 1) * 2) + 1;
					while(d == opposite) { d = ((rand.nextInt(3) + 1) * 2) + 1; }
					this.direction = d;
				} else {
					// ball is outside paddle body range
					if (this.screenPosition.x < this.bouncer.screenPosition.x &&
						rightUpperX >= this.bouncer.screenPosition.x) {
						// ball hits paddle's left side
						this.direction = Direction.LEFT_UP;
					} else {
						if (this.screenPosition.x > this.bouncer.screenPosition.x && 
							bouncerRightUpperX >= (this.screenPosition.x-20)) {
							// ball hit paddle's right side
							this.direction = Direction.RIGHT_UP;
						}
					}
				}
			}
		}
	}
}
