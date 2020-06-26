package threads.timer;

public class Counter implements TimerListener{

	private int time;
	
	public Counter() {
		this.time = 0;
	}
	
	@Override
	public void signalPerformed() {
		System.out.println(time+" Sekunden seit Start");
		time++;
	}

	
}
