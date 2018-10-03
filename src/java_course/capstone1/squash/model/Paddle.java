package java_course.capstone1.squash.model;

public class Paddle extends GameObject {

	// these constructors just expose the super class constructors
	public Paddle(ScoreBoard scorer, ScreenPosition screenposition, Size size, int direction) {
		super(scorer, screenposition, size, direction);
	}

	public Paddle(ScoreBoard scorer, ScreenPosition screenposition, Size size) {
		super(scorer, screenposition, size);
	}

	public Paddle(ScoreBoard scorer) {
		// paddle is constructed with the default width and height of the class size and positioned at screen center
		super(scorer, new ScreenPosition((int)((Screen.WIDTH - new Size().width) / 2), Screen.HEIGHT - (new Size().height) - 5),
			  new Size());
		// initial moving state is "stopped"
		this.keepMoving = false;
		// assign the scorer object
		this.scorer = scorer;
	}

	@Override
	protected void bounce() {
		// this is the bounce specific behavior of a paddle
		// paddle bounces when it hits either the right or left bounds of the screen 
		if (this.direction == Direction.RIGHT) {
			if (this.screenPosition.x + this.size.width >= Screen.WIDTH) this.direction = Direction.LEFT;
		}
		else {
			if (this.screenPosition.x <= 0) this.direction = Direction.RIGHT;
		}		
	}
}
