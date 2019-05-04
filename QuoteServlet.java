package com.perscholas.homeinsurance.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.LocationPage;
import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.bo.LocationPageBO;

@WebServlet("/views/QuoteServlet")
public class QuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuoteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// user_id,residence_type,address_line1,address_line2,city,stateinfo,zip_code,residence_use
		
		String residenceType = request.getParameter("residencetype");
		String addressline1 = request.getParameter("addressline1");
		String addressline2 = request.getParameter("addressline2");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String zip = request.getParameter("zipcode");
		String residenceUse = request.getParameter("residenceuse");	
		
		HttpSession session =request.getSession(false);
	    User sessionUser = (User) session.getAttribute("user");
		LocationPage location = new LocationPage();
		location.setUserId(sessionUser.getUserId());
		location.setResidenceType(residenceType);
		location.setAddressline1(addressline1);
		location.setAddressline2(addressline2);
		location.setState(state);
		location.setCity(city);
		location.setZipCode(zip);
		location.setResidenceUse(residenceUse);


		int locationId =  new LocationPageBO().addLocation(location);
		System.out.println("locationId::::::::"+locationId);
		
		
		session.setAttribute("locId", locationId);
		session.setAttribute("residencyType", residenceType);
		response.sendRedirect("HomeOwnerInfo.jsp");	
		/*RequestDispatcher rd = request.getRequestDispatcher("HomeOwnerInfo.jsp");
		rd.include(request, response);*/

	}

}
