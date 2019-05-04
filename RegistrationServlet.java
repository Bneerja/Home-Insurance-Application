package com.perscholas.homeinsurance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.bo.UserBO;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/views/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("username");
		String userPass = request.getParameter("userpass");
		String confirmPass = request.getParameter("confirmpass");
		String userPassword;
		
		System.out.println(userName);
		System.out.println(userPass);
		System.out.println(confirmPass);
		
		if(userPass.equals(confirmPass)) {
			
			User user = new User();
			user.setUserName(userName);
			user.setPassword(userPass);
			UserBO userBO = new UserBO();
			int id = userBO.registerUser(user);	
            RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
    		rd.include(request, response);
			
		}else {
			request.setAttribute("errorMessage", "Username and/or password did not match our records.");
			response.sendRedirect("Registration.jsp");
		}
		

	}	

}
