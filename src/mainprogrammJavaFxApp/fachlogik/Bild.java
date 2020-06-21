package mainprogrammJavaFxApp.fachlogik;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;

public class Bild extends Medium implements Serializable{

	private static final long serialVersionUID = -7300990481800973123L;
	
	private String ort;
	
	public Bild(String titel, int jahr, String ort) {
		super(titel,jahr);
		this.ort = ort;
	}

	//Standartkonstruktor
	public Bild() {
		super();
		this.ort = "";
	}
	
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
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
	
	@Override
	public void druckeDaten(OutputStream os) {
		PrintWriter osw = new PrintWriter(os);
		String ausgabe = "ID = " + super.getId() + " " + super.getTitel() + " aufgenommen im Jahr " + super.getJahr()
				+ " in " + this.ort;
		osw.printf(ausgabe + "\n");
		osw.flush();
		
		/* try with ressources nur wenn klasse (hier stream) autoclosable implementiert
		try(PrintStream ps = new PrintStream(os);){
			// osw.write(ausgabe.toCharArray());
			// osw.flush();
			// ps.printf(ausgabe);
		}
		*/
	}
	
	@Override
	public void druckeDaten() {
		System.out.println("ID = " +super.getId() +" " +super.getTitel() +" aufgenommen im Jahr " +super.getJahr() +" in " +this.ort);
	}
	
	@Override
	public String toString() {
		return "ID = " +super.getId() +" " +super.getTitel() +" aufgenommen im Jahr " +super.getJahr() +" in " +this.ort;
	}

}
