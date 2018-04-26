package concessions;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.eclipse.persistence.sessions.Session;

import javax.persistence.EntityManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ConcessionsPanel extends JPanel {

	final double TAX_RATE = 1.06;
	final double SMALL_FOUNTAIN = 1.50;
	final double MED_FOUNTAIN = 2.50;
	final double LARGE_FOUNTAIN = 3.50;

	// Below should match persistence.xml


	final private String databaseUserName = "root";
<<<<<<< HEAD
	final private String databasePassword = "PIglet1!";
=======
	final private String databasePassword = "";
>>>>>>> f37e5d239f29a287da5741518eb26d12fe183401

	private JTextField quantityPopcorn;
	private JTextField quantityMikeAndIkes;
	private JTextField quantityMAndMs;
	private JTextField quantitySmallFountain;
	private JTextField quantityMediumFountain;
	private JTextField quantityLargeFountain;

	Border border = BorderFactory.createLineBorder(Color.black, 1);

	/**
	 * Create the panel.
	 */
	public ConcessionsPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Popcorn");
		lblNewLabel.setBounds(10, 48, 133, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mike and Ikes");
		lblNewLabel_1.setBounds(10, 72, 133, 14);
		add(lblNewLabel_1);

		JLabel lblM = new JLabel("M & Ms");
		lblM.setBounds(10, 96, 133, 14);
		add(lblM);

		JLabel lblNewLabel_2 = new JLabel("Fountain Drink Small");
		lblNewLabel_2.setBounds(10, 120, 133, 14);
		add(lblNewLabel_2);

		JLabel lblFountainDrinkMedium = new JLabel("Fountain Drink Medium");
		lblFountainDrinkMedium.setBounds(10, 144, 133, 14);
		add(lblFountainDrinkMedium);

		JLabel lblFountainDrinkLarge = new JLabel("Fountain Drink Large");
		lblFountainDrinkLarge.setBounds(10, 168, 133, 14);
		add(lblFountainDrinkLarge);

		JLabel lblNewLabel_3 = new JLabel("Enter Quantities");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(134, 11, 114, 14);
		add(lblNewLabel_3);

		JLabel lblPrices = new JLabel("Prices");
		lblPrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrices.setBounds(285, 11, 54, 14);
		add(lblPrices);

		JLabel lblTot = new JLabel("Total");
		lblTot.setHorizontalAlignment(SwingConstants.CENTER);
		lblTot.setBounds(285, 196, 54, 14);
		add(lblTot);

		JLabel lblTotal = new JLabel("");
		lblTotal.setBounds(285, 219, 54, 20);
		lblTotal.setBorder(border);
		add(lblTotal);

		JLabel pcPrice = new JLabel("");
		pcPrice.setBounds(285, 45, 54, 20);
		pcPrice.setBorder(border);
		add(pcPrice);

		JLabel miPrice = new JLabel("");
		miPrice.setBounds(285, 69, 54, 20);
		miPrice.setBorder(border);
		add(miPrice);

		JLabel mmPrice = new JLabel("");
		mmPrice.setBounds(285, 93, 54, 20);
		mmPrice.setBorder(border);
		add(mmPrice);

		JLabel smPrice = new JLabel("");
		smPrice.setBounds(285, 117, 54, 20);
		smPrice.setBorder(border);
		add(smPrice);

		JLabel medPrice = new JLabel("");
		medPrice.setBounds(285, 141, 54, 20);
		medPrice.setBorder(border);
		add(medPrice);

		JLabel largePrice = new JLabel("");
		largePrice.setBounds(285, 165, 54, 20);
		largePrice.setBorder(border);
		add(largePrice);

		quantityPopcorn = new JTextField();
		quantityPopcorn.setBounds(148, 45, 86, 20);
		add(quantityPopcorn);
		quantityPopcorn.setColumns(10);

		quantityMikeAndIkes = new JTextField();
		quantityMikeAndIkes.setBounds(148, 69, 86, 20);
		add(quantityMikeAndIkes);
		quantityMikeAndIkes.setColumns(10);

		quantityMAndMs = new JTextField();
		quantityMAndMs.setBounds(148, 93, 86, 20);
		add(quantityMAndMs);
		quantityMAndMs.setColumns(10);

		quantitySmallFountain = new JTextField();
		quantitySmallFountain.setBounds(148, 117, 86, 20);
		add(quantitySmallFountain);
		quantitySmallFountain.setColumns(10);

		quantityMediumFountain = new JTextField();
		quantityMediumFountain.setBounds(148, 141, 86, 20);
		add(quantityMediumFountain);
		quantityMediumFountain.setColumns(10);

		quantityLargeFountain = new JTextField();
		quantityLargeFountain.setBounds(148, 165, 86, 20);
		add(quantityLargeFountain);
		quantityLargeFountain.setColumns(10);

		JButton acceptButton = new JButton("Accept");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Checking stock before sale
				// Fountain drinks assumed to always be in stock so no stock check
				int popcorn = 0;
				double popcornPrice = 0;
				int mikeAndIkes = 0;
				double mikeAndIkesPrice = 0;
				int mAndMs = 0;
				double mAndMsPrice = 0;
				int smallFountain = 0;
				int medFountain = 0;
				int largeFountain = 0;
				boolean correct = true;

				try {
					popcorn = Integer.parseInt(quantityPopcorn.getText());
					mikeAndIkes = Integer.parseInt(quantityMikeAndIkes.getText());
					mAndMs = Integer.parseInt(quantityMAndMs.getText());
					smallFountain = Integer.parseInt(quantitySmallFountain.getText());
					medFountain = Integer.parseInt(quantityMediumFountain.getText());
					largeFountain = Integer.parseInt(quantityLargeFountain.getText());

				} catch (NumberFormatException e) {
					System.out.println("Error");
					String message = "Quantities are not formatted correctly.";
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
					correct = false;
				}

				if (correct) {
					boolean validTransaction = true;
					try {
						// create our mysql database connection
						String myDriver = "org.gjt.mm.mysql.Driver";
						String myUrl = "jdbc:mysql://localhost/movie_theater_madness";
						Class.forName(myDriver);
						Connection conn = DriverManager.getConnection(myUrl, databaseUserName, databasePassword);

						// select popcorn from database
						String query = "SELECT item_price FROM concessions WHERE item_name LIKE popcorn";
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery(query);

						// iterate through the java resultset
						while (rs.next()) {
							popcornPrice = Double.parseDouble(rs.getString("item_price"));
						}

						// select mike and ikes from database
						query = "SELECT item_price FROM concessions WHERE item_name LIKE mikeandikes";
						st = conn.createStatement();
						rs = st.executeQuery(query);

						// iterate through the java resultset
						while (rs.next()) {
							mikeAndIkesPrice = Double.parseDouble(rs.getString("item_price"));
						}

						// select m and ms from database
						query = "SELECT item_price FROM concessions WHERE item_name LIKE mandms";
						st = conn.createStatement();
						rs = st.executeQuery(query);

						// iterate through the java resultset
						while (rs.next()) {
							mAndMsPrice = Double.parseDouble(rs.getString("item_price"));
						}

						// Set subtotal prices
						popcornPrice = popcornPrice * popcorn;
						mikeAndIkesPrice = mikeAndIkesPrice * mikeAndIkes;
						mAndMsPrice = mAndMsPrice * mAndMs;
						double smallFountainPrice = smallFountain * SMALL_FOUNTAIN;
						double medFountainPrice = medFountain * MED_FOUNTAIN;
						double largeFountainPrice = largeFountain * LARGE_FOUNTAIN;

						double subtotal = popcornPrice + mikeAndIkesPrice + mAndMsPrice + smallFountainPrice
								+ medFountainPrice + largeFountainPrice;

						subtotal = subtotal * TAX_RATE;

						String untaxedPC = String.format("$%.2f", popcornPrice);
						String untaxedMI = String.format("$%.2f", mikeAndIkesPrice);
						String untaxedMM = String.format("$%.2f", mAndMsPrice);
						String untaxedSM = String.format("$%.2f", smallFountainPrice);
						String untaxedMD = String.format("$%.2f", medFountainPrice);
						String untaxedLG = String.format("$%.2f", largeFountainPrice);
						String taxedTotal = String.format("$%.2f", subtotal);

						pcPrice.setText(untaxedPC);
						miPrice.setText(untaxedMI);
						mmPrice.setText(untaxedMM);
						smPrice.setText(untaxedSM);
						medPrice.setText(untaxedMD);
						largePrice.setText(untaxedLG);
						lblTotal.setText(taxedTotal);

						st.close();
					} catch (Exception e) {
						System.err.println("Got an exception! ");
						System.err.println(e.getMessage());
					}
				}
			}
		});
		acceptButton.setBounds(145, 200, 89, 23);
		add(acceptButton);

	}
}
