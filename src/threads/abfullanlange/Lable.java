package threads.abfullanlange;

public class Lable {
	
	private String type;
	private int bestBefore;
	
	public Lable(String type, int bestBefore) {
		this.type = type;
		this.bestBefore = bestBefore+1;
	}
	
	public String toString() {
		return type +" mindestens haltbar bis "+bestBefore;
	}
}
