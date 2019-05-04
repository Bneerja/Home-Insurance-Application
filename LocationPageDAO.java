package com.perscholas.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.homeinsurance.LocationPage;

/* @Author Neerja Balasubramanian
 * LocationPageDAO has methods to add a location,get list of locations, get location based on userid.
 */
public class LocationPageDAO {
	// addinglocationInfo
	public int addLocation(LocationPage location) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = 0;
		try {
			String qString = "insert into Location(user_id,residence_type,address_line1,address_line2,city,stateinfo,zip_code,residence_use)"
					+ "values(?,?,?,?,?,?,?,?)";
			String[] COL = { "location_id" };

			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString, COL);

			pstmt.setInt(1, location.getUserId());
			pstmt.setString(2, location.getResidenceType());
			pstmt.setString(3, location.getAddressline1());
			pstmt.setString(4, location.getAddressline2());
			pstmt.setString(5, location.getCity());
			pstmt.setString(6, location.getState());
			pstmt.setString(7, location.getZipCode());
			pstmt.setString(8, location.getResidenceUse());

			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
			}
			System.out.println("location id::::::::::"+id);

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
	}// end of adding location information.

	// To get list of exiting location information
	public List<LocationPage> getAllLocation() {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LocationPage Lp = null;
		List<LocationPage> LocationList = null;
		// assign query
		String qString = "select * from location";
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
			LocationList = new ArrayList<LocationPage>();
			while (rs.next()) {
				Lp = new LocationPage();

				Lp.setLocationId(rs.getInt(1));
				Lp.setUserId(rs.getInt(2));
				Lp.setResidenceType(rs.getString(3));
				Lp.setAddressline1(rs.getString(4));
				Lp.setAddressline2(rs.getString(5));
				Lp.setCity(rs.getString(6));
				Lp.setState(rs.getString(7));
				Lp.setZipCode(rs.getString(8));
				Lp.setResidenceUse(rs.getString(9));

				// list
				LocationList.add(Lp);
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
		return LocationList;

	}

	// To get a record of location information based on userid
	public LocationPage getLocation(int userid) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LocationPage Lp = null;

		// assign query
		String qString = "select * from location where user_id = ?";
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
				Lp = new LocationPage();
				Lp.setLocationId(rs.getInt(1));
				Lp.setUserId(rs.getInt(2));
				Lp.setResidenceType(rs.getString(3));
				Lp.setAddressline1(rs.getString(4));
				Lp.setAddressline2(rs.getString(5));
				Lp.setCity(rs.getString(6));
				Lp.setState(rs.getString(7));
				Lp.setZipCode(rs.getString(8));
				Lp.setResidenceUse(rs.getString(9));
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
		return Lp;

	}
	
	public LocationPage getLocationById(int locationId) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LocationPage locationPage = null;

		// assign query
		String qString = "select * from location where location_id = ?";
		// create Oracle Class connection

		// Begin try catch block
		try {
			// connect to database
			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			pstmt.setInt(1, locationId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				locationPage = new LocationPage();
				locationPage.setLocationId(rs.getInt(1));
				locationPage.setUserId(rs.getInt(2));
				locationPage.setResidenceType(rs.getString(3));
				locationPage.setAddressline1(rs.getString(4));
				locationPage.setAddressline2(rs.getString(5));
				locationPage.setCity(rs.getString(6));
				locationPage.setState(rs.getString(7));
				locationPage.setZipCode(rs.getString(8));
				locationPage.setResidenceUse(rs.getString(9));
			}

		}

		catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error:" + e.getMessage());
			e.getStackTrace();

		} finally {
			try {
				DBConnectionUtils.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return locationPage;

	}
	
	
}
