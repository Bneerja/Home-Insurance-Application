package com.perscholas.homeinsurance.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.dao.UserDAO;
/* @Author Neerja Balasubramanian
 */
public class UserBO {

	public List<User> getAllUsers() {

		UserDAO user_dao = new UserDAO();
		return user_dao.getAllUsers();

	}

	public int registerUser(User user) {

		UserDAO user_dao = new UserDAO();
		return user_dao.registerUser(user);
	}

	public boolean deleteUser(User user) {

		UserDAO user_dao = new UserDAO();
		return user_dao.deleteUser(user);

	}
	public User getUser(User user) {
		UserDAO user_dao = new UserDAO();
		return user_dao.getUser(user);
	}
	
	public boolean isValidUser(String userName, String password) throws Exception {
		
		return new UserDAO().isValidUser(userName, password);
	}

	public User getUserByUserName(String userName) {
		User user = new User();
		user.setUserName(userName);
		return new UserDAO().getUser(user); 
	}
}
