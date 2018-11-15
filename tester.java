import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;

public class tester extends JFrame{

	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			secondsPassed--;
			displayMin = secondsPassed / 60;
			displaySec = secondsPassed % 60;
			System.out.println(secondsPassed); //displays on cmd
			updateCounter();
			if(secondsPassed < 1){
				secondsPassed = 1;
			}
		}
	};

	private JButton buttonCounter, buttonReset;
	private JLabel labelCount;
	private final int RESET_TIME = 10;
	private int displayMin = RESET_TIME/60;
	private int displaySec = RESET_TIME%60;
	private int secondsPassed;

	public tester() {
		createView();

		setTitle("Click Me");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void createView(){
		JPanel panel = new JPanel();
		getContentPane().add(panel);

		labelCount = new JLabel();
		labelCount.setPreferredSize(new Dimension(200, 30));
		panel.add(labelCount);
		updateCounter();

		buttonCounter = new JButton("Start Timer");
		buttonCounter.addActionListener(
			new ButtonCounterActionListener());
		panel.add(buttonCounter);

		/*
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					secondsPassed = 10;
					updateCounter();
				}
			}
		);
		panel.add(buttonReset);
		*/

	}

	private void updateCounter(){
		labelCount.setText(String.format("%02d:%02d",displayMin,displaySec));
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new tester().setVisible(true);
			}
		});
	}
	private class ButtonCounterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			secondsPassed = RESET_TIME;
			timer.scheduleAtFixedRate(task,1000,1000);
		}
	}
}