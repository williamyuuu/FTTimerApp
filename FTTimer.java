//Alpha 0.1 (a.1) Nov 08, 2018

import javax.swing.*;
import java.awt.*;

public class FTTimer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel);

		JButton button = new JButton("Button Here");
		panel.add(button);

		frame.setSize(new Dimension(500,500));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("FTTimer version a.1");
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
