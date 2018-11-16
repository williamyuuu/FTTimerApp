import java.awt.*;
import java.util.*;
<<<<<<< HEAD
import javax.swing.JLabel;
import javax.swing.JPanel;
=======
import java.awt.*;
>>>>>>> ed57cbc36734bf1f04d8ac8286a99553ecb321ce

public class TimeTracker{

	int secondsPassed = 10;
	int displayMin, displaySec;
	private JLabel labelCount;

	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			secondsPassed--;
			displayMin = secondsPassed / 60;
			displaySec = secondsPassed % 60;
<<<<<<< HEAD
			System.out.printf("%01d:%02d",displayMin,displaySec);
			System.out.println();
=======
			//getTime();
			System.out.printf("%01d:%02d\n",displayMin,displaySec); //push to layout display?
			if(displayMin == 0 && displaySec == 0) {
				timer.cancel();
				System.out.println("TIME'S UP!");
			}
>>>>>>> ed57cbc36734bf1f04d8ac8286a99553ecb321ce
		}
	};

	public void start(){
		timer.scheduleAtFixedRate(task,1000,1000);
	}
}
