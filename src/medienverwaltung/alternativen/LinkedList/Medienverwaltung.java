package medienverwaltung.alternativen.LinkedList;
import java.util.Iterator;
import java.util.LinkedList;

import mainprogramm.Medium;

// Assoziation/Speicher mittels einer nicht typsicheren LinkedList (Collection) realisiert
public class Medienverwaltung {

	private LinkedList medien;

	public Medienverwaltung() {
		medien = new LinkedList();
	}

	public void aufnehmen(Medium m) {
		medien.add(m); 
		System.out.println("Folgendes Medium wurde aufgenommen:");
		m.druckeDaten();
	}

	public void zeigeMedien() {
		Iterator it = medien.iterator();
		Medium tmp = null;
		while(it.hasNext()) {
			((Medium) it.next()).druckeDaten();
		}
	}

	public void sucheNeuesMedium(Medium m) {

		if(medien.isEmpty()) return;
		if(medien.size() == 1) ((Medium)medien.get(0)).druckeDaten();

		Medium min = (Medium) medien.get(0);
		int minJahr= min.getJahr();
		
		//Wie mache ich erweiterte For-schleife wenn die collection nicht typisiert ist?
		for(Object med : medien) {
			Medium n = (Medium)med;
			if(n.getJahr() > min.getJahr()) {
				
			}
		}
		
		for(int i = 1; i <= medien.size(); i++) {
			if(((Medium)medien.get(i)).getJahr() < minJahr) {
				min = (Medium)medien.get(i);
				minJahr = min.getJahr();
			}
		}

		min.druckeDaten();
	}

	public double berechneErscheinungsjahr() {
		if(medien.size() == 0) return 0.0;

		double median=0;
		
		for(int i = 0; i <= medien.size(); i++) {
			median+=((Medium)medien.get(i)).getJahr();
		}
		
		return median/(double)medien.size();
	}

}
