package com.perscholas.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.homeinsurance.QuoteDetails;

/* @Author Neerja Balasubramanian
 * QuoteDetailsDAO has methods to add Quote,select a quote and get a list of quotes
 */
public class QuoteDetailsDAO {
	// insert Quote Details
	public int addQuote(QuoteDetails quote) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = 0;
		try {
			String qString = "insert into quote_details(location_id,monthly_premium,dwelling_coverage,detatched_structure,personal_property,add_living_exp,"
					+ "medical_expenses,deductable) values(?,?,?,?,?,?,?,?)";
			DBConnectionUtils oracle = new DBConnectionUtils();
			String[] COL = { "quote_id" };

			conn = oracle.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString, COL);

			pstmt.setInt(1, quote.getLocationId());
			pstmt.setFloat(2, quote.getMonthlyPremium());
			pstmt.setFloat(3, quote.getDwellingCoverage());
			pstmt.setFloat(4, quote.getDetatchedStructure());
			pstmt.setFloat(5, quote.getPersonalProperty());
			pstmt.setFloat(6, quote.getAddLivingExp());
			pstmt.setFloat(7, quote.getMedicalExpenses());
			pstmt.setFloat(8, quote.getDeductable());

			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
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
		return id;
	}

	// get Quote
	public List<QuoteDetails> getAllQuotes() {

		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;// should we use create statement here?
		ResultSet rs = null;
		QuoteDetails Q = null;
		List<QuoteDetails> QuoteList = null;
		// assign query
		String qString = "select * from quote_details";
		// create Oracle Class connection
		DBConnectionUtils oracle = new DBConnectionUtils();

		// Begin try catch block
		try {
			// connect to database
			conn = oracle.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			rs = pstmt.executeQuery();
			// display the list
			QuoteList = new ArrayList<QuoteDetails>();
			while (rs.next()) {
				Q = new QuoteDetails();

				Q.setQuoteId(rs.getInt(1));
				Q.setLocationId(rs.getInt(2));
				Q.setMonthlyPremium(rs.getFloat(3));
				Q.setDwellingCoverage(rs.getFloat(4));
				Q.setDetatchedStructure(rs.getFloat(5));
				Q.setPersonalProperty(rs.getFloat(6));
				Q.setAddLivingExp(rs.getFloat(7));
				Q.setMedicalExpenses(rs.getFloat(8));
				Q.setDeductable(rs.getFloat(9));

				// QuoteList
				QuoteList.add(Q);
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
		return QuoteList;
	}

	public QuoteDetails getQuote(int locationid) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QuoteDetails qd = null;

		// assign query
		String qString = "select * from quote_details where location_id = ?";
		// create Oracle Class connection
		DBConnectionUtils oracle = new DBConnectionUtils();

		// Begin try catch block
		try {
			// connect to database
			conn = oracle.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			pstmt.setInt(1, locationid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				qd = new QuoteDetails();

				qd.setQuoteId(rs.getInt(1));
				qd.setLocationId(rs.getInt(2));
				qd.setMonthlyPremium(rs.getFloat(3));
				qd.setDwellingCoverage(rs.getFloat(4));
				qd.setDetatchedStructure(rs.getFloat(5));
				qd.setPersonalProperty(rs.getFloat(6));
				qd.setAddLivingExp(rs.getFloat(7));
				qd.setMedicalExpenses(rs.getFloat(8));
				qd.setDeductable(rs.getFloat(9));

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
		return qd;

	}

}
