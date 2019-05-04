package com.perscholas.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.homeinsurance.QuoteLocation;


public class QuoteLocationDAO {

	public List<QuoteLocation> getQuote(int userId) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QuoteLocation> QuoteList = new ArrayList<>();
		// assign query
		String qString = "select qd.quote_id,l.residence_type, l.address_line1,l.address_line2, l.city, l.stateinfo, l.zip_code, l.residence_use \r\n" + 
				"from quote_details qd, location l where qd.location_id = l.location_id\r\n" + 
				"and l.user_id = ? and qd.quote_id not in (select quote_id from policy_details pd where pd.user_id = ?) order by qd.quote_id";		
		// create Oracle Class connection
		DBConnectionUtils oracle = new DBConnectionUtils();

		// Begin try catch block
		try {
			// connect to database
			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QuoteLocation q = new QuoteLocation();
				q.setQuoteId(rs.getInt("quote_id"));
				q.setResidenceType(rs.getString("residence_type"));
				q.setAddressline1(rs.getString("address_line1"));
				q.setAddressline2(rs.getString("address_line2"));
				q.setCity(rs.getString("city"));
				q.setState(rs.getString("stateinfo"));
				q.setZipCode(rs.getString("zip_code"));
				q.setResidenceUse(rs.getString("residence_use"));				
				QuoteList.add(q);			
				
			}
		}

		catch ( ClassNotFoundException |IOException|SQLException e) {
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
}
