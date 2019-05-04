package com.perscholas.homeinsurance.dao.JUnitTest;

import java.util.List;
import org.junit.Test;
import com.perscholas.homeinsurance.LocationPage;
import com.perscholas.homeinsurance.dao.LocationPageDAO;

import junit.framework.TestCase;
/* @Author Neerja Balasubramanian
 */
public class LocationPageDAOTest extends TestCase {
	
	@Test
	public  void testGetAllLocation() {
		LocationPageDAO L_DAO = new LocationPageDAO();
		List<LocationPage> allLocations = L_DAO.getAllLocation();
		assertNotNull(allLocations);
		assertTrue(allLocations.size()>0);	

	}
	
	@Test
	public void testaddLocation() {

		LocationPage L = new LocationPage();

	    L.setUserId(10);
	    L.setResidenceType("Duplex");
	    L.setAddressline1("120C");
	    L.setCity("irving");
	    L.setState("tx");
	    L.setZipCode("76038");
	    L.setResidenceUse("Secondary");
	    
	    LocationPageDAO L_dao = new LocationPageDAO();	    
		
		int rs = L_dao.addLocation(L);
		System.out.println(rs);
		//assertTrue(rs);
	}
	@Test
	public void testgetLocation() {		
		int userid = 20;
		LocationPageDAO L_dao = new LocationPageDAO();	
		LocationPage locRecord = L_dao.getLocation(userid);
		assertNotNull(locRecord);
		
		assertEquals(200,locRecord.getLocationId());
		assertEquals("Duplex", locRecord.getResidenceType());
		assertEquals("410A",locRecord.getAddressline1());
		assertEquals("irving",locRecord.getAddressline2());
		assertEquals("dallas",locRecord.getCity());
		assertEquals("tx",locRecord.getState());		
		assertEquals("Primary",locRecord.getResidenceUse());
		
	}
	
}
