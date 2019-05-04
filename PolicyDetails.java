package com.perscholas.homeinsurance;

import java.util.Date;

/* @Author Neerja Balasubramanian
 */
public class PolicyDetails {

	private int policyId;
	private int quoteId;
	private int userId;
	private Date policyEffectiveDate;
	private Date policyEndDate;
	private long policyTerms;
	private String policyStatus;

	public PolicyDetails() {

	}

	public PolicyDetails(int policyId, int quoteId, int userId, Date policyEffectiveDate, Date policyEndDate,
			long policyTerms, String policyStatus) {
		super();
		this.policyId = policyId;
		this.quoteId = quoteId;
		this.userId = userId;
		this.policyEffectiveDate = policyEffectiveDate;
		this.policyEndDate = policyEndDate;
		this.policyTerms = policyTerms;
		this.policyStatus = policyStatus;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public int getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getPolicyEffectiveDate() {
		return policyEffectiveDate;
	}

	public void setPolicyEffectiveDate(Date policyEffectiveDate) {
		this.policyEffectiveDate = policyEffectiveDate;
	}

	public Date getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public long getPolicyTerms() {
		return policyTerms;
	}

	public void setPolicyTerms(long policyTerms) {
		this.policyTerms = policyTerms;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

}
