package mainprogrammJavaFxApp.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainprogrammJavaFxApp.datenhaltung.Dao;
import mainprogrammJavaFxApp.exceptions.PersistenzException;
import mainprogrammJavaFxApp.fachlogik.Medienverwaltung;

public class MedienverwaltungView extends Application{

	private Controller controller;
	
	public static void main(String[] args) {
		launch();
	}
	
	public void start(Stage primaryStage) {
		Medienverwaltung mv = new Medienverwaltung(new Dao());
		controller = new Controller(primaryStage,mv);
		
		BorderPane bp = new BorderPane();
		
		//Menubar erzeugen
		MenuBar mb = createMenu();
		bp.setTop(mb);
		
		//Liste mit den medien
		ListView<String> lv = new ListView<String>();
		lv.setItems(controller.getObservableList());
		bp.setCenter(lv);
		
		Scene scene = new Scene(bp,400,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hauptfenster");
		primaryStage.show();
	}
	
	public MenuBar createMenu() {
		
		//Menubar erzeugen
		MenuBar mb = new MenuBar();
		
		//Menu "Datei:
		Menu datei = new Menu("Datei");
		
		//Untermenues von "Datei"
		MenuItem laden = new MenuItem("Laden");
		/*
		laden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					controller.load();
				} catch(PersistenzException p) {
					
				}
			}
		});
		*/
		
		laden.setOnAction(e -> {
			try {
				controller.load();
			} catch(PersistenzException p) {
				
			}
		}
		);
		
		MenuItem speichern = new MenuItem("Speichern");
		/*
		laden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					controller.save();
				} catch(PersistenzException p) {
					
				}
			}
		});
		*/
		
		speichern.setOnAction(e -> {
			try {
				controller.save();
			} catch (PersistenzException p) {

			}
		});
		
		MenuItem medienlisteInDatei = new MenuItem("Medienliste in Datei");
		/*
		medienlisteInDatei.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				controller.medienlisteInDatei();
			}
		});
		*/
		
		medienlisteInDatei.setOnAction(e -> controller.medienlisteInDatei());
		
		MenuItem beenden = new MenuItem("Beenden");
		beenden.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				//close();
			}
		});
		//Menues hinzufuegen
		datei.getItems().addAll(laden,speichern,new SeparatorMenuItem(),medienlisteInDatei,new SeparatorMenuItem(),beenden);
		
		//Menu "Medium"
		Menu medium = new Menu("Medium");
		//Untermenues von "Medium"
		MenuItem audioNeu = new MenuItem("Audio neu");
		/*
		audioNeu.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				controller.AudioNeu();
			}
		});
		*/
		
		audioNeu.setOnAction(e -> controller.AudioNeu());
		
		MenuItem bildNeu = new MenuItem("Bild neu");
		/*
		bildNeu.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				controller.BildNeu();
			}
		});
		*/
		
		bildNeu.setOnAction(e -> controller.BildNeu());
		
		//Menues hinzufuegen
		medium.getItems().addAll(audioNeu,bildNeu);
		
		//Menu "Anzeige"
		Menu anzeige = new Menu("Anzeige");
		//Untermenues von "Anzeige"
		MenuItem erscheinungsJahr = new MenuItem("Erscheinungsjahr");
		/*
		erscheinungsJahr.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				controller.erscheinungsjahr();
			}
		});
		*/
		
		erscheinungsJahr.setOnAction(e -> controller.erscheinungsjahr());
		
		MenuItem neustesMedium = new MenuItem("Neustes Medium");
		/*
		neustesMedium.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				controller.neustesMedium();
			}
		});
		*/
		
		neustesMedium.setOnAction(e -> controller.neustesMedium());
		
		//Menues hinzufuegen
		anzeige.getItems().addAll(erscheinungsJahr,neustesMedium);
		
		//alle obermenues hinzufuegen in menuebar
		mb.getMenus().addAll(datei,medium,anzeige);
		
		return mb;
	}
	
	
}
