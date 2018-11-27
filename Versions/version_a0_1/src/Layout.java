import java.awt.*;
import javax.swing.*;

public class Layout{

	public static void main (String[] args) {

        final int START_TIME = 600;

		TimeTracker time = new TimeTracker();
    	TimeTracker time2 = new TimeTracker();
        TimeTracker time3 = new TimeTracker();
        Container cont = time.getContentPane();
        time.getContentPane().add(time.panel, BorderLayout.NORTH);
        cont.add(time2.panel, BorderLayout.CENTER);
        cont.add(time3.panel, BorderLayout.SOUTH);


        time.setTimerNum(1); //debugger for cmd timer ID
		time.setStartTime(START_TIME); //overwrites the reset timer value
		time.createView();
		time.setTitle("Frenzy Timer version a.1");
		time.setSize(500, 113);
		time.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		time.setLocationRelativeTo(null);
		time.setResizable(false);
		time.setVisible(true);

        time2.setTimerNum(2); //debugger for cmd timer ID
        time2.setStartTime(START_TIME); //overwrites the reset timer value
        time2.createView();

        //occasionally doesn't load the stop button for timer 3
        time3.setTimerNum(3); //debugger for cmd timer ID
        time3.setStartTime(START_TIME); //overwrites the reset timer value
        time3.createView();


	}
}
