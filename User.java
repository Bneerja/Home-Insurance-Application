package com.perscholas.homeinsurance;

/* @Author Neerja Balasubramanian
 */
public class User {
//Attributes
	private int userId;
	private String userName;
	private String password;
	private String adminRole;
//Constructors

	public User() {
		this.adminRole = "user";
	}

	public User(String name, String password) {
		this();
		this.userName = name;
		this.password = password;

	}	
	
//Getters & Setters

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

	// Override .equals method.
	public boolean equals(Object object) {
		if (object instanceof User) {
			User u = (User) object;
			if (this.userName == null)
				this.userName = "";
			if (this.password == null)
				this.password = "";
			if (this.adminRole == null)
				this.adminRole = "";
			return this.userId == u.getUserId() && this.userName.equals(u.getUserName())
					&& this.password.equals(u.getPassword()) && this.adminRole.equals(u.getAdminRole());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.userId;
	}

	public String toString() {
		return this.userId + this.userName + this.password + this.adminRole;
	}
}
