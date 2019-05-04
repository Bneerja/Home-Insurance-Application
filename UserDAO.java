package com.perscholas.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.homeinsurance.User;

/* @Author Neerja Balasubramanian
 * UserDAO has methods to get all users,insert a new user and delete a user.
 */
public class UserDAO {

	public User getUser(User user) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User returnUser = null;
		// Assign query string to a variable
		String qString = "select * from userinfo where user_name =?";

		try {
			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database.");
			// Create Statement instance/object
			pstmt = conn.prepareStatement(qString);
			pstmt.setString(1, user.getUserName());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				returnUser = new User();
				int userId = rs.getInt(1);
				String userName = rs.getString(2);
				String passCode = rs.getString(3);
				String adminRole = rs.getString(4);
				returnUser.setUserId(userId);
				returnUser.setUserName(userName);
				returnUser.setPassword(passCode);
				returnUser.setAdminRole(adminRole);

			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println("DB related Error");
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				DBConnectionUtils.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return returnUser;
	}// end of getUser method

	public List<User> getAllUsers() {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User u = null;
		List<User> userList = null;
		// Assign query string to a variable
		String qString = "select * from userinfo";
		// Create MySqlConnection class instance
		DBConnectionUtils oracle = new DBConnectionUtils();
		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = oracle.getConnection();
			System.out.println("Connected to database.");
			// Create Statement instance/object
			stmt = conn.createStatement();
			// Run query and assign to ResultSet
			rs = stmt.executeQuery(qString);
			// Create list to hold User objects
			userList = new ArrayList<User>();
			// Read the ResultSet
			while (rs.next()) {
				// Each iteration creates a new user
				u = new User();
				// Assign columns/fields to related fields in the User object
				// 1,2,3 and 4 represent column numbers/positions
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setAdminRole(rs.getString(4));
				// Add the user to the list
				userList.add(u);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userList;
	} // End of getAllUsers method

	public int registerUser(User user) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = 0;
		// Assign query string to a variable
		String qString = "insert into USERINFO(USER_NAME,PASSCODE) values (?,?)";
		String[] COL = { "user_id" };
		// Create MySqlConnection class instance
		DBConnectionUtils oracle = new DBConnectionUtils();
		// Connect to database
		try {
			conn = oracle.getConnection();
			System.out.println("Connected to database.");
			// Create Statement instance/object
			pstmt = conn.prepareStatement(qString, COL);

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());

			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
			}

			System.out.println(id);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return id;
	}// end of registered method

	public boolean deleteUser(User user) {
		// Declare variables
		boolean deluser = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qString = "Delete from userinfo where user_id = ?";
		DBConnectionUtils oracle = new DBConnectionUtils();

		try {
			conn = oracle.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);

			pstmt.setInt(1, user.getUserId());

			rs = pstmt.executeQuery();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
			deluser = false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return deluser;
	}

	public boolean isValidUser(String userName, String password)
			throws ClassNotFoundException, IOException, SQLException {
		int count = 0;
		String query = "select count(1) from userinfo where user_name = ? and passcode = ?";
		try (Connection con = DBConnectionUtils.getConnection()) {
			try (PreparedStatement prepStatement = con.prepareStatement(query)) {
				prepStatement.setString(1, userName);
				prepStatement.setString(2, password);
				ResultSet resultSet = prepStatement.executeQuery();
				while(resultSet.next()) {
					count = resultSet.getInt(1);
				}
			}
		}
		if (count > 0) {
			return true;
		}
		return false;
	}

	
}
