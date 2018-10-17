package java_course.capstone1.squash.model;

import java_course.capstone1.squash.view.Observer;

public interface Observable {
	// every "observable" object (like game elements) must attach "observers" (views) to it...
	void attach(Observer observer);
	// ..and notify them whenever something relevant to be displayed changes.
	void notifyAllObservers();
}
