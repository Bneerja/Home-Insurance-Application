package com.perscholas.homeinsurance.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.HomeOwner;
import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.bo.HomeOwnerBO;

/**
 * Servlet implementation class HomeownerInfoServlet
 */
@WebServlet("/views/HomeownerInfoServlet")
public class HomeownerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HomeownerInfoServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String dateOfBirth = request.getParameter("dateofbirth");
		String areYouRetired = request.getParameter("optradio");
		String ssn = request.getParameter("ssn");
		String email = request.getParameter("email");	
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateOfBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
	
		HttpSession session = request.getSession(false);
		  User sessionUser = (User) session.getAttribute("user");
    
		HomeOwnerBO homeownerbo = new HomeOwnerBO();
		HomeOwner homeowner = new HomeOwner(0);
	    homeowner.setUserId(sessionUser.getUserId());
		homeowner.setFirstName(firstName);
		homeowner.setLastName(lastName);
		homeowner.setDateofbirth(date);
		homeowner.setRetired("Yes".equalsIgnoreCase(areYouRetired));
		homeowner.setSsn(ssn);
		homeowner.setEmail(email);	      
		
		int id = homeownerbo.addHomeOwner(homeowner);		
		response.sendRedirect("PropertyDetails.jsp");
/*		RequestDispatcher rd = request.getRequestDispatcher("PropertyDetails.jsp");
		rd.include(request, response);
*/		
	}
	

}
