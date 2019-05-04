package com.perscholas.homeinsurance;

import java.util.Date;

/* @Author Neerja Balasubramanian
 */

public class HomeOwner {
// Attributes

	private int userId;// primary key and a foreign key
	private String firstName;
	private String lastName;
	private Date dateofbirth;
	private boolean retired;
	private String ssn;
	private String email;

	// Constructors
	public HomeOwner(int userId) {
		this.userId = userId;
	}

	public HomeOwner(int userId, String firstName, String lastName, Date dateofbirth, boolean retired, String ssn,
			String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofbirth = dateofbirth;
		this.retired = retired;
		this.ssn = ssn;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
