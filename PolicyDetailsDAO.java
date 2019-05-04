package com.perscholas.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.homeinsurance.PolicyDetails;

/* @Author Neerja Balasubramanian
 * PolicyDetailsDAO has methods to add a policy,view all policies and get a policy based on userid.
 */
public class PolicyDetailsDAO {
	// add policy details
	public int addPolicy(PolicyDetails policy) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String qString = "insert into policy_details(quote_id,user_id,policy_effective_date,policy_end_date,policy_terms,policy_status)"
					+ "values(?,?,?,?,?,?)";
		//	DBConnectionUtils oracle = new DBConnectionUtils();
			String[] COL = { "policy_id" };

			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString, COL);

			pstmt.setInt(1, policy.getQuoteId());
			pstmt.setInt(2, policy.getUserId());
			pstmt.setDate(3, new java.sql.Date(policy.getPolicyEffectiveDate().getTime()));
			pstmt.setDate(4, new java.sql.Date(policy.getPolicyEndDate().getTime()));
			pstmt.setLong(5, policy.getPolicyTerms());
			pstmt.setString(6, policy.getPolicyStatus());

		    pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs!=null && rs.next()) {
				result = rs.getInt(1);
				System.out.println("from db"+result);
			} else {
				System.out.println("policy id not created");
			}

		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error:" + e.getMessage());
			e.getStackTrace();
		
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}// end of adding policy details.

	// To get list of exiting location information
	public List<PolicyDetails> getAllPolicy(int userId) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;// should we use create statement here?
		ResultSet rs = null;
		PolicyDetails PD = null;
		List<PolicyDetails> PolicyList = null;
		// assign query
		String qString = "select quote_id,policy_id,policy_effective_date,policy_end_date,policy_terms,policy_status from policy_details where user_id = ?";
		// create Oracle Class connection
		DBConnectionUtils oracle = new DBConnectionUtils();

		// Begin try catch block
		try {
			// connect to database
			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			pstmt.setInt(1,userId);
			rs = pstmt.executeQuery();
			// display the Policylist
			PolicyList = new ArrayList<PolicyDetails>();
			while (rs.next()) {
				PD = new PolicyDetails();
				
				PD.setQuoteId(rs.getInt(1));
				PD.setPolicyId(rs.getInt(2));
				PD.setPolicyEffectiveDate(rs.getDate(3));
				PD.setPolicyEndDate(rs.getDate(4));
				PD.setPolicyTerms(rs.getLong(5));
				PD.setPolicyStatus(rs.getString(6));

				// list
				PolicyList.add(PD);
			}
		}

		catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error:" + e.getMessage());
			e.getStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return PolicyList;

	}

	public PolicyDetails getPolicy(int userid) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PolicyDetails pd = null;
		
		// assign query
		String qString = "select * from policy_details where user_id = ?";
		// create Oracle Class connection
		DBConnectionUtils oracle = new DBConnectionUtils();

		// Begin try catch block
		try {
			// connect to database
			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pd = new PolicyDetails();

				pd.setPolicyId(rs.getInt(1));
				pd.setQuoteId(rs.getInt(2));
				pd.setUserId(rs.getInt(3));
				pd.setPolicyEffectiveDate(rs.getDate(4));
				pd.setPolicyEndDate(rs.getDate(5));
				pd.setPolicyTerms(rs.getLong(6));
				pd.setPolicyStatus(rs.getString(7));				
			

			}
		}

		catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error:" + e.getMessage());
			e.getStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pd;

	}
	public boolean cancelPolicy(int policyId) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		PolicyDetails pd = null;
		boolean result= true;
		// assign query
		String qString = "update policy_details set policy_status = 'cancelled' where policy_id = ?";
		// create Oracle Class connection
		DBConnectionUtils oracle = new DBConnectionUtils();

		// Begin try catch block
		try {
			// connect to database
			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			pstmt.setInt(1, policyId);
			pstmt.executeQuery();
			}

		catch (ClassNotFoundException | IOException | SQLException e) {
			result=false;
			System.out.println("Error:" + e.getMessage());
			e.getStackTrace();

		} finally {
			try {
				
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}
    
}
