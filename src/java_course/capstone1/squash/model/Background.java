package java_course.capstone1.squash.model;

public class Background extends ScreenObject {

	public Background(ScreenPosition screenPosition, Size size, RGBColor color) {
		super(screenPosition, size, color);
	}

	public Background(ScreenPosition screenPosition, Size size) {
		super(screenPosition, size);
	}

	public Background() {
		this(new ScreenPosition(0, 51), new Size(Screen.WIDTH, Screen.HEIGHT-50), new RGBColor(0, 0, 255));
	}

}
