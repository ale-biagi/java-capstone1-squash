package java_course.capstone1.squash.model;

public class ScoreBoard extends ScreenObject {
	
	// the score board object controls the score and the number of balls left
	public int score = 0;
	public int balls = 3;

	public ScoreBoard(ScreenPosition screenPosition, Size size, RGBColor color) {
		super(screenPosition, size, color);
	}

	public ScoreBoard(ScreenPosition screenPosition, Size size) {
		super(screenPosition, size);
	}

	public ScoreBoard() {
		this(new ScreenPosition(), new Size(Screen.WIDTH-1, 50), new RGBColor(255,255,0));
	}
	
	// the score must be displayed using a "999999" mask
	public String displayScore( ) {
		String formatedScore = this.score + "";
		while(formatedScore.length() < 6) formatedScore = "0" + formatedScore;
		
		return(formatedScore);
	}
}
