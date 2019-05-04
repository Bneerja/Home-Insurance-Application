package com.perscholas.homeinsurance.dao.JUnitTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import com.perscholas.homeinsurance.HomeOwner;
import com.perscholas.homeinsurance.dao.HomeOwnerDAO;

import junit.framework.TestCase;
/* @Author Neerja Balasubramanian
 */
public class HomeOwnerDAOTest extends TestCase {

	@Test
	public void testGetAllHomeOwners() {

		HomeOwnerDAO H_DAO = new HomeOwnerDAO();
		List<HomeOwner> allHomeOwners = H_DAO.getAllHomeOwners();
		assertNotNull(allHomeOwners);

		assertTrue(allHomeOwners.size() > 0);

	}

	@Test
	// public void testRegister()
	public void testaddHomeOwner() {

		HomeOwner HO = new HomeOwner(30);

		HO.setFirstName("renuka");
		HO.setLastName("sree");
		Date date = new GregorianCalendar(2014, Calendar.AUGUST, 11).getTime();
		HO.setDateofbirth(date);
		HO.setRetired(false);
		HO.setSsn("123456789");
		HO.setEmail("renuka@gmail.com");

		HomeOwnerDAO HO_dao = new HomeOwnerDAO();
		int rs = HO_dao.addHomeOwner(HO);
		System.out.println(rs);
	//	assertTrue(rs);

	}

	@Test
	public void testgetHomeOwner() {
		int userid = 20;
		HomeOwnerDAO HO_dao = new HomeOwnerDAO();
		HomeOwner hoRecord = HO_dao.getHomeOwner(userid);
		assertNotNull(hoRecord);

		assertEquals("renuka", hoRecord.getFirstName());
		assertEquals("sree", hoRecord.getLastName());
		assertEquals(false, hoRecord.isRetired());
		assertEquals("123456789", hoRecord.getSsn());
		assertEquals("renuka@gmail.com", hoRecord.getEmail());

	}

}
