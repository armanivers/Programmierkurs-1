 package mainprogrammJavaFxApp.fachlogik;

import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import mainprogrammJavaFxApp.datenhaltung.Dao;
import mainprogrammJavaFxApp.datenhaltung.IDao;
import mainprogrammJavaFxApp.exceptions.PersistenzException;

// Assoziation/Speicher mittels einer typsicheren LinkedList (Collection) realisiert
public class Medienverwaltung {

	private List<Medium> medien;
	private IDao dao;
	
	public Medienverwaltung(Dao dao) {
		this.dao = dao;
		medien = new LinkedList<Medium>();
		//addTestData();
	}
	
	public void save() throws PersistenzException{
		dao.save(medien);
	}
	
	public void load() throws PersistenzException{
		medien = dao.load();
	}
	
	public void aufnehmen(Medium m) {
		if(m == null) { return; } 
		medien.add(m); 
		System.out.println("Folgendes Medium wurde aufgenommen:");
		m.druckeDaten(System.out);
	}

	public void zeigeMedien(OutputStream stream) {
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
			it.next().druckeDaten(stream);;
		}
	}

	public Medium sucheNeuesMedium() {

		if(medien.isEmpty()) return null;
		if(medien.size() == 1) {
			((Medium)medien.get(0)).druckeDaten(System.out);
			return medien.get(0);
		}

		Medium currentMin = (Medium) medien.get(0);
		
		for(Medium medium : medien) {
			if(medium.getJahr() < currentMin.getJahr()) {
				currentMin = medium;
			}
		}

		return currentMin;
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
	
	public Iterator<Medium> iterator(){
		Iterator<Medium> it = medien.iterator();
		return it;
	}
	
	

}
