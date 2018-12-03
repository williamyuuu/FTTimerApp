//Alpha 0.1 (a.1) Nov 08, 2018
//main timer and restart working Nov 22, 2018
//Alhpa 0.2 (a.2) Nov 30, 2018

import java.awt.*;
import javax.swing.*;

public class Layout{

    public static void main (String[] args) {

        final int START_TIME = 600; //START_TIME set up
        final int NUM_OF_TIMERS = 8; //The amount of timers to display

        //Create a frame to put all the panels in.
        JFrame frame = new JFrame();

        //Frame Grid Layout
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(0, 1, 0, 1));

        //For loop in creating timer objects
        for(int count = 1 ; count <= NUM_OF_TIMERS; count++) {
            TimeTracker timer = new TimeTracker();
            timer.setUpTimer(count, START_TIME);
            container.add(timer.panel);
        }


        //Main frame set up
        frame.setTitle("Frenzy Timer version a.2");
        frame.setSize(1200, 113);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
