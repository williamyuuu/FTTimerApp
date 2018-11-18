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
	private final int RESET_TIME = 60;
	private int displayMin = RESET_TIME/60;
	private int displaySec = RESET_TIME%60;
	private int secondsPassed;
	private int timerRunning = 0;

	public tester() {
		createView();

		setTitle("Frenzy Timer version a.1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void createView(){
		//JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setOpaque(true);

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
					panel.setBackground(Color.GREEN);
					secondsPassed = RESET_TIME;
					timerRunning = startTime(timerRunning);
					if (timerRunning == 2) {
						secondsPassed = RESET_TIME;
					}
			}
		});
		panel.add(buttonStart);

		//holds the time and cancels the timer
		buttonPause = new JButton("Pause Timer");
		buttonPause.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					secondsPassed = 0;
					updateCounter();
					System.out.println("Timer task completely wiped. GG noob!");
				}
			}
		);
		panel.add(buttonPause);
	}

	private void updateCounter(){
		labelCount.setText(String.format("%02d:%02d",displayMin,displaySec));
	}

	private int startTime(int x) {
	 	int ans;

		//incorporate a way to cancel timer but still start a new one
		if(x == 0) {
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				public void run() {
					secondsPassed--;
					displayMin = secondsPassed / 60;
					displaySec = secondsPassed % 60;
					System.out.println(secondsPassed); //displays on cmd
					updateCounter();
					if(secondsPassed < 1){
						panel.setBackground(Color.RED);
						timer.cancel();
					} else if(secondsPassed <= RESET_TIME*0.25) { //75% is at 15 seconds
						panel.setBackground(Color.YELLOW);
					}
				} //end of run
			}; //end of timer task
			timer.scheduleAtFixedRate(task,1000,1000);
			ans = 1;
		}
		else {
			ans = 2;
		}
		return ans;
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
