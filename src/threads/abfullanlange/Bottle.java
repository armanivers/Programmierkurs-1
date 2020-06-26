package threads.abfullanlange;

public class Bottle {
	private Lable l;
	
	public Bottle() {
		
	}
	
	public void setLable(Lable l) {
		this.l = l;
	}
	
	public void printLabel() {
		System.out.println(l.toString());
	}
	
}
