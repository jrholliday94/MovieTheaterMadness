package customer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustInputDriver {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Input customer information");
		JPanel panel = new customerDataEntry();

		frame.add(panel);
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
