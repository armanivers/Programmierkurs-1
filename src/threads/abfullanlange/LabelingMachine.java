package threads.abfullanlange;

public class LabelingMachine implements Runnable{

	private Conveyor c;
	private int time;
	
	public LabelingMachine(Conveyor c,int time) {
		this.c = c;
		this.time = time;
	}
	
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			try {
				synchronized(c){
					//notify kann von anderen thread zufaellig kommen, deswegen while damit es wieder uberprueft wird
					while(c.isEmpty()) {
						System.out.println("Etikettiermaschine: Warten, da Foerderband leer");
						c.wait();
					}
						Bottle a= c.withdraw();
						a.setLable(new Lable("Flasche 1",2010));
						System.out.print("Etikettiermaschine: ");
						a.printLabel();
				}
				Thread.sleep(time);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
