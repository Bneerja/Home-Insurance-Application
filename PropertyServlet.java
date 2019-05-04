package com.perscholas.homeinsurance.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.PropertyDetails;
import com.perscholas.homeinsurance.QuoteDetails;
import com.perscholas.homeinsurance.bo.PropertyDetailsBO;
import com.perscholas.homeinsurance.bo.QuoteCalculation;
import com.perscholas.homeinsurance.bo.QuoteDetailsBO;

/**
 * Servlet implementation class PropertyServlet
 */
@WebServlet("/views/PropertyServlet")
public class PropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PropertyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		float mktvalue = Float.parseFloat(request.getParameter("marketvalue"));
		int year = Integer.parseInt(request.getParameter("year"));
		int sqft = Integer.parseInt(request.getParameter("sqft"));
		String dwelling = request.getParameter("dwellingstyle");
		String roof = request.getParameter("roofmaterial");
		String garage = request.getParameter("garagetype");
		int fullbath = Integer.parseInt(request.getParameter("fullbath"));
		int halfbath = Integer.parseInt(request.getParameter("halfbath"));
		String pool = request.getParameter("optradio");

		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("locId");
		System.out.println("location id:::::::::::::"+id);
		String residencyType = String.valueOf(session.getAttribute("residencyType"));
		System.out.println("residencyType::::::::::::::::::" + residencyType);
		PropertyDetailsBO propertybo = new PropertyDetailsBO();
		PropertyDetails property = new PropertyDetails(id);

		property.setMarketvalue(mktvalue);
		property.setYear(year);
		property.setSquarefoot(sqft);
		property.setDwellingStyle(dwelling);
		property.setRoofingMaterial(roof);
		property.setGarageType(garage);
		property.setNumberOfFullbaths(fullbath);
		property.setNumberOfHalfbaths(halfbath);
		property.setSwimmingPool(pool != null ? pool.equalsIgnoreCase("yes")? "Y" : "N" : "N");

		propertybo.addProperty(property);

		if (property != null) {

			QuoteCalculation cal = new QuoteCalculation();

			QuoteDetailsBO quotebo = new QuoteDetailsBO();
			QuoteDetails quote = new QuoteDetails();

			quote.setMonthlyPremium(cal.calculateMonthlyPremium(property, residencyType));
			quote.setDetatchedStructure(cal.getDetatchedStructure(property));
			quote.setPersonalProperty(cal.getPersonalProperty(property));
			quote.setAddLivingExp(cal.getAddLivingExp(property));
			quote.setMedicalExpenses(cal.getMedicalExpenses());
			quote.setDeductable(cal.getDeductable(property));
			quote.setDwellingCoverage(cal.calculateDwellingCoverage(property));
			quote.setLocationId(id);
			int qid = quotebo.addQuote(quote);
			System.out.println("quote id:::::::::::"+qid);
			System.out.println("quote quote.getMonthlyPremium():::::::::::"+quote.getMonthlyPremium());
			System.out.println("quote quote.getDwellingCoverage():::::::::::"+quote.getDwellingCoverage());
			quote.setQuoteId(qid);

			session.setAttribute("quote", quote);
			session.setAttribute("qid", qid);
			session.setAttribute("qpremium", quote.getMonthlyPremium());
			session.setAttribute("qcoverage", quote.getDwellingCoverage());
			session.setAttribute("qstructure", quote.getDetatchedStructure());
			session.setAttribute("qproperty", quote.getPersonalProperty());
			session.setAttribute("qlivexp", quote.getAddLivingExp());
			session.setAttribute("qmedexp", quote.getMedicalExpenses());
			session.setAttribute("qded", quote.getDeductable());

			/*RequestDispatcher rd = request.getRequestDispatcher("Coverage.jsp");
			rd.include(request, response);*/
			response.sendRedirect("Coverage.jsp");;

		}

	}
}
