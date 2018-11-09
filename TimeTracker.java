
import java.util.*;

public class TimeTracker {

	int secondsPassed = 600;
	int displayMin, displaySec;

	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			secondsPassed--;
			displayMin = secondsPassed / 60;
			displaySec = secondsPassed % 60;
			System.out.printf("%01d:%02d",displayMin,displaySec);
			System.out.println();

		}
	};
	public void start(){
	 	timer.scheduleAtFixedRate(task,1000,1000);
	}
}
