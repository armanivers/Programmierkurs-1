package mainprogramm;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
	static Medienverwaltung verwaltung = new Medienverwaltung();

	public static void start() {

		// Beispielmedien
		Audio audio1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		Audio audio2 = new Audio("It Means Nothing", 2010, "Stereophonics", 229);
		Bild bild1 = new Bild("Gebaude FB Informatik", 2019, "Dortmund");
		Bild bild2 = new Bild("Eiffelturm", 2020, "Paris");

		verwaltung.aufnehmen(audio1);
		verwaltung.aufnehmen(audio2);
		verwaltung.aufnehmen(bild1);
		verwaltung.aufnehmen(bild2);

		Scanner s = new Scanner(System.in);
		int auswahl;

		boolean run = true;
		while (run) {

			// Menupunkte auf Konsole anzeigen
			System.out.printf("1. Audio aufnehmen \n2. Bild aufnehmen \n3. Zeige alle Medien \n4. Zeige neues Medium "
					+ "\n5. Berechne durschnittliches Erscheinungsjahr \n6. Beenden \n \nBitte Menuepunkt waehlen:");
			auswahl = s.nextInt();
			switch (auswahl) {
			case 1:
				addAudio();
				break;
			case 2:
				addBild();
				break;
			case 3:
				verwaltung.zeigeMedien();
				break;
			case 4:
				verwaltung.sucheNeuesMedium();
				break;
			case 5:
				System.out.println(verwaltung.berechneErscheinungsjahr());
				break;
			case 6:
				run = false;
				break;
			default:
			}

		}
	}

	public static void addAudio() {
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

		verwaltung.aufnehmen(new Audio(titel, jahr, interpret, dauer));
	}

	public static void addBild() {
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
		verwaltung.aufnehmen(new Bild(titel, jahr, ort));
	}
}
