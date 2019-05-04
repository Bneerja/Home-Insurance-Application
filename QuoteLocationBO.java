package com.perscholas.homeinsurance.bo;

import java.util.List;

import com.perscholas.homeinsurance.QuoteLocation;
import com.perscholas.homeinsurance.dao.QuoteLocationDAO;

public class QuoteLocationBO {
	
	
	public List<QuoteLocation> getQuote(int userId) {
		QuoteLocationDAO ql_dao = new QuoteLocationDAO();
		return ql_dao.getQuote(userId);
	}
	
}
