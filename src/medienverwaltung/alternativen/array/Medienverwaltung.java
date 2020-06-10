package medienverwaltung.alternativen.array;

import mainprogrammConsoleApp.Medium;

// Assoziation/Speicher mittels eines Arrays mit maximaler Speicher von 10 Objekte realisiert
public class Medienverwaltung {

	private static int maxAnzahl = 10;
	private int currentAnzahl;
	private Medium medien[];
	
	public Medienverwaltung() {
		currentAnzahl = 0;
		medien = new Medium[maxAnzahl];
	}
	
	public void aufnehmen(Medium m) {
		if(currentAnzahl >= maxAnzahl) {
			System.out.println("Medium wurde nicht aufgenommen, kein Speicherplatz da");
		}
		else {
			medien[currentAnzahl] = m;
			currentAnzahl++;
			System.out.println("Folgendes Medium wurde aufgenommen:");
			m.druckeDaten();
		}
	}
	
	public void zeigeMedien() {
		for(int i = 0 ; i < currentAnzahl ; i++) {
			medien[i].druckeDaten();
		}
	}
	
	public void sucheNeuesMedium(Medium m) {
		
		if(currentAnzahl == 0) return;
		if(currentAnzahl == 1) medien[0].druckeDaten();
		
		Medium min = medien[0];
		int minJahr = min.getJahr();
		for(int i = 1; i <= maxAnzahl ; i++) {
			if(medien[i].getJahr() < minJahr) {
				min = medien[i];
				minJahr = min.getJahr();
			}
		}
		
		min.druckeDaten();
	}
	
	public double berechneErscheinungsjahr() {
		if(currentAnzahl == 0) return 0.0;
		
		double median=0;
		for(int i = 0; i <= maxAnzahl; i++) {
			median+=medien[i].getJahr();
		}
		return median/(double)currentAnzahl;
	}
	
}
