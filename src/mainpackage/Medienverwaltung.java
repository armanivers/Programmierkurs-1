package mainpackage;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Assoziation/Speicher mittels einer typsicheren LinkedList (Collection) realisiert
public class Medienverwaltung {

	private List<Medium> medien;

	public Medienverwaltung() {
		medien = new LinkedList<Medium>();
	}

	public void aufnehmen(Medium m) {
		medien.add(m); 
		System.out.println("Folgendes Medium wurde aufgenommen:");
		m.druckeDaten();
	}

	public void zeigeMedien() {
		if(medien.isEmpty()) return;
		
		/*
		//Sort mit Comparator als anonyme Klasse
		Collections.sort(medien,new Comparator<Medium>() {
			@Override
			public int compare(Medium l, Medium r) {
				if(l.getJahr() > r.getJahr()) return 1;
				if(l.getJahr() < r.getJahr()) return -1;
				return 0;
			}
		});
		//linkedlist.sort mit anonyme comparator klasse
		medien.sort(new Comparator<Medium>() {
			@Override
			public int compare(Medium l, Medium r) {
				if(l.getJahr() > r.getJahr()) return 1;
				if(l.getJahr() < r.getJahr()) return -1;
				return 0;
			}
		});
		*/
		
		//Comperator oben vielleicht besser, um nullreferenzen zu vermeiden?
		//Sort, indem Interface comparable in den zu vergleichenden Klassen implementiert wurde
		Collections.sort(medien);
		Iterator<Medium> it = medien.iterator();
		while(it.hasNext()) {
			it.next().druckeDaten();;
		}
	}

	public void sucheNeuesMedium() {

		if(medien.isEmpty()) return;
		if(medien.size() == 1) ((Medium)medien.get(0)).druckeDaten();

		Medium currentMin = (Medium) medien.get(0);
		
		for(Medium medium : medien) {
			if(medium.getJahr() < currentMin.getJahr()) {
				currentMin = medium;
			}
		}

		currentMin.druckeDaten();
	}

	//Durschnittserscheinungsjahr
	public double berechneErscheinungsjahr() {
		if(medien.isEmpty()) return 0.0;

		int median=0;
		int anzahl = 0;
		
		for(Medium medium: this.medien) {
			anzahl++;
			median+=medium.getJahr();
		}
		
		return median/anzahl;
	}

}
