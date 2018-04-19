package customer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustInputDriver {
	public static void main(String[] args) {

		// Testing purposes only
		// Create frame
		JFrame frame = new JFrame("Input customer information");
		JPanel panel = new customerDataEntry();

		frame.add(panel);
		frame.setSize(350, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
