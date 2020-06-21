package mainprogrammJavaFxApp.datenhaltung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import mainprogrammJavaFxApp.exceptions.PersistenzException;
import mainprogrammJavaFxApp.fachlogik.Medium;

public class Dao implements IDao{

	@Override
	public void save(List<Medium> liste) throws PersistenzException {
		try(FileOutputStream fos = new FileOutputStream(new File("data.ser"));
				ObjectOutputStream ous = new ObjectOutputStream(fos);){
			//Ganze Liste mit Medien serialisieren
			ous.writeObject(liste);
			System.out.println("ERFOLGREICH");
		} catch (IOException e) {
			e.printStackTrace();
			throw new PersistenzException("Fehler beim Speichern der Daten");
		}
	}

	@Override
	public List<Medium> load() throws PersistenzException {
		try(FileInputStream fis = new FileInputStream(new File("data.ser"));
				ObjectInputStream ois = new ObjectInputStream(fis);){
			//Ganze Liste mit Medien deserialisieren
			List<Medium> newList = (LinkedList<Medium>) ois.readObject();
			Medium.update(newList.size());
			System.out.println("ERFOLGREICH");
			return newList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PersistenzException("Fehler beim Laden der Daten");
		} catch (IOException e) {
			e.printStackTrace();
			throw new PersistenzException("Fehler beim Laden der Daten");
		}
	}

}
