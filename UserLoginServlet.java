package com.perscholas.homeinsurance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.bo.UserBO;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/views/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userName = request.getParameter("username");
			String password = request.getParameter("userpass");
			UserBO userBO = new UserBO();
			boolean isValidUser = userBO.isValidUser(userName, password);

			if (isValidUser) {
				User userInfo = userBO.getUserByUserName(userName);
				HttpSession session = request.getSession(true);
				
				session.setAttribute("username", userName);
				session.setAttribute("user", userInfo);
				response.sendRedirect("Welcome.jsp");
			} else {
				response.sendRedirect("UserLogin.jsp?message=username and password doesn't match");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
