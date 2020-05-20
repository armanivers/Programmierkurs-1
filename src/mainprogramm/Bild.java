package mainprogramm;
import java.io.OutputStream;
import java.io.PrintWriter;
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
	
	@Override
	public void druckeDaten(OutputStream os) {
		// --> in Medienverwaltung muss uberall System.out stehen??
		PrintWriter osw = new PrintWriter(os);
		String ausgabe = "ID = " + super.getId() + " " + super.getTitel() + " aufgenommen im Jahr " + super.getJahr()
				+ " in " + this.ort;
		osw.printf(ausgabe + "\n");
		osw.flush();
		
		/* funktioniert nicht in try block? Kommt hier nie eine Exception?
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

}
