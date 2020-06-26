package threads.timer;

public class Timer implements Runnable{
	
	private TimerListener tm;
	
	public Timer(TimerListener tm) {
		this.tm = tm;
	}
	
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			try {
				Thread.sleep(1000);
				tm.signalPerformed();
			} catch(InterruptedException e) {
				break;
			} 
		}
	}

	
}
