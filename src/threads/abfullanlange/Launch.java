package threads.abfullanlange;

public class Launch {

	public static void main(String[] args) {
		
		Conveyor c = new Conveyor(10);
		
		Thread abfuellanlage = new Thread(new BottlingPlant(c,(int)(Math.random()*500)));
		Thread etikettiermaschine = new Thread(new LabelingMachine(c,(int)(Math.random()*500)));
		
		abfuellanlage.start();
		etikettiermaschine.start();
	}
}
