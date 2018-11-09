//Alpha 0.1 (a.1) Nov 08, 2018

import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;

public class FTTimer extends JFrame{

	private JButton buttonCounter, buttonReset;
	private JLabel labelCount;

	private int clicks = 0;

	public FTTimer() {
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

		buttonCounter = new JButton("Click me");
		buttonCounter.addActionListener(
			new ButtonCounterActionListener());
		panel.add(buttonCounter);

		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					clicks = 0;
					updateCounter();
				}
			}
		);
		panel.add(buttonReset);

	}

	private void updateCounter(){
		labelCount.setText("Clicked " + clicks + " times");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new FTTimer().setVisible(true);
			}
		});
	}
	private class ButtonCounterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			clicks++;
			updateCounter();
		}
	}
}
