package customer;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Choice;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ItemEvent;

public class customerDataEntry extends JPanel {
	private JTextField customerFirstName;
	private JTextField customerLastName;
	private JTextField customerAge;

	/**
	 * Create the panel.
	 */
	public customerDataEntry() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer first name");
		lblNewLabel.setBounds(10, 8, 123, 14);
		add(lblNewLabel);

		customerFirstName = new JTextField();
		customerFirstName.setBounds(140, 5, 130, 20);
		customerFirstName.setColumns(10);
		add(customerFirstName);

		JLabel lblCustomerLastName = new JLabel("Customer last name");
		lblCustomerLastName.setBounds(10, 36, 123, 14);
		add(lblCustomerLastName);

		customerLastName = new JTextField();
		customerLastName.setColumns(10);
		customerLastName.setBounds(140, 33, 130, 20);
		add(customerLastName);

		JLabel lblCustomerAge = new JLabel("Customer age");
		lblCustomerAge.setBounds(10, 64, 123, 14);
		add(lblCustomerAge);

		customerAge = new JTextField();
		customerAge.setColumns(10);
		customerAge.setBounds(140, 61, 130, 20);
		add(customerAge);

		JLabel lblCustomerMovie = new JLabel("Movie name");
		lblCustomerMovie.setBounds(10, 92, 123, 14);
		add(lblCustomerMovie);

		JLabel lblMovieTime = new JLabel("Movie time");
		lblMovieTime.setBounds(10, 120, 123, 14);
		add(lblMovieTime);

		Choice movieTime = new Choice();
		movieTime.setBounds(140, 117, 130, 20);

		// REMOVE BELOW WHEN DB IS READY

		movieTime.add("2:45 Testing purposes only. Remove when DB ready.");
		movieTime.add("4:20 Testing purposes only. Remove when DB ready.");

		// REMOVE ABOVE WHEN DB IS READY

		add(movieTime);

		JLabel lblMoviePrice = new JLabel("Movie Price");
		lblMoviePrice.setBounds(10, 148, 123, 14);
		add(lblMoviePrice);

		JLabel moviePrice = new JLabel();
		moviePrice.setToolTipText("Price of the movie");
		moviePrice.setBounds(140, 145, 130, 20);
		// Border creates a visual unclickable field
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		moviePrice.setBorder(border);
		add(moviePrice);

		// REMOVE BELOW WHEN DB IS READY
		moviePrice.setText("$8.75");
		// REMOVE ABOVE WHEN DB IS READY
		

		JLabel lblPaymentMethod = new JLabel("Payment method");
		lblPaymentMethod.setBounds(10, 176, 123, 14);
		add(lblPaymentMethod);

		Choice paymentMethod = new Choice();
		paymentMethod.setBounds(140, 173, 130, 20);
		paymentMethod.add("Visa");
		paymentMethod.add("MasterCard");
		paymentMethod.add("Cash");
		paymentMethod.add("Gift Card");
		add(paymentMethod);

		JLabel lblNewLabel_1 = new JLabel("Transaction total");
		lblNewLabel_1.setBounds(10, 204, 123, 14);
		add(lblNewLabel_1);

		JLabel paymentTotal = new JLabel();
		paymentTotal.setToolTipText("Price of the movie");
		paymentTotal.setBounds(140, 201, 130, 20);
		paymentTotal.setBorder(border);
		add(paymentTotal);
		
		
		// REMOVE BELOW WHEN DB IS READY
		double taxed = 8.75 * 1.06;
		String taxedString = String.format("%.2f", taxed);
		paymentTotal.setText(taxedString);
		// REMOVE ABOVE WHEN DB IS READY

		// Select movie
		Choice movieName = new Choice();
		movieName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				// TODO change price via getting DB price per movie

				// REMOVE BELOW WHEN DB IS READY
				moviePrice.setText("$8.75");

				double taxed = 8.75 * 1.06;
				String taxedString = String.format("%.2f", taxed);
				paymentTotal.setText(taxedString);
				// REMOVE ABOVE WHEN DB IS READY
			}
		});
		movieName.setBounds(140, 89, 130, 20);

		// REMOVE BELOW WHEN DB IS READY

		movieName.add("Testing purposes only. Remove when DB ready.");
		movieName.add("Black Panther");

		// REMOVE ABOVE WHEN DB IS READY

		add(movieName);

		// Accept button
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(164, 232, 86, 23);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInput(movieName.getSelectedItem(), movieTime.getSelectedItem(), paymentMethod.getSelectedItem());
			}
		});

		add(btnAccept);

	}

	public void getInput(String customerMovieName, String customerMovieTime, String customerPaymentMethod) {
		boolean correct = true;
		String fName = customerFirstName.getText();
		String lName = customerLastName.getText();
		int age = 0;

		// parse age, don't create object if not an int
		try {
			age = Integer.parseInt(customerAge.getText());
		} catch (NumberFormatException ex) {
			String message = "The age entered is not in a correct format.";
			JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
			correct = false;
		}

		String movieName = customerMovieName;
		String movieTime = customerMovieTime;
		String paymentMethod = customerPaymentMethod;

		/*
		 * TODO Movie name - retrieve list of movie names from DB and they will be in
		 * the dropdown for user to choose Movie time - same as above Movie price -
		 * automatically retrieved from DB based on movie and discount if applicable
		 */

		// If formatting is correct in fields create customer object
		if (correct) {
			// default to G and set no agecap on movie
			String movieRating = "G";
			int ageCap = 0;
			
			// Checking if customer is of age for the movie
			try {
				// create our mysql database connection
				
				
				
				
				
				//TODO MAKE THESE CONNECT TO OUR DATABASE
				String myDriver = "org.gjt.mm.mysql.Driver";
				String myUrl = "jdbc:mysql://localhost/test";
				Class.forName(myDriver);
				Connection conn = DriverManager.getConnection(myUrl, "root", "");

				// select movierating from database where moviename is name entered in field
				String query = "SELECT rating FROM movies WHERE movie_name LIKE " + movieName;
				Statement st = conn.createStatement();

				// execute the query, and get a java resultset
				ResultSet rs = st.executeQuery(query);

				// iterate through the java resultset
				while (rs.next()) {
					movieRating = rs.getString("movierating");
				}
				st.close();
			} catch (Exception e) {
				System.err.println("Got an exception! ");
				System.err.println(e.getMessage());
			}

			// Check movie rating and make agecap based off the rating
			switch (movieRating.toUpperCase()) {
			case "G":
				ageCap = 0;
				break;
			case "PG":
				ageCap = 3;
				break;
			case "PG-13":
				ageCap = 13;
				break;
			case "R":
				ageCap = 17;
				break;
			case "NC-17":
				ageCap = 18;
				break;
			default:
				break;
			}

			if (age >= ageCap) {
				Customer myCustomer = new Customer(fName, lName, age, movieName, movieTime, paymentMethod, 8.50);
			} else {
				String message = "This customer is too young to view this movie. Please decline the sale.";
				JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
			}

		}
	}
}
