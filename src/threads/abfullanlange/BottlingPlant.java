package threads.abfullanlange;

public class BottlingPlant implements Runnable{

	private Conveyor c;
	private int time;
	
	public BottlingPlant(Conveyor c,int time) {
		this.c = c;
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				synchronized(c) {
					while(c.isOverloaded()) {
						System.out.println("Abfuellanlage: Band voll, ich warte");
						c.wait();
					}
					c.load(new Bottle());
					System.out.println("Abfuellanlage: Neue Flasch abgefuellt");
					c.notifyAll();
				}
				//wichtig sleep ausserhalb von synchronized bereich, sonst behaelt er den schluessel (c)
				Thread.sleep(time);
				//kann bei wake/sleep geworfen werden
			} catch(InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
	
}
