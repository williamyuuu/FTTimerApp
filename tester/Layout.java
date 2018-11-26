
import javax.swing.*;

public class Layout{

	public static void main (String[] args) {
		TimeTracker ftimer = new TimeTracker();
		ftimer.createView();
		ftimer.setTitle("Frenzy Timer version a.1");
		ftimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ftimer.pack();
		ftimer.setLocationRelativeTo(null);
		ftimer.setResizable(false);
		ftimer.setVisible(true);

	}
}
