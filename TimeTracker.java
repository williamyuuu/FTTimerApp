
import java.util.*;
import java.awt.*;

public class TimeTracker{

	int secondsPassed = 10;
	int displayMin, displaySec;

	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			secondsPassed--;
			displayMin = secondsPassed / 60;
			displaySec = secondsPassed % 60;
			//getTime();
			System.out.printf("%01d:%02d\n",displayMin,displaySec); //push to layout display?
			if(displayMin == 0 && displaySec == 0) {
				timer.cancel();
				System.out.println("TIME'S UP!");
			}
		}
	};
	public void start(){
	 	timer.scheduleAtFixedRate(task,1000,1000);
	}
}
