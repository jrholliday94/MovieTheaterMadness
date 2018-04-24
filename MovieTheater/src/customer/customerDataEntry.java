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

@SuppressWarnings("serial")
public class customerDataEntry extends JPanel {
	final double TAX_RATE = 1.06;
	private JTextField customerFirstName;
	private JTextField customerLastName;
	private JTextField customerAge;

	// Below should match persistence.xml
	final private String databaseUserName = "root";
	final private String databasePassword = "";

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

		// Select movie
		Choice movieName = new Choice();
		movieName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				String selectedMovie = movieName.getSelectedItem();
				String selectedMoviePrice = "";
				String selectedMovieShowtime = "";
				try {
					// create our mysql database connection

					//
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost/movie_theater_madness";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, databaseUserName, databasePassword);

					// Select showtime from movie DB
					String query = "SELECT showtime FROM movies WHERE movie_name LIKE " + "\"" + selectedMovie + "\"";
					Statement st = conn.createStatement();

					System.out.println(query);

					// execute the query, and get a java resultset
					ResultSet rs = st.executeQuery(query);

					// iterate through the java resultset and setting showtime
					movieTime.removeAll();
					while (rs.next()) {
						selectedMovieShowtime = rs.getString("showtime");
						movieTime.add(selectedMovieShowtime);
					}

					// select movieprice from database where moviename is name entered in field and
					query = "SELECT price FROM movies WHERE movie_name LIKE " + "\"" + selectedMovie + "\"";
					st = conn.createStatement();

					// execute the query, and get a java resultset
					rs = st.executeQuery(query);

					// iterate through the java resultset
					while (rs.next()) {
						selectedMoviePrice = rs.getString("price");
					}

					st.close();

				} catch (Exception e) {
					System.err.println("Got an exception! ");
					System.err.println(e.getMessage());
				}

				double parsedPrice = 0;
				try {
					parsedPrice = Double.parseDouble(selectedMoviePrice);
				} catch (NumberFormatException e) {
					System.out.println("Error");
					String message = "Price not found. Defaulting to $8.50";
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
					parsedPrice = 8.50;
				}

				// Setting base movie price
				String untaxedString = String.format("$%.2f", parsedPrice);
				System.out.println(untaxedString);
				moviePrice.setText(untaxedString);

				// Setting taxed movie price
				parsedPrice = parsedPrice * TAX_RATE;
				String taxedString = String.format("$%.2f", parsedPrice);
				paymentTotal.setText(taxedString);

			}
		});
		movieName.setBounds(140, 89, 130, 20);

		try {
			// create our mysql database connection

			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/movie_theater_madness";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, databaseUserName, databasePassword);

			// select movie_name from database
			String query = "SELECT movie_name FROM movies";
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				// add movie name to choice box
				movieName.add(rs.getString("movie_name"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		add(movieName);

		// Accept button
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(164, 232, 86, 23);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInput(movieName.getSelectedItem(), movieTime.getSelectedItem(), paymentMethod.getSelectedItem(),
						moviePrice.getText());
			}
		});

		add(btnAccept);

	}

	public void getInput(String customerMovieName, String customerMovieTime, String customerPaymentMethod,
			String customerMoviePrice) {
		boolean correct = true;
		String fName = customerFirstName.getText();
		String lName = customerLastName.getText();
		int age = 0;
		double moviePrice = 0;

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

		// Parse passed movieprice
		try {
			moviePrice = Double.parseDouble(customerMoviePrice.substring(1));
		} catch (NumberFormatException e) {
			System.out.println("Error");
			String message = "Price not found";
			JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
			correct = false;
		}

		// If formatting is correct in fields attempt to get age limitation from movie
		// rating
		if (correct) {
			// default to G and set no agecap on movie
			String movieRating = "G";
			int ageCap = 0;

			// Checking if customer is of age for the movie
			try {
				// create our mysql database connection

				//
				String myDriver = "org.gjt.mm.mysql.Driver";
				String myUrl = "jdbc:mysql://localhost/movie_theater_madness";
				Class.forName(myDriver);
				Connection conn = DriverManager.getConnection(myUrl, databaseUserName, databasePassword);

				// select movierating from database where moviename is name entered in field
				String query = "SELECT rating FROM movies WHERE movie_name LIKE " + "\"" + movieName + "\"";
				Statement st = conn.createStatement();

				// execute the query, and get a java resultset
				ResultSet rs = st.executeQuery(query);

				// iterate through the java resultset
				while (rs.next()) {
					movieRating = rs.getString("rating");
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

			// If customer is of age create customer object and print details
			if (age >= ageCap) {
				Customer myCustomer = new Customer(fName, lName, age, movieName, movieTime, paymentMethod, moviePrice);
				myCustomer.toString();
			} else {
				System.out.println("Error");
				String message = "This customer is too young to view this movie. Please decline the sale.";
				JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
			}

		}
	}
}
