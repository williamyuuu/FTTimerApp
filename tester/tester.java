//Alpha 0.1 (a.1) Nov 08, 2018

import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;

public class tester extends JFrame{

	JPanel panel = new JPanel();

	private JButton buttonStart, buttonPause;
	private JLabel labelCount;
	private final int RESET_TIME = 10;
	private int displayMin = RESET_TIME/60;
	private int displaySec = RESET_TIME%60;
	private int secondsPassed;

	private Timer timer;
	private TimerTask task;

	public tester() {
		createView();

		setTitle("Frenzy Timer version a.1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void createView(){
		//JPanel panel = new JPanel(); //blocks colors from showing (?)
		getContentPane().add(panel);
		panel.setOpaque(true);
		panel.setBackground(Color.GREEN);

		labelCount = new JLabel();
		labelCount.setPreferredSize(new Dimension(200, 30));
		panel.add(labelCount);
		updateCounter();

		//start 10 minute timer
		buttonStart = new JButton("Start Timer");
		buttonStart.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					secondsPassed = RESET_TIME;
					startTime();
			}
		});
		panel.add(buttonStart);

		//holds the time and cancels the timer
		buttonPause = new JButton("Stop Timer");
		buttonPause.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					secondsPassed = 0;
					stopTime();
					updateCounter();
					System.out.println("Timer stopped!");
				}
			}
		);
		panel.add(buttonPause);
	}

	private void updateCounter(){
		labelCount.setText(String.format("%02d:%02d",displayMin,displaySec));
	}

	private void startTime() {
		if(timer != null) {
			stopTime();
		}
			timer = new Timer();
			panel.setBackground(Color.GREEN);
			createTask();
			timer.scheduleAtFixedRate(task,0,1000);
	}

	private void createTask() {
		task = new TimerTask() {
		   public void run() {
			   displayMin = secondsPassed / 60;
			   displaySec = secondsPassed % 60;
			   System.out.println(secondsPassed); //displays on cmd
			   updateCounter();
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
		timer.cancel();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new tester().setVisible(true);
			}
		});
	}
}
