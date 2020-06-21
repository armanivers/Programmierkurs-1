package mainprogrammJavaFxApp.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import mainprogrammJavaFxApp.exceptions.EmptyFilenameException;
import mainprogrammJavaFxApp.exceptions.PersistenzException;
import mainprogrammJavaFxApp.fachlogik.Audio;
import mainprogrammJavaFxApp.fachlogik.Bild;
import mainprogrammJavaFxApp.fachlogik.Medienverwaltung;
import mainprogrammJavaFxApp.fachlogik.Medium;
import mainprogrammJavaFxApp.util.InputView;
import mainprogrammJavaFxApp.util.MessageView;

public class Controller{

	private Medienverwaltung mv;
	private Stage stage;
	private ObservableList<String> ol;
	
	public Controller(Stage stage,Medienverwaltung mv) {
		this.mv = mv;
		this.stage = stage;
		this.ol = FXCollections.<String>observableArrayList();
		addTestData();
	}
	
	public void aufnehmenMedium(Medium medium) {
		mv.aufnehmen(medium);
		ol.add(medium.toString());
	}
	
	public void load() throws PersistenzException{
		mv.load();
		zeigeMedien();
	}
	
	public void save() throws PersistenzException{
		mv.save();
	}
	
	public void medienlisteInDatei() {
		String path = "";
		File file = null;
		String filename = null;
		boolean ok = false;
		
		while(!ok) {
			filename = InputView.create(stage, "Dateiname", "Bitte Dateiname eingeben!","Medienlist").showView();
			if (filename == null) {
				return;
			}
			try {
				if (filename.isEmpty()) {
					throw new EmptyFilenameException();
				}
				file = new File(path+filename+".txt");
				ok = true;
			} catch(EmptyFilenameException e) {
				MessageView.create(stage, "Fehler!", "Dateiname ist leer!").show();
			}
			try (FileOutputStream fos = new FileOutputStream(file)){
				mv.zeigeMedien(fos);
				System.out.printf("Datei %s geschrieben.\n",path+filename);
			} catch(FileNotFoundException e) {
				MessageView.create(stage, "Fehler!", "Ungueltige Datei!").show();
			} catch(IOException e) {
				MessageView.create(stage, "Fehler!", "Datei koennte nicht geschrieben werden!").show();
			}
		}
	}
	
	public void AudioNeu() {
		AudioErfassungView aev = new AudioErfassungView(stage,this,new Audio());
		aev.showView();
	}
	
	public void BildNeu() {
		BildErfassungView bev = new BildErfassungView(stage,this,new Bild());
		bev.showView();
	}
	
	public void erscheinungsjahr() {
		String str = String.valueOf(mv.berechneErscheinungsjahr());
		MessageView.create(stage, "Erscheinungsjahr", str).showView();
	}
	
	public void neustesMedium() {
		Medium medium = mv.sucheNeuesMedium();
		System.out.println("TEEEEST");
		MessageView.create(stage, "Neustes Medium", medium.toString()).showView();
	}
	
	public void zeigeMedien() {
		Iterator<Medium> it = mv.iterator();
		
		ol.clear();
		
		while(it.hasNext()) {
			ol.add(it.next().toString());
		}
	}
	
	public ObservableList<String> getObservableList(){
		return ol;
	}
	
	public void addTestData() {
		Audio audio1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
		Audio audio2 = new Audio("It Means Nothing", 2010, "Stereophonics", 229);
		Bild bild1 = new Bild("Gebaude FB Informatik", 2019, "Dortmund");
		Bild bild2 = new Bild("Eiffelturm", 2020, "Paris");
		System.out.println("Ende vom Erstellen von Test-Daten");
		
		aufnehmenMedium(audio1);
		aufnehmenMedium(audio2);
		aufnehmenMedium(bild1);
		aufnehmenMedium(bild2);
		
		System.out.println("Ende von Aufnehmen von Test-Daten");
	}
	
}
