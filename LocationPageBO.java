package com.perscholas.homeinsurance.bo;

import java.util.List;

import com.perscholas.homeinsurance.LocationPage;
import com.perscholas.homeinsurance.dao.LocationPageDAO;

/* @Author Neerja Balasubramanian
 */
public class LocationPageBO {

	public int addLocation(LocationPage location) {
		LocationPageDAO location_dao = new LocationPageDAO();
		return location_dao.addLocation(location);
	}

	public List<LocationPage> getAllLocation() {
		LocationPageDAO location_dao = new LocationPageDAO();
		return location_dao.getAllLocation();
	}

	public LocationPage getLocation(int userid) {
		LocationPageDAO location_dao = new LocationPageDAO();
		return location_dao.getLocation(userid);
	}
	
	public LocationPage getLocationById(int locationId) {
		return new LocationPageDAO().getLocationById(locationId);
	}

}
