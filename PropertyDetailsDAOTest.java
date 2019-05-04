package com.perscholas.homeinsurance.dao.JUnitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.perscholas.homeinsurance.PropertyDetails;
import com.perscholas.homeinsurance.dao.PropertyDetailsDAO;

/* @Author Neerja Balasubramanian
 */
public class PropertyDetailsDAOTest {

	@Test
	public void testGetAllProperty() {

		PropertyDetailsDAO P_DAO = new PropertyDetailsDAO();
		List<PropertyDetails> allProperty = P_DAO.getAllProperty();

		assertNotNull(allProperty);

	}

	@Test
	public void testaddProperty() {
		PropertyDetailsDAO p_dao = new PropertyDetailsDAO();
		PropertyDetails po = new PropertyDetails(200);
		po.setMarketvalue(12345);
		po.setYear(1999);
		po.setSquarefoot(2300);
		po.setDwellingStyle("2 Stories");
		po.setRoofingMaterial("Clay");
		po.setGarageType("Detached");
		po.setNumberOfFullbaths(2);
		po.setNumberOfHalfbaths(1);
		po.setSwimmingPool("Y");

		boolean rs = p_dao.addProperty(po);
		System.out.println(rs);
		assertTrue(rs);
	}

	@Test
	public void testgetProperty() {
		int locationid = 100;
		PropertyDetailsDAO lo_dao = new PropertyDetailsDAO();
		PropertyDetails pdrecord = lo_dao.getProperty(locationid);
		assertNotNull(pdrecord);

		assertEquals(89000.0f, pdrecord.getMarketvalue(), 0.0);
		assertEquals(2002, pdrecord.getYear());
		assertEquals(2000, pdrecord.getSquarefoot());
		assertEquals("1 Story", pdrecord.getDwellingStyle());
		assertEquals("Concrete", pdrecord.getRoofingMaterial());
		assertEquals("Attached", pdrecord.getGarageType());
		assertEquals(2, pdrecord.getNumberOfFullbaths());
		assertEquals(1, pdrecord.getNumberOfHalfbaths());
		assertEquals("Y", pdrecord.getSwimmingPool());

	}
}
