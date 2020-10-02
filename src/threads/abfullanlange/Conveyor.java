package threads.abfullanlange;

import java.util.LinkedList;
import java.util.Queue;

public class Conveyor {

	private int maxBottles;
	private Queue<Bottle> warteschlange;
	
	public Conveyor(int max) {
		warteschlange = new LinkedList<Bottle>();
		maxBottles = max;
	}
	
	public void load(Bottle b) {
		warteschlange.add(b);
	}
	
	public Bottle withdraw() {
		if(isEmpty()) {
			return null;
		}
		return warteschlange.poll();
	}
	
	public boolean isEmpty() {
		return warteschlange.isEmpty();
	}
	
	public boolean isOverloaded() {
		return (warteschlange.size()>=maxBottles);
	}
	
}
