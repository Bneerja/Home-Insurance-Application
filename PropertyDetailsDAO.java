package com.perscholas.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.homeinsurance.PropertyDetails;

/* @Author Neerja Balasubramanian
 * PropertyDetailsDAO has methods to add a property,view a property based on location and view list of properties.
 */
public class PropertyDetailsDAO {
	// adding property details
	public boolean addProperty(PropertyDetails property) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String qString = "insert into Property_Details(location_id,market_value,year_built,square_foot,dwelling_style,"
					+ "roofing_material,type_of_garage,number_of_full_baths,number_of_half_baths,swimming_pool)"
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			conn = DBConnectionUtils.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			pstmt.setInt(1, property.getLocationId());
			pstmt.setFloat(2, property.getMarketvalue());
			pstmt.setInt(3, property.getYear());
			pstmt.setLong(4, property.getSquarefoot());
			pstmt.setString(5, property.getDwellingStyle());
			pstmt.setString(6, property.getRoofingMaterial());
			pstmt.setString(7, property.getGarageType());
			pstmt.setInt(8, property.getNumberOfFullbaths());
			pstmt.setInt(9, property.getNumberOfHalfbaths());
			pstmt.setString(10, property.getSwimmingPool());

			int count = pstmt.executeUpdate();
			System.out.println("count::::::::::::::::"+count);
			if (count > 0)
				return true;
			return false;

		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error:" + e.getMessage());
			e.getStackTrace();
			return false;
		} finally {
			try {
				DBConnectionUtils.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}// end of adding property details.

	// To get list of exiting property information
	public List<PropertyDetails> getAllProperty() {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PropertyDetails pd = null;
		List<PropertyDetails> PropertyList = null;
		// assign query
		String qString = "select * from property_details";
		// create Oracle Class connection
		DBConnectionUtils oracle = new DBConnectionUtils();

		// Begin try catch block
		try {
			// connect to database
			conn = oracle.getConnection();
			System.out.println("Connected to database");
			pstmt = conn.prepareStatement(qString);
			rs = pstmt.executeQuery();
			// display the Property list
			PropertyList = new ArrayList<PropertyDetails>();
			while (rs.next()) {
				pd = new PropertyDetails(rs.getInt(1));

				pd.setMarketvalue(rs.getFloat(2));
				pd.setYear(rs.getInt(3));
				pd.setSquarefoot(rs.getInt(4));
				pd.setDwellingStyle(rs.getString(5));
				pd.setRoofingMaterial(rs.getString(6));
				pd.setGarageType(rs.getString(7));
				pd.setNumberOfFullbaths(rs.getInt(8));
				pd.setNumberOfHalfbaths(rs.getInt(9));
				pd.setSwimmingPool(rs.getString(10));

				// list
				PropertyList.add(pd);
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
		return PropertyList;

	}

	// To get a record of home owner information based on locationid
	public PropertyDetails getProperty(int locationid) {
		// Declare variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PropertyDetails pd = null;

		// assign query
		String qString = "select * from property_details where location_id = ?";
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
				pd = new PropertyDetails(rs.getInt(1));

				pd.setMarketvalue(rs.getFloat(2));
				pd.setYear(rs.getInt(3));
				pd.setSquarefoot(rs.getInt(4));
				pd.setDwellingStyle(rs.getString(5));
				pd.setRoofingMaterial(rs.getString(6));
				pd.setGarageType(rs.getString(7));
				pd.setNumberOfFullbaths(rs.getInt(8));
				pd.setNumberOfHalfbaths(rs.getInt(9));
				pd.setSwimmingPool(rs.getString(10));

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
}
