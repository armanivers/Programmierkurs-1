package mainprogrammJavaFxApp.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import mainprogrammJavaFxApp.fachlogik.Audio;
import mainprogrammJavaFxApp.fachlogik.Bild;

public class GuiTest extends Application{
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage mainstage) throws Exception {
		HauptmenuView hm = new HauptmenuView();
		hm.showView();
//		AudioErfassungView af = new AudioErfassungView(hm,new Audio("Testaudio",1999,"Testinterpret",25));
//		af.showView();
//		BildErfassungView bf = new BildErfassungView(hm,new Bild("Testbild",1999,"Dortmund"));
//		bf.showView();
		
	}
}
