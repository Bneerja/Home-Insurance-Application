package com.perscholas.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.homeinsurance.HomeOwner;
/* @Author Neerja Balasubramanian
 * HomeOwnerDAO has methods to add a new home owner,get a list of home owner and get homeowner based on the userid.
 */

public class HomeOwnerDAO {
	// addingHomeOwnerInfo
	public int addHomeOwner(HomeOwner homeowner) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = 0;
		try {
			String qString = "insert into HomeOwnerInfo(user_id,first_name,last_name,date_of_birth,retired,ssn,email_id)"
					+ "values(?,?,?,?,?,?,?)";

			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);

			pstmt.setInt(1, homeowner.getUserId());
			pstmt.setString(2, homeowner.getFirstName());
			pstmt.setString(3, homeowner.getLastName());
			pstmt.setDate(4, new java.sql.Date(homeowner.getDateofbirth().getTime()));
			if (homeowner.isRetired()) {
				pstmt.setString(5, "Y");
			} else {
				pstmt.setString(5, "N");
			}

			pstmt.setString(6, homeowner.getSsn());
			pstmt.setString(7, homeowner.getEmail());

			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			while(rs.next()) {
				id = rs.getInt(1);
			}

		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error:" + e.getMessage());
			e.getStackTrace();
			
		} finally {
			try {
				DBConnectionUtils.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return id;
	}// end of adding home owner information.

	// To get list of exiting home owner information
	public List<HomeOwner> getAllHomeOwners() {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;// should we use create statement here?
		ResultSet rs = null;
		HomeOwner HO = null;
		List<HomeOwner> HomeOwnerList = null;
		// assign query
		String qString = "select * from homeownerinfo";
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
			HomeOwnerList = new ArrayList<HomeOwner>();
			while (rs.next()) {
				HO = new HomeOwner(rs.getInt(1));

				HO.setFirstName(rs.getString(2));
				HO.setLastName(rs.getString(3));
				HO.setDateofbirth(rs.getDate(4));
				HO.setRetired(rs.getBoolean(5));
				HO.setSsn(rs.getString(6));
				HO.setEmail(rs.getString(7));

				// list
				HomeOwnerList.add(HO);
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
		return HomeOwnerList;

	}

	// To get a record of home owner information based on userid
	public HomeOwner getHomeOwner(int userid) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HomeOwner HO = null;

		// assign query
		String qString = "select * from homeownerinfo where user_id = ?";
		// create Oracle Class connection
		DBConnectionUtils oracle = new DBConnectionUtils();

		// Begin try catch block
		try {
			// connect to database
			conn = oracle.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HO = new HomeOwner(rs.getInt(1));

				HO.setUserId(rs.getInt(1));
				HO.setFirstName(rs.getString(2));
				HO.setLastName(rs.getString(3));
				HO.setDateofbirth(rs.getDate(4));
				HO.setRetired(rs.getBoolean(5));
				HO.setSsn(rs.getString(6));
				HO.setEmail(rs.getString(7));

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
		return HO;

	}

	public void getHomeOwnerById(int homeOwnerInfoId) {
		
		
	}
}
