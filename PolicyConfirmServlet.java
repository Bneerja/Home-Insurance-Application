package com.perscholas.homeinsurance.servlets;

import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.PolicyDetails;
import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.bo.PolicyDetailsBO;

@WebServlet("/views/policyConfirmServlet")
public class PolicyConfirmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String quoteId = request.getParameter("quoteId");
		String termsAndConditions = request.getParameter("termsAndCondition");
		String policyStateDate = request.getParameter("policyStatedate");		
		System.out.println("String policyStateDate::::::::::::::"+policyStateDate);
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date policyEffectiveDate = null;
		try {
			policyEffectiveDate = formatter.parse(policyStateDate);
			System.out.println("policeEffectiveDate:::::::::::::::"+policyEffectiveDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar todaysdate = Calendar.getInstance();		
		todaysdate.add(Calendar.HOUR,60*24);
		Date maxdate = todaysdate.getTime();
		
		if(policyEffectiveDate.after(maxdate)) {
			response.sendRedirect("buyPolicy.jsp");
		}else {
			Calendar date = Calendar.getInstance();				
	    date.setTime(policyEffectiveDate);	  
	    date.add(Calendar.YEAR,1);
	    Date endDate = date.getTime();
	   
	    HttpSession session = request.getSession(false);
	    PolicyDetailsBO policybo = new PolicyDetailsBO();
	     PolicyDetails policydet = new PolicyDetails();
	     User user = (User)session.getAttribute("user");
	     policydet.setUserId(user.getUserId());
	     policydet.setQuoteId(Integer.parseInt(quoteId));
	     policydet.setPolicyEffectiveDate(policyEffectiveDate);
	     policydet.setPolicyEndDate(endDate);
	     policydet.setPolicyTerms(1);
	     policydet.setPolicyStatus("ACTIVE");
	    
	    int policyId = policybo.addPolicy(policydet);
		System.out.println("policy id is"+policyId);
		
		session.setAttribute("policyid", policyId);
		session.setAttribute("quoteid", quoteId);
		session.setAttribute("policyStateDate", policyEffectiveDate);
		session.setAttribute("policyEndDate", endDate);
		response.sendRedirect("policyConfirm.jsp");
	}
	}
}
