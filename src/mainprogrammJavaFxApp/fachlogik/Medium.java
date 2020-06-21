package mainprogrammJavaFxApp.fachlogik;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium implements Comparable<Medium>,Serializable{

	private static final long serialVersionUID = -4460780330614735434L;
	
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
	
	//Defaultkonstruktor
	public Medium() {
		this.id = idCounter;
		idCounter++;
		this.titel="";
		this.jahr=0;
	}
	
	//Statische klassenattribute sind direkt vor Benutzung der klasse verfugbar
	//dh. Zugriff darauf moeglich ohne, dass die eine Instanz der Klasse exisitert/benutzt wird
	//deswegen statisch
	public static void update(int newCounter) {
		idCounter = newCounter;
	}
	
	public int getCount() {
		return idCounter;
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
	
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public int getJahr() {
		return jahr;
	}
	
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	
	public abstract void druckeDaten();
	public abstract void druckeDaten(OutputStream stream);
	
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
