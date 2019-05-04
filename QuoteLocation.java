package com.perscholas.homeinsurance;

public class QuoteLocation extends LocationPage {
	
	private int quoteId;

	

	public QuoteLocation(int quoteId,int locationId, int userId, String residenceType, String addressline1, String addressline2,
			String city, String state, String zipCode, String residenceUse) {
		super(locationId, userId, residenceType, addressline1, addressline2, city, state, zipCode, residenceUse);
		this.quoteId = quoteId;
		// TODO Auto-generated constructor stub
	}



	public QuoteLocation() {
		// TODO Auto-generated constructor stub
	}



	public int getQuoteId() {
		return quoteId;
	}



	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

}
