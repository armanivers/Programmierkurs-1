package mainpackage;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {

	public static void start() {
		Medienverwaltung verwaltung = new Medienverwaltung();

		//Beispielmedien
		Audio audio1 = new Audio("It Means Nothing",2007,"Stereophonics",229);
		Audio audio2 = new Audio("It Means Nothing",2010,"Stereophonics",229);
		Bild bild1 = new Bild("Gebaude FB Informatik",2019,"Dortmund");
		Bild bild2 = new Bild("Eiffelturm",2020,"Paris");
		
		verwaltung.aufnehmen(audio1);
		verwaltung.aufnehmen(audio2);
		verwaltung.aufnehmen(bild1);
		verwaltung.aufnehmen(bild2);
		
		Scanner s = new Scanner(System.in);
		
		int auswahl;
		
		boolean run = true;
		while (run) {
			
			//Menupunkte auf Konsole anzeigen
			System.out.printf(
					"1. Audio aufnehmen \n2. Bild aufnehmen \n3. Zeige alle Medien \n4. Zeige neues Medium "
					+ "\n5. Berechne durschnittliches Erscheinungsjahr \n6. Beenden \n \nBitte Menuepunkt waehlen:");
			auswahl = s.nextInt();
			switch(auswahl) {
			case 1:
				String titel = JOptionPane.showInputDialog(null,"Titel eingeben");
				String jahrString = JOptionPane.showInputDialog(null,"Jahr eingeben");
				int jahr = Integer.parseInt(jahrString);
				String interpret = JOptionPane.showInputDialog(null,"Interpret eingeben");
				String dauerString = JOptionPane.showInputDialog(null,"Dauer eingeben");
				int dauer = Integer.parseInt(dauerString);
				verwaltung.aufnehmen(new Audio(titel,jahr,interpret,dauer));
				break;
			case 2:
				titel = JOptionPane.showInputDialog(null,"Titel eingeben");
				jahrString = JOptionPane.showInputDialog(null,"Jahr eingeben");
				jahr = Integer.parseInt(jahrString);
				String ort = JOptionPane.showInputDialog(null,"Ort eingeben");
				verwaltung.aufnehmen(new Bild(titel,jahr,ort));
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
}
