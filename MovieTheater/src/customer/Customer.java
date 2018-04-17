package customer;

public class Customer {

	final static double SALES_TAX = 1.06;

	// declare fields
	String fname = "";
	String lname = "";
	int age = 0;
	String movieName = "";
	String movieTime = "";
	double price = 0.0;
	String payMethod = "";
	double total;

	/**
	 * @param fname
	 * @param lname
	 * @param age
	 * @param movieName
	 * @param movieTime
	 * @param payMethod
	 * @param total
	 */
	public Customer(String fname, String lname, int age, String movieName, String movieTime, String payMethod,
			double price) {
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.movieName = movieName;
		this.movieTime = movieTime;
		this.payMethod = payMethod;
		this.price = price;
		this.total = setTotal();
	}

	// getters and setters
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public double getTotal() {
		return total;
	}

	// Private so total can't be set it is the product of tax and the movie price
	private double setTotal() {
		return this.price * SALES_TAX;

	}

	// ToString Method
	public String toString() {
		return "Name: " + fname + " " + lname + "\n Age: " + age + "\n Movie Name: " + movieName + "\n Movie Time: "
				+ movieTime + "\n Price: $" + price + "\n Payment Method: " + payMethod + "\n Total: $"
				+ String.format("%.2f", total);
	}
}