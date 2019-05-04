package com.perscholas.homeinsurance.dao.JUnitTest;

import java.util.List;

import org.junit.Test;
import com.perscholas.homeinsurance.QuoteDetails;
import com.perscholas.homeinsurance.dao.QuoteDetailsDAO;
import junit.framework.TestCase;

/* @Author Neerja Balasubramanian
 */
public class QuoteDetailsDAOTest extends TestCase {

	@Test
	public void testGetAllQuote() {

		QuoteDetailsDAO Q_DAO = new QuoteDetailsDAO();
		List<QuoteDetails> allQuotes = Q_DAO.getAllQuotes();
		assertNotNull(allQuotes);
		assertTrue(allQuotes.size() >= 1);
	}

	@Test
	public void testAddQuote() {
		QuoteDetails q = new QuoteDetails();

		q.setLocationId(100);
		q.setMonthlyPremium(133);
		q.setDwellingCoverage(12);
		q.setDetatchedStructure(122);
		q.setPersonalProperty(243);
		q.setAddLivingExp(23);
		q.setMedicalExpenses(234);
		q.setDeductable(32);
		QuoteDetailsDAO q_dao = new QuoteDetailsDAO();
		int rs = q_dao.addQuote(q);
		System.out.println(rs);
		assertTrue(rs > 0);

	}

	@Test
	public void testGetQuote() {
		int locationid = 100;
		QuoteDetailsDAO q_dao = new QuoteDetailsDAO();
		QuoteDetails q = q_dao.getQuote(locationid);
		assertNotNull(q);

		assertEquals(1, q.getQuoteId());
		assertEquals(100, q.getLocationId());
		assertEquals(500.0f, q.getMonthlyPremium());
		assertEquals(30.0f, q.getDwellingCoverage());
		assertEquals(132.0f, q.getDetatchedStructure());
		assertEquals(244.0f, q.getPersonalProperty());
		assertEquals(124.0f, q.getDeductable());
		assertEquals(234.0f, q.getMedicalExpenses());
		assertEquals(24.0f, q.getAddLivingExp());
	}

}
