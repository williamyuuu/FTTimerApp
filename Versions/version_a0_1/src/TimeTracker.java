//Alpha 0.1 (a.1) Nov 08, 2018
//main timer and restart working Nov 22, 2018

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


	public void createView(){

		//getContentPane().add(panel);

		panel.setOpaque(true);
		panel.setBackground(Color.GREEN);
	    //panel.setPreferredSize(new Dimension(400,40));

		labelCount = new JLabel();

        labelID = new JLabel(); // debugger
        labelID.setText("Timer ID #" + timerID + "     "); //debugger

        panel.add(labelID);
		//labelCount.setPreferredSize(new Dimension(100,30));
		panel.add(labelCount);
		initialDisplay();

		//start 10 minute timer
		buttonStart = new JButton("  Start Timer  ");
		//find alternative to setPreferredSize
		buttonStart.setPreferredSize(new Dimension(100,20));
		buttonStart.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					buttonStart.setText("Restart Timer");
					secondsPassed = RESET_TIME;
					startTime();

			}
		});
		panel.add(buttonStart);

		//holds the time and cancels the timer
		buttonPause = new JButton("Stop Timer");
		//find alternative to setPreferredSize
		buttonPause.setPreferredSize(new Dimension(100,20));
		buttonPause.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					secondsPassed = 0;
					stopTime();
					buttonStart.setText("  Start Timer  ");
					displayTime();
					System.out.println("Timer #" + timerID + " stopped!"); //debugger
				}
			}
		);
		panel.add(buttonPause);
	}


	private void displayTime(){
		labelCount.setText(String.format("%02d:%02d",displayMin,displaySec));
	}
	private void initialDisplay(){
		displayMin = RESET_TIME/60;
		displaySec = RESET_TIME%60;
		labelCount.setText(String.format("%02d:%02d",displayMin,displaySec));
	}
	private void startTime() {
			stopTime();
			timer = new Timer();
			panel.setBackground(Color.GREEN); //restarting timer resets color to GREEN
			createTask();
			timer.scheduleAtFixedRate(task,0,1000);
	}
	private void createTask() {
		task = new TimerTask() {
		   public void run() {
			   displayMin = secondsPassed / 60;
			   displaySec = secondsPassed % 60;
			   System.out.print(secondsPassed); //displays on cmd -- debugger
               System.out.println(" -- timer #" + timerID); //displays on cmd -- debugger
			   displayTime();
			   secondsPassed--;
			   if(secondsPassed < 0){ //stops at 0
				   stopTime();
				   panel.setBackground(Color.RED);
			   } else if(secondsPassed < RESET_TIME*0.25) { //yellow at 25% of time
				   panel.setBackground(Color.YELLOW);
			   }
		   } //end of run
	   }; //end of timer task
	}
	private void stopTime() {
		if(timer != null){
			timer.cancel();
		}
	}
	public void setStartTime (int x){
		RESET_TIME = x;
	}
    public void setTimerNum (int x) {
        timerID = x;
    }
}
