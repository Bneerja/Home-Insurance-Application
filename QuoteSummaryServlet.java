package com.perscholas.homeinsurance.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.HomeOwner;
import com.perscholas.homeinsurance.LocationPage;
import com.perscholas.homeinsurance.PropertyDetails;
import com.perscholas.homeinsurance.QuoteDetails;
import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.bo.HomeOwnerBO;
import com.perscholas.homeinsurance.bo.LocationPageBO;
import com.perscholas.homeinsurance.bo.PropertyDetailsBO;
import com.perscholas.homeinsurance.bo.QuoteDetailsBO;

//import oracle.sql.ConverterArchive;

@WebServlet("/views/QuoteSummaryServlet")
public class QuoteSummaryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int locationId = (int)session.getAttribute("locId");
		User userInfo = (User) session.getAttribute("user");
		
		LocationPage locationPage = new LocationPageBO().getLocation(userInfo.getUserId());
		HomeOwner owner = new HomeOwnerBO().getHomeOwner(userInfo.getUserId());
		PropertyDetails propertyDetails = new PropertyDetailsBO().getProperty(locationPage.getLocationId());
		QuoteDetails quoteDetails = new QuoteDetailsBO().getQuote(locationPage.getLocationId());
		session.setAttribute("location", locationPage);
		session.setAttribute("owner", owner);
		session.setAttribute("propertyDetails", propertyDetails);
		session.setAttribute("quoteDetails", quoteDetails);
		response.sendRedirect("quoteSummary.jsp");
	}
	

	
}
