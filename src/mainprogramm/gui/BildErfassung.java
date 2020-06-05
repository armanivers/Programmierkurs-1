package mainprogramm.gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainprogramm.Bild;

public class BildErfassung extends Stage {

	public BildErfassung(Stage parent, Bild b) {
		this.initOwner(parent);
		this.initModality(Modality.WINDOW_MODAL);
	}

	public void showView() {

		GridPane gp = new GridPane();
		// Aussenabstand von Pane allgemein
		gp.setPadding(new Insets(10.0));
		// Abstand oben-unten zwischen Zeilen
		gp.setVgap(10.0);
		// Abstand rechts-links zwischen Spalten
		gp.setHgap(10.0);

		Label titelLabel = new Label("Titel:");
		Label ortLabel = new Label("Ort:");
		Label jahrLabel = new Label("Aufnahmejahr:");

		TextField titelTf = new TextField();
		TextField ortTf = new TextField();
		TextField jahrTf = new TextField();

		Button neu = new Button("Neu");
		Button abbrechen = new Button("Abbrechen");

		gp.add(titelLabel, 0, 0);
		gp.add(ortLabel, 0, 1);
		gp.add(jahrLabel, 0, 2);

		// Text rechtsbunding machen, dh. direkt am Eingabefeld kleben
		GridPane.setHalignment(titelLabel, HPos.RIGHT);
		GridPane.setHalignment(ortLabel, HPos.RIGHT);
		GridPane.setHalignment(jahrLabel, HPos.RIGHT);

		gp.add(titelTf, 1, 0, 8, 1);
		gp.add(ortTf, 1, 1, 8, 1);
		gp.add(jahrTf, 1, 2, 8, 1);

		gp.add(neu, 1, 3);
		gp.add(abbrechen, 2, 3);

		gp.setGridLinesVisible(true);

		GridPane.setHalignment(neu, HPos.RIGHT);
		GridPane.setHalignment(abbrechen, HPos.LEFT);

		Scene scene = new Scene(gp, 300.0, 170.0);
		// debug only!
		gp.setGridLinesVisible(true);
		// debug only!
		this.setResizable(false);
		this.setScene(scene);
		this.setTitle("BildErfassung");
		this.show();

	}
}
