package threads.abfullanlange;

public class Bottle {
	private Lable l;
	
	public Bottle() {
		
	}
	
	public void setLable(Lable l) {
		this.l = l;
	}
	
	public String printLabel() {
		return l.toString();
	}
	
}
