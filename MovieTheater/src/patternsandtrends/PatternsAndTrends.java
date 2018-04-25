package patternsandtrends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PatternsAndTrends {

	public static void patterns() {
		String movie = "";
		String fname = "";
		String lname = "";
		Scanner in = new Scanner(System.in);

		boolean keepGoing = true;
		System.out.println("Movie Query");

		while (keepGoing) {
			System.out.println("Select a movie!");
			System.out.println("1: Black Panther");
			System.out.println("2: I Feel Pretty");
			System.out.println("3: Avengers");
			System.out.println("4: The Notebook");
			System.out.println("5: Exit");
			System.out.print("Your selection: ");
			int selection = in.nextInt();
			in.nextLine();
			if (selection == 1) {
				movie = "Black Panther";
				keepGoing = false;
			} else if (selection == 2) {
				movie = "I Feel Pretty";
				keepGoing = false;
			} else if (selection == 3) {
				movie = "Avengers";
				keepGoing = false;
			} else if (selection == 4) {
				movie = "The Notebook";
				keepGoing = false;
			} else {
				System.out.println("Exiting...");
				keepGoing = false;
			}
		}

		try {
			// TODO MAKE THESE CONNECT TO OUR DATABASE
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/movie_theater_madness";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			String query = "SELECT fname, lname FROM customer WHERE movie_name LIKE " + "\"" + movie + "\"";
			System.out.println(query);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset and setting showtime
			while (rs.next()) {
				fname = rs.getString("fname");
				lname = rs.getString("lname");
				System.out.println(lname + ", " + fname);
			}

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	
		in.close();
	}
}
