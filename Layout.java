
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //allows for ActionListener

public class Layout extends JFrame{
	private JButton buttonCounter, buttonReset;
	private JLabel labelCount, labelMin, labelSec;

	private int castCount = 0;

	public Layout() {
		createView();

		setTitle("Frenzy Totem Timer version a.1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	//THE DISPLAY OF THE PANEL
	private void createView(){
		JPanel panel = new JPanel();
		getContentPane().add(panel);

		labelCount = new JLabel();
		labelCount.setPreferredSize(new Dimension(400, 30));
		panel.add(labelCount);
<<<<<<< HEAD
		labelCount.setText("From Layout");
=======
		updateCounter();
>>>>>>> ed57cbc36734bf1f04d8ac8286a99553ecb321ce

		TimeTracker timer = new TimeTracker();
		timer.start();

		//add cast will add ONE to the cast count
		buttonCounter = new JButton("Add Cast");
		panel.add(buttonCounter);
		buttonCounter.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Add Cast"); //debugger
					castCount++;
					updateCounter();
				}
			}
		);

		//reset button. Changes cast count to ZERO
		buttonReset = new JButton("Reset");
		panel.add(buttonReset);
		buttonReset.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Reset"); //debugger
					castCount = 0;
					updateCounter();
				}
			}
		);

	} // end of createView

	//Displays the current count. Called to update
	private void updateCounter(){
		labelCount.setText("Casted: " + castCount);
	}

	/*
	private void updateTimer(){
		labelMin.setText();
		labelSec.setText();
	} */

	//MAIN METHOD -- runs the code
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new Layout().setVisible(true);
			}
		});
	}
}
