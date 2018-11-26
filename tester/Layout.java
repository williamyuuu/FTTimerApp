
import javax.swing.*;

public class Layout{

	public static void main (String[] args) {
		TimeTracker time = new TimeTracker();

		time.setStartTime(20); //overwrites the reset timer value
		time.createView();
		time.setTitle("Frenzy Timer version a.1");
		time.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		time.pack();
		time.setLocationRelativeTo(null);
		time.setResizable(false);
		time.setVisible(true);

	}
}
