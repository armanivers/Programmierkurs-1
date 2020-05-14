package mainprogramm;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium implements Comparable<Medium>{
	
	private int id;
	private static int idCounter = 0;
	private String titel;
	private int jahr;
	
	public Medium(String titel, int jahr) {
		this.id = idCounter;
		idCounter++;
		this.titel = titel;
		this.jahr = jahr;
	}
	
	public int alter() {
		return LocalDate.now().getYear() - this.jahr;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitel() {
		return "\""+titel+"\"";
	}
	
	public int getJahr() {
		return jahr;
	}
	
	public abstract void druckeDaten();
	
	@Override
	public boolean equals(Object obj) {
		if( obj == null || (obj.getClass() != this.getClass())) {
			return false;
		}
		
		Medium m = (Medium) obj;
		
		return titel.equals(m.titel) && jahr == m.jahr;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titel,jahr);
	}
	
	@Override
	public int compareTo(Medium r) {
		//Aufsteigend sortieren
		if(this.getJahr() > r.getJahr()) return 1;
		if(this.getJahr() < r.getJahr()) return -1;
		return 0;
	}

}
