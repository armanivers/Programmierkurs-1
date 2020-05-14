package mainprogramm;
import java.util.Objects;

public class Audio extends Medium {
	private String interpret;
	private int dauer;
	
	public Audio(String titel, int jahr, String interpret, int dauer) {
		super(titel, jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || (obj.getClass() != this.getClass())) {
			return false;
		}
		
		Audio a = (Audio) obj;
		
		return super.equals(a) && dauer == a.dauer && interpret.equals(a.interpret);
		//super.equals(audio) nutzen fur Attribute von Medium
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(),interpret,dauer);
	}
	
	@Override
	public void druckeDaten() {
		System.out.println("ID = " +super.getId() +" " +super.getTitel() +" von " +this.interpret +" aus " +super.getJahr() +" Spieldauer: " +this.dauer +" sek.");
	}

}