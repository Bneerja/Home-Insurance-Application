package com.perscholas.homeinsurance.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.QuoteLocation;
import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.bo.QuoteLocationBO;

/**
 * Servlet implementation class RetrieveQuote
 */
@WebServlet("/views/RetrieveQuoteServlet")
public class RetrieveQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveQuoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		  User currentuser = (User) session.getAttribute("user");
		     QuoteLocationBO q_bo = new QuoteLocationBO();	     		   
		     List<QuoteLocation>  Qlist = q_bo.getQuote(currentuser.getUserId());
		     
		     session.setAttribute("QuoteLocationList", Qlist);
		     response.sendRedirect("RetrieveQuote.jsp");
		     
		     
		     
		     
		     
		     
		  
		
	}

}
