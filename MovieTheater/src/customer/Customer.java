package customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "customer")
public class Customer {

	final static double SALES_TAX = 1.06;

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "fname")
	String fname = "";

	@Column(name = "lname")
	String lname = "";

	@Column(name = "age")
	int age = 0;

	@Column(name = "movie_name")
	String movieName = "";

	@Column(name = "movie_time")
	String movieTime = "";

	@Column(name = "movie_price")
	double price = 0.0;

	@Column(name = "payment_method")
	String payMethod = "";

	@Column(name = "transaction_total")
	double total;

	@Column(name = "order_id")
	int order_id = 0;

	@Column(name = "gc_bal")
	int gc_bal = 0;

	@Column(name = "gc_id")
	int gc_id = 0;

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
		this.order_id = 0;
		this.gc_bal = 0;
		this.gc_id = 0;
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