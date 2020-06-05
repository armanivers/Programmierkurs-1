package mainprogramm.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class GuiTest extends Application{
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage mainstage) throws Exception {
		Hauptmenu hm = new Hauptmenu();
		hm.showView();
		AudioErfassung af = new AudioErfassung(hm,null);
		af.showView();
		BildErfassung bf = new BildErfassung(hm,null);
		bf.showView();
		
	}
}
