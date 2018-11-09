
import java.awt.*;
import javax.swing.*;

public class Layout extends JFrame{
	private JButton buttonCounter, buttonReset;
	private JLabel labelCount;

	public Layout() {
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
		labelCount.setPreferredSize(new Dimension(750, 200));
		panel.add(labelCount);

		TimeTracker timer = new TimeTracker();
		timer.start();

		/*
		buttonCounter = new JButton("Click me");
		panel.add(buttonCounter);

		buttonReset = new JButton("Reset");
		panel.add(buttonReset);
		*/

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new Layout().setVisible(true);
			}
		});
	}
}
