package com.perscholas.homeinsurance.bo;

import java.util.List;

import com.perscholas.homeinsurance.PropertyDetails;
import com.perscholas.homeinsurance.dao.PropertyDetailsDAO;
/* @Author Neerja Balasubramanian
 */
public class PropertyDetailsBO {

	public boolean addProperty(PropertyDetails property) {
		PropertyDetailsDAO property_dao = new PropertyDetailsDAO();
		return property_dao.addProperty(property);
	}

	public List<PropertyDetails> getAllProperty() {
		PropertyDetailsDAO property_dao = new PropertyDetailsDAO();
		return property_dao.getAllProperty();
	}

	public PropertyDetails getProperty(int locationid) {
		PropertyDetailsDAO p_dao = new PropertyDetailsDAO();
		return p_dao.getProperty(locationid);
	}
}