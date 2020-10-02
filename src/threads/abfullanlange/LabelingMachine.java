package threads.abfullanlange;

public class LabelingMachine implements Runnable {

	private Conveyor c;
	private int time;
	private int labelCounter;

	public LabelingMachine(Conveyor c, int time) {
		this.c = c;
		this.time = time;
		this.labelCounter = 0;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				synchronized (c) {
					// notify kann von anderen thread zufaellig kommen, deswegen while damit es
					// wieder uberprueft wird
					while (c.isEmpty()) {
						System.out.println("Etikettiermaschine: Warten, da Foerderband leer");
						c.wait();
					}
					System.out.println("Etikettiermaschine: Neue flasche vorhanden!");
					Bottle a = c.withdraw();
					a.setLable(new Lable("Flasche " + labelCounter++, 2010));
					System.out.printf("Etikettiermaschine: %s%n",a.printLabel());
					c.notifyAll();
				}
				Thread.sleep(time);
			} catch (Exception e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

	}

}
