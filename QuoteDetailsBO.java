package com.perscholas.homeinsurance.bo;

import java.util.List;

import com.perscholas.homeinsurance.QuoteDetails;
import com.perscholas.homeinsurance.dao.QuoteDetailsDAO;

/* @Author Neerja Balasubramanian
 */
public class QuoteDetailsBO {

	public int addQuote(QuoteDetails quote) {
		QuoteDetailsDAO quote_dao = new QuoteDetailsDAO();
		return quote_dao.addQuote(quote);
	}

	public List<QuoteDetails> getAllQuotes() {
		QuoteDetailsDAO quote_dao = new QuoteDetailsDAO();
		return quote_dao.getAllQuotes();
	}

	public QuoteDetails getQuote(int locationid) {
		QuoteDetailsDAO quote_dao = new QuoteDetailsDAO();
		return quote_dao.getQuote(locationid);
	}
}
