package com.perscholas.homeinsurance.dao.JUnitTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.dao.UserDAO;

import junit.framework.TestCase;
/* @Author Neerja Balasubramanian
 */

public class UserDAOTest extends TestCase {

	List<User> expectedUserList;
	User deleteUser;

	@Before
	public void setUp() {
		expectedUserList = getExpectedUserList();
	}

	@After
	public void tearDown() {
		expectedUserList = null;
	}

	@Test
	public void testGetAllUsers() {
		UserDAO userDAO = new UserDAO();
		List<User> allUsers = userDAO.getAllUsers();

		assertNotNull(allUsers);
		assertEquals(expectedUserList.size(), allUsers.size());

	} 
/**
	@Test
	public void testAddAndDeleteUser() {
		UserDAO userDAO = new UserDAO();
		User u = new User();

		u.setUserName("renu");
		u.setPassword("renu");
		u.setAdminRole("admin");

		int id = userDAO.registerUser(u);
		assertTrue(id > 20);
		System.out.println(id);
		u.setUserId(id);
		boolean del = userDAO.deleteUser(u);
		System.out.println(del);
		assertTrue(del);
	}
**/
	public List<User> getExpectedUserList() {
		// Add all the users that are available in the database table User, in the same
		// order.
		List<User> userList = new ArrayList<>();
		// adding first user
		User u = new User();
		u.setUserId(30);
		u.setUserName("sindu");
		u.setPassword("test3");
		u.setAdminRole("user");

		userList.add(u);

		// adding second user
		u = new User();
		u.setUserId(10);
		u.setUserName("neeru");
		u.setPassword("test");
		u.setAdminRole("user");

		userList.add(u);

		// adding third user
		u = new User();
		u.setUserId(20);
		u.setUserName("neerja");
		u.setPassword("test1");
		u.setAdminRole("admin");

		userList.add(u);

		return userList;
	}

}
