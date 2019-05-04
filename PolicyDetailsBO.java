package com.perscholas.homeinsurance.bo;

import java.util.List;

import com.perscholas.homeinsurance.PolicyDetails;
import com.perscholas.homeinsurance.dao.PolicyDetailsDAO;

/* @Author Neerja Balasubramanian
 */
public class PolicyDetailsBO {
	public int addPolicy(PolicyDetails policy) {
		PolicyDetailsDAO policy_dao = new PolicyDetailsDAO();
		return policy_dao.addPolicy(policy);
	}

	public List<PolicyDetails> getAllPolicy(int userId) {
		PolicyDetailsDAO policy_dao = new PolicyDetailsDAO();
		return policy_dao.getAllPolicy(userId);
	}

	public PolicyDetails getPolicy(int userid) {
		PolicyDetailsDAO policy_dao = new PolicyDetailsDAO();
		return policy_dao.getPolicy(userid);

	}
	
	public boolean cancelPolicy(int policyId) {
		PolicyDetailsDAO policy_dao = new PolicyDetailsDAO();
		return policy_dao.cancelPolicy(policyId);
	}

}
