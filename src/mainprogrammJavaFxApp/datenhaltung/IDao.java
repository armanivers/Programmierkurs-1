package mainprogrammJavaFxApp.datenhaltung;

import java.util.List;

import mainprogrammJavaFxApp.exceptions.PersistenzException;
import mainprogrammJavaFxApp.fachlogik.Medium;

public interface IDao {
	void save(List<Medium> liste) throws PersistenzException;
	List<Medium> load() throws PersistenzException;
}
