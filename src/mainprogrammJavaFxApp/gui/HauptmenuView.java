package mainprogrammJavaFxApp.gui;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainprogrammJavaFxApp.fachlogik.Audio;

public class HauptmenuView extends Stage{

	public void showView() {
		
		BorderPane bp = new BorderPane();
		
		//Menubar erzeugen
		MenuBar mb = new MenuBar();
		
		//Menu "Datei:
		Menu datei = new Menu("Datei");
		//Untermenues von "Datei"
		MenuItem laden = new MenuItem("Laden");
		MenuItem speichern = new MenuItem("Speichern");
		MenuItem medienlisteInDatei = new MenuItem("Medienliste in Datei");
		MenuItem beenden = new MenuItem("Beenden");
		//Menues hinzufuegen
		datei.getItems().addAll(laden,speichern,new SeparatorMenuItem(),medienlisteInDatei,new SeparatorMenuItem(),beenden);
		
		//Menu "Medium"
		Menu medium = new Menu("Medium");
		//Untermenues von "Medium"
		MenuItem audioNeu = new MenuItem("Audio neu");
		MenuItem bildNeu = new MenuItem("Bild neu");
		//Menues hinzufuegen
		medium.getItems().addAll(audioNeu,bildNeu);
		
		//Menu "Anzeige"
		Menu anzeige = new Menu("Anzeige");
		//Untermenues von "Anzeige"
		MenuItem erscheinungsJahr = new MenuItem("Erscheinungsjahr");
		MenuItem neustesMedium = new MenuItem("Neustes Medium");
		//Menues hinzufuegen
		anzeige.getItems().addAll(erscheinungsJahr,neustesMedium);
		
		//alle obermenues hinzufuegen in menuebar
		mb.getMenus().addAll(datei,medium,anzeige);
		
		bp.setTop(mb);
		Scene scene = new Scene(bp);
		
		this.setTitle("Medienverwaltung");
		this.setScene(scene);
		this.show();
		
		AudioErfassungView af = new AudioErfassungView(this,new Audio("Testaudio",1999,"Testinterpret",25));
		af.showView();
	}
	
	
}
