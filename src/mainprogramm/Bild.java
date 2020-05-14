package mainprogramm;
import java.util.Objects;

public class Bild extends Medium{
	private String ort;
	
	public Bild(String titel, int jahr, String ort) {
		super(titel,jahr);
		this.ort = ort;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this!=obj || (!(obj instanceof Audio))) {
			return false;
		}
		
		Bild b = (Bild) obj;
		
		return super.equals(b) && ort.equals(b.ort);
		//super.equals(bild) nutzen fur Attribute von Medium
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(),ort);
	}
	
	public void druckeDaten() {
		System.out.println("ID = " +super.getId() +" " +super.getTitel() +" aufgenommen im Jahr " +super.getJahr() +" in " +this.ort);
	}


	
}
