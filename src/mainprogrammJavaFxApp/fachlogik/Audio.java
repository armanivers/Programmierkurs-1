package mainprogrammJavaFxApp.fachlogik;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;

public class Audio extends Medium implements Serializable{

	private static final long serialVersionUID = 2407661975267925078L;
	
	private String interpret;
	private int dauer;
	
	public Audio(String titel, int jahr, String interpret, int dauer) {
		super(titel, jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}
	
	//Standartkonstruktor
	public Audio() {
		super();
		this.interpret = "";
		this.dauer=0;
	}
	
	public String getInterpret() {
		return interpret;
	}
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}
	
	public int getDauer() {
		return dauer;
	}
	public void setDauer(int dauer) {
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
	public void druckeDaten(OutputStream os) {
		// --> in Medienverwaltung muss uberall System.out stehen??
		PrintWriter pw = new PrintWriter(os);
		String ausgabe = "ID = " + super.getId() + " " + super.getTitel() + " von " + this.interpret + " aus "
				+ super.getJahr() + " Spieldauer: " + this.dauer + " sek.";
		pw.printf(ausgabe + "\n");
		pw.flush();
		
		//try with ressources NUR fur klassen die autoclosable implentieren, hier ist es falsch!
//		try(PrintStream ps = new PrintStream(os);){
//			ps.print(ausgabe.toCharArray());
//			ps.flush();
//			//ps.printf(ausgabe);
//		}
		

	}
	
	@Override
	public void druckeDaten() {
		System.out.println("ID = " +super.getId() +" " +super.getTitel() +" von " +this.interpret +" aus " +super.getJahr() +" Spieldauer: " +this.dauer +" sek.");
	}
	
	@Override
	public String toString() {
		return "ID = " +super.getId() +" " +super.getTitel() +" von " +this.interpret +" aus " +super.getJahr() +" Spieldauer: " +this.dauer +" sek.";
	}

}
