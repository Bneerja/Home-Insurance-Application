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

/**
 * Servlet implementation class UpdatePolicyServlet
 */
@WebServlet("/views/UpdatePolicyServlet")
public class UpdatePolicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePolicyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (request.getParameter("cancel") != null) {
			int policyId = (int) session.getAttribute("pid");
			PolicyDetailsBO pd_bo = new PolicyDetailsBO();
			if (pd_bo.cancelPolicy(policyId)) {
				
				User user = (User) session.getAttribute("suser");
				List<PolicyDetails> policyList = pd_bo.getAllPolicy(user.getUserId());
				session.setAttribute("plist", policyList);
			}
			response.sendRedirect("ViewPolicies.jsp");

		}
	}

}
