package threads.abfullanlange;

import java.util.LinkedList;
import java.util.Queue;

public class BottlingPlant implements Runnable{

	private Conveyor c;
	private Queue<Bottle> getraenke;
	private int time;
	
	public BottlingPlant(Conveyor c,int time) {
		this.c = c;
		getraenke = new LinkedList<Bottle>();
	}
	
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			try {
				synchronized(c) {
					while(c.isOverloaded()) {
						System.out.println("Abfuellanlage: Band voll, ich warte");
						c.wait();
					}
					c.load(new Bottle());
					c.notifyAll();
					System.out.println("Abfuellanlange: Neue Flasch abgefuellt");
				}
				//wichtig sleep ausserhalb von synchronized bereich, sonst behaelt er den schluessel (c)
				Thread.sleep(time);
				//kann bei wake/sleep geworfen werden
			} catch(InterruptedException e) {
				break;
			}
		}
	}
	
	public void addBottle(Bottle b) {
		getraenke.add(b);
	}

}
