package threads.abfullanlange;

public class Launch {

	public static void main(String[] args) {

		Conveyor c = new Conveyor(10);
		
		Thread abfuellanlage = new Thread(new BottlingPlant(c,200));
		Thread etikettiermaschine = new Thread(new LabelingMachine(c,300));
		
		abfuellanlage.start();
		etikettiermaschine.start();
	}
}
