package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="credentials")
public class ListCreds {

	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="ID")

	private int id;

	@Column(name="USERNAME")

	private String username;

	@Column(name="ACCESSCODE")

	private String accesscode;

	@Column(name="ROLE")

	private String role;
	
	
	public ListCreds() {

		// TODO Auto-generated constructor stub

	}

	public ListCreds(String username, String accesscode, String role) {

		this.username = username;

		this.accesscode = accesscode;

		this.role = role;
	}

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getUserName() {

		return username;

	}

	public void setUserName(String username) {

		this.username = username;

	}

	public String getAccessCode() {

		return accesscode;

	}

	public void setAccessCode(String accesscode) {

		this.accesscode = accesscode;

	}

	public String getRole() {

		return role;

	}

	public void setRole(String role) {

		this.role = role;

	}


	@Override

	public String toString() {

		return "ListCreds [id=" + id + ", username=" + username + ", accesscode=" + accesscode + ", role=" + role + "]";

	}

	

	public String returnAccessCodeDetails() {

		return username + ": " + accesscode + ": " + role + ": ";

	}





}