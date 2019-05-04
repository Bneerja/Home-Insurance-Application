package com.perscholas.homeinsurance.dao.JUnitTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import com.perscholas.homeinsurance.PolicyDetails;
import com.perscholas.homeinsurance.dao.PolicyDetailsDAO;

import junit.framework.TestCase;

/* @Author Neerja Balasubramanian
 */
public class PolicyDetailsDAOTest extends TestCase {

	@Test
	public void testGetAllPolicy() {

		PolicyDetailsDAO P_DAO = new PolicyDetailsDAO();
		List<PolicyDetails> allPolicy = P_DAO.getAllPolicy(1);
		assertNotNull(allPolicy);
	}

	@Test
	public void testaddPolicy() {
		PolicyDetails po = new PolicyDetails();
		po.setQuoteId(2);
		po.setUserId(10);
		Date date = new GregorianCalendar(2005, Calendar.JANUARY, 15).getTime();
		po.setPolicyEffectiveDate(date);
		Date date1 = new GregorianCalendar(2008, Calendar.JANUARY, 15).getTime();
		po.setPolicyEndDate(date1);
		po.setPolicyTerms(2);
		po.setPolicyStatus("CANCELLED");

		PolicyDetailsDAO po_dao = new PolicyDetailsDAO();
		int rs = po_dao.addPolicy(po);
		System.out.println(rs);
		assertTrue(rs>0);

	}

	@Test
	public void testgetPolicy() {
		int userid = 20;
		PolicyDetailsDAO pd_dao = new PolicyDetailsDAO();
		PolicyDetails pd = pd_dao.getPolicy(userid);

	//	assertEquals(1, pd.size());

		//PolicyDetails pd = plist.get(0);

		assertEquals(2, pd.getPolicyId());
		assertEquals(1, pd.getQuoteId());
		assertEquals(20, pd.getUserId());
		Date date = new GregorianCalendar(2005, Calendar.JANUARY, 15).getTime();
		assertEquals(date, pd.getPolicyEffectiveDate());
		Date date1 = new GregorianCalendar(2008, Calendar.JANUARY, 15).getTime();
		assertEquals(date1, pd.getPolicyEndDate());
		assertEquals(2, pd.getPolicyTerms());
		assertEquals("CANCELLED", pd.getPolicyStatus());
	}

}