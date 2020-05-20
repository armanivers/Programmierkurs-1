package mainprogramm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
	Medienverwaltung mv;
    boolean init = false;
    boolean running = true;
	
	public Menu() {
		mv = new Medienverwaltung();
	}
	
	public void start() {

		while(running) {
			run();
		}
	}
	
	public void run(){
		if(!init) {
			// Beispielmedien
			Audio audio1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
			Audio audio2 = new Audio("It Means Nothing", 2010, "Stereophonics", 229);
			Bild bild1 = new Bild("Gebaude FB Informatik", 2019, "Dortmund");
			Bild bild2 = new Bild("Eiffelturm", 2020, "Paris");
			System.out.println("Ende von objekten");
			mv.aufnehmen(audio1);
			mv.aufnehmen(audio2);
			mv.aufnehmen(bild1);
			mv.aufnehmen(bild2);
			System.out.println("ende von aufnhemen");
			init = true;
		}

		Scanner s = new Scanner(System.in);
		int auswahl;

		running = true;
		while (running) {

			// Menupunkte auf Konsole anzeigen
			System.out.printf("1. Audio aufnehmen \n2. Bild aufnehmen \n3. Zeige alle Medien \n4 Medienliste in Datei schreiben \n5. Zeige neues Medium "
					+ "\n6. Berechne durschnittliches Erscheinungsjahr \n7. Beenden \n \nBitte Menuepunkt waehlen:");
			try {
				auswahl = s.nextInt();
				switch (auswahl) {
				case 1:
					addAudio();
					break;
				case 2:
					addBild();
					break;
				case 3:
					mv.zeigeMedien(System.out);
					break;
				case 4:
					writeToFile();
					break;
				case 5:
					mv.sucheNeuesMedium();
					break;
				case 6:
					System.out.println(mv.berechneErscheinungsjahr());
					break;
				case 7:
					running = false;
					break;
				default:
				}
			}catch(InputMismatchException e) {
				System.out.println("Bitte eine gueltige Zahl eingeben!");
			} catch (EmptyFilenameException e) {
				System.err.println("Dateiname darf nicht leer sein!");
				//e.printStackTrace();
			}
		}
	}

	public void writeToFile() throws EmptyFilenameException {
		String fileName = "";
		fileName = JOptionPane.showInputDialog(null, "Dateiname eingeben");
		if (fileName == null)
			return;
		while (fileName.equals("")) {
				int wahl = JOptionPane.showConfirmDialog(null, "Dateiname ist leer! Neuen Dateinamen wahlen?", "Fehler",JOptionPane.YES_NO_OPTION);
				
				if (wahl == JOptionPane.NO_OPTION) {
					throw new EmptyFilenameException("Dateiname leer!");
				}
				fileName = JOptionPane.showInputDialog(null, "Dateiname eingeben");
				if(fileName == null) return;
		}
		try (FileOutputStream fos = new FileOutputStream(new File(fileName + ".txt"))) {
			mv.zeigeMedien(fos);

		} catch (IOException e) {
			writeToFile();
			e.printStackTrace();
		}
	}
	
	public void addAudio() {
		boolean invalid = true;

		String titel = JOptionPane.showInputDialog(null, "Titel eingeben");
		if (titel == null) return; // benutzt fur cancel button
		int jahr = 0;

		while (invalid) {
			try {
				String jahrString = JOptionPane.showInputDialog(null, "Jahr eingeben");
				if (jahrString == null) return; // benutzt fur cancel button
				jahr = Integer.parseInt(jahrString);
				invalid = false;
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Bitte gueltiges Jahr eingeben!");
			}
		}
		String interpret = JOptionPane.showInputDialog(null, "Interpret eingeben");
		if (interpret == null) return; // benutzt fur cancel button
		int dauer = 0;
		invalid = true;
		while (invalid) {
			try {
				String dauerString = JOptionPane.showInputDialog(null, "Dauer eingeben");
				if (dauerString == null)
					return; // benutzt fur cancel button
				dauer = Integer.parseInt(dauerString);
				invalid = false;
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Bitte gueltiges Dauer eingeben!");
			}
		}

		mv.aufnehmen(new Audio(titel, jahr, interpret, dauer));
	}

	public void addBild() {
		String titel = JOptionPane.showInputDialog(null, "Titel eingeben");
		if(titel == null) return;
		int jahr = 0;
		try {
			String jahrString = JOptionPane.showInputDialog(null, "Jahr eingeben");
			if(jahrString == null) return;
			jahr = Integer.parseInt(jahrString);
		}catch(NumberFormatException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Bitte gueltiges Jahr eingeben!");
		}
		String ort = JOptionPane.showInputDialog(null, "Ort eingeben");
		if(ort == null) return;
		mv.aufnehmen(new Bild(titel, jahr, ort));
	}
}
