import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;

public class TimeTracker extends JFrame{

    JPanel panel = new JPanel();


    //Debugger instantiations
    private int timerID;

    private JButton buttonStart, buttonPause;
    private JLabel labelCount, labelID;
    private int RESET_TIME = 60;
    private int displayMin;
    private int displaySec;
    private int secondsPassed;

    private Timer timer;
    private TimerTask task;

    private void createView(){

        panel.setOpaque(true);
        panel.setBackground(Color.GREEN);

        labelCount = new JLabel();

        labelID = new JLabel(); // debugger
        labelID.setText("Timer ID #" + timerID + "     "); //debugger

        panel.add(labelID);
        panel.add(labelCount);
        initialDisplay();

        //start 10 minute timer
        buttonStart = new JButton("Start Timer");
        buttonStart.setPreferredSize(new Dimension(150,20));
        buttonStart.addActionListener(
            new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     buttonStart.setText("Reset Timer");
                     secondsPassed = RESET_TIME;
                     startTime();
                 }
        });
        panel.add(buttonStart);

        //Timer will stop. Display freezes at stopped number/color
        buttonPause = new JButton("Stop Timer");
        buttonPause.setPreferredSize(new Dimension(150,20));
        buttonPause.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    secondsPassed = 0;
                    stopTime();
                    buttonStart.setText("Start Timer");
                    displayTime();
                    System.out.println("Timer #" + timerID + " stopped!"); //debugger
				}
			}
		);
		panel.add(buttonPause);
	}
    //Displays the START_TIME as a minute:second format
    private void initialDisplay(){
        displayMin = RESET_TIME/60;
        displaySec = RESET_TIME%60;
        labelCount.setText(String.format("%02d:%02d",displayMin,displaySec));
    }
    //Displays the current timer time as minute:second format
    private void displayTime(){
        labelCount.setText(String.format("%02d:%02d",displayMin,displaySec));
    }
    //stops running timer. Creates a new timer at green and starts
    private void startTime() {
        stopTime();
        timer = new Timer();
        panel.setBackground(Color.GREEN); //restarting timer resets color to GREEN
        createTask();
        timer.scheduleAtFixedRate(task,0,1000);
	}
    //Task for timer. The rules for running the timer task
    private void createTask() {
        task = new TimerTask() {
            public void run() {
                //Formats the seconds as int into a minute:seconds format
                displayMin = secondsPassed / 60;
                displaySec = secondsPassed % 60;
                System.out.print(secondsPassed); //displays on cmd -- debugger
                System.out.println(" -- timer #" + timerID); //displays on cmd -- debugger
                displayTime();
                secondsPassed--;
                //Timer color alerts. Red when done, Yellow at 20% completion
                if(secondsPassed < 0){
                    stopTime(); //Upon timer completion, the timer will stop
                    panel.setBackground(Color.RED);
                } else if(secondsPassed < RESET_TIME*0.2) {
                    panel.setBackground(Color.YELLOW);
                }
            } // End of run
        }; ///// End of timer task
    } ////////// End of createTask method
    //If there is a timer, cancel it.
    private void stopTime() {
        if(timer != null){
            timer.cancel();
        }
    }
    //setting up a timer. Passes an ID, and changes RESET_TIME if defined
    public void setUpTimer (int id, int start) {
        timerID = id;
        RESET_TIME = start; //Technically don't need this if timer always 60
                            //But I want this for future user time input settings
        createView();
    }
} ////////// End of TimeTracker
