package com.perscholas.homeinsurance.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.homeinsurance.PolicyDetails;
import com.perscholas.homeinsurance.User;
import com.perscholas.homeinsurance.bo.PolicyDetailsBO;
import com.perscholas.homeinsurance.bo.UserBO;

/**
 * Servlet implementation class PolicyListServlet
 */
@WebServlet("/views/PolicyListServlet")
public class PolicyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PolicyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		UserBO user_bo = new UserBO();
		User user = user_bo.getUserByUserName(username);
		
		PolicyDetailsBO pd_bo = new PolicyDetailsBO();
		
		List<PolicyDetails> policyList = pd_bo.getAllPolicy(user.getUserId());
		
		HttpSession session = request.getSession(false);
		session.setAttribute("suser", user);
		session.setAttribute("plist",policyList );
		response.sendRedirect("ViewPolicies.jsp");
		
			
		
	}

}
