import java.awt.*;
import javax.swing.*;

public class Layout{

	public static void main (String[] args) {

        final int START_TIME = 60; //START_TIME set up
        //Create a frame to put all the panels in.
        JFrame frame = new JFrame();

        //Allow users to create objects needed.. eventually
        TimeTracker time1 = new TimeTracker();
        TimeTracker time2 = new TimeTracker();
        TimeTracker time3 = new TimeTracker();


        //Frame layout. Create into rows instead of Border Layout
        Container container = frame.getContentPane();
        frame.getContentPane().add(time1.panel, BorderLayout.NORTH);
        container.add(time2.panel, BorderLayout.CENTER);
        container.add(time3.panel, BorderLayout.SOUTH);

        //Timer setup
        time1.setUpTimer(1, START_TIME);
        time2.setUpTimer(2, START_TIME);
        time3.setUpTimer(3, START_TIME);

        //Main frame set up
        frame.setTitle("Frenzy Timer version a.1");
        frame.setSize(500, 113);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
