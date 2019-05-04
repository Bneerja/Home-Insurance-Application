package com.perscholas.homeinsurance.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.bo.UserBO;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/views/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("username");
			System.out.println(userName);
			String password = request.getParameter("userpass");
			System.out.println(password);
			UserBO userBO = new UserBO();
			boolean isValidUser = userBO.isValidUser(userName, password);

			if (isValidUser) {
				User userInfo = userBO.getUserByUserName(userName);
				if(userInfo.getAdminRole().equalsIgnoreCase("admin")) {				
				HttpSession session = request.getSession(true);					
				session.setAttribute("user", userInfo);				
				response.sendRedirect("AdminLogin.jsp");
				} else {
					response.sendRedirect("UserLogin.jsp?message=user doesnot have admin role");
				}
			} else {
				response.sendRedirect("UserLogin.jsp?message=username and password doesn't match");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

}
