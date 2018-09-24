package java_course.capstone1.squash.model;

import java.util.ArrayList;
import java.util.List;

import java_course.capstone1.squash.view.Observer;

public abstract class GameObject implements Observable, Movable {
	
	// this is the base abstract class for every game object (element)
	// every element is observable by and "observer" (view) and can be moved along the screen
	
	// every element has a position in the screen, a size, a direction to move and a moving state (moving or stopped)
	public ScreenPosition screenPosition;
	public Size size;
	public int direction;
	public boolean keepMoving = false;
	
	protected List<Observer> observers = new ArrayList<Observer>();

	public GameObject(ScreenPosition screenPosition, Size size, int direction) {
		this.screenPosition = screenPosition;
		this.size = size;
		this.direction = direction;
	}
	
	public GameObject(ScreenPosition screenPosition, Size size) {
		this.screenPosition = screenPosition;
		this.size = size;
		this.direction = Direction.RIGHT;
	}
	
	@Override
	public void attach(Observer observer) {
		// attach an observer (view)
		observers.add(observer);
	}

	@Override
	public void notifyAllObservers() {
		// notify all attached observers to update their view state
		for(Observer observer : observers) {
			observer.update();
		}
	}

	@Override
	public void move() {
		// moving is a standard behavior of every game element
		if (!this.keepMoving) {
			// when stopped it just notifies the observers and do nothing else
			notifyAllObservers();
			return;
		}

		// when moving it takes into account its current direction
		// and makes the appropriate adjustments to its position in the screen
		switch (this.direction) {
		case Direction.LEFT 		: screenPosition.x-=5; break;
		case Direction.RIGHT 		: screenPosition.x+=5; break;
		case Direction.DOWN 		: screenPosition.y+=5; break;
		case Direction.UP 			: screenPosition.y-=5; break;
		case Direction.LEFT_DOWN 	: screenPosition.x-=5; screenPosition.y+=5; break;
		case Direction.LEFT_UP 		: screenPosition.x-=5; screenPosition.y-=5; break;
		case Direction.RIGHT_DOWN 	: screenPosition.x+=5; screenPosition.y+=5; break;
		case Direction.RIGHT_UP 	: screenPosition.x+=5; screenPosition.y-=5; break;
		}

		// it also may bounce when something is hit
		this.bounce();
		
		// finally the observers get notified about the changes made by the moving behavior
		notifyAllObservers();
	}
	
	// moving is a standard behavior for every game element, but each specific element may bounce in a different way
	// so bounce is abstract behavior that must be implemented by each specific game element
	protected abstract void bounce();
}
