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
    private JTextField textName, textMap, textChannel;
    private int RESET_TIME = 60;
    private int displayMin;
    private int displaySec;
    private int secondsPassed;

    private Timer timer;
    private TimerTask task;

    //Creates the panel for the whole timer.
    //Timer ID, Timer countdown, JButton Start, JButton Stop
    private void createView(){

        panel.setOpaque(true);

        labelCount = new JLabel();
        textName = new JTextField("Name");
        textName.setPreferredSize(new Dimension(100,20));
        textMap = new JTextField("Map Name");
        textMap.setPreferredSize(new Dimension(150,20));
        textChannel = new JTextField("Ch");
        textChannel.setPreferredSize(new Dimension(30,20));

        labelID = new JLabel();
        labelID.setText("Timer ID #" + timerID + "     ");

        panel.add(labelID); //Label on panel for TimerID
        panel.add(textName);
        panel.add(textMap);
        panel.add(textChannel);
        panel.add(labelCount); //Label on panel for the timer countdown
        initialDisplay();

        //Button that starts timer from RESET_TIME. Button renames to "Reset Timer"
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
                    resetTime();
                    buttonStart.setText("Start Timer");
                    displayTime();
                    System.out.println("Timer #" + timerID + " stopped!"); //debugger
				}
			}
		);
		panel.add(buttonPause);
	}
    //First display (and when not running). White and reset timer display
    private void initialDisplay(){
        displayMin = RESET_TIME/60;
        displaySec = RESET_TIME%60;
        panel.setBackground(Color.WHITE);
        labelCount.setText(String.format("%02d:%02d",displayMin,displaySec));
    }
    //Displays the current timer time as minute:second format
    private void displayTime(){
        labelCount.setText(String.format("%02d:%02d",displayMin,displaySec));
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
                    panel.setBackground(Color.ORANGE);
                }
            } // End of run
        }; ///// End of timer task
    } ////////// End of createTask method

    //If there is a timer, cancel it.
    //stops running timer. Creates a new timer at green and starts
    private void startTime() {
        stopTime();
        timer = new Timer();
        panel.setBackground(Color.GREEN); //restarting timer resets color to GREEN
        createTask();
        timer.scheduleAtFixedRate(task,0,1000);
	}
    //cancels timer
    private void stopTime() {
        if(timer != null){
            timer.cancel();
        }
    }
    //stops timer and resets to non-running timer
    private void resetTime() {
        if(timer != null){
            timer.cancel();
            initialDisplay();
            System.out.println("initialDisplay");
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
