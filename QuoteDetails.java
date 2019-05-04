package com.perscholas.homeinsurance;

/* @Author Neerja Balasubramanian
 */
public class QuoteDetails {

	private int quoteId;
	private int locationId;
	private float monthlyPremium;
	private float dwellingCoverage;
	private float detatchedStructure;
	private float personalProperty;
	private float addLivingExp;
	private float medicalExpenses;
	private float deductable;

	public QuoteDetails() {
	}

	public QuoteDetails(int quoteId, int locationId, float monthlyPremium, float dwellingCoverage,
			float detatchedStructure, float personalProperty, float addLivingExp, float medicalExpenses,
			float deductable) {
		super();
		this.quoteId = quoteId;
		this.locationId = locationId;
		this.monthlyPremium = monthlyPremium;
		this.dwellingCoverage = dwellingCoverage;
		this.detatchedStructure = detatchedStructure;
		this.personalProperty = personalProperty;
		this.addLivingExp = addLivingExp;
		this.medicalExpenses = medicalExpenses;
		this.deductable = deductable;
	}

	public int getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public float getMonthlyPremium() {
		return monthlyPremium;
	}

	public void setMonthlyPremium(float monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}

	public float getDwellingCoverage() {
		return dwellingCoverage;
	}

	public void setDwellingCoverage(float dwellingCoverage) {
		this.dwellingCoverage = dwellingCoverage;
	}

	public float getDetatchedStructure() {
		return detatchedStructure;
	}

	public void setDetatchedStructure(float detatchedStructure) {
		this.detatchedStructure = detatchedStructure;
	}

	public float getPersonalProperty() {
		return personalProperty;
	}

	public void setPersonalProperty(float personalProperty) {
		this.personalProperty = personalProperty;
	}

	public float getAddLivingExp() {
		return addLivingExp;
	}

	public void setAddLivingExp(float addLivingExp) {
		this.addLivingExp = addLivingExp;
	}

	public float getMedicalExpenses() {
		return medicalExpenses;
	}

	public void setMedicalExpenses(float medicalExpenses) {
		this.medicalExpenses = medicalExpenses;
	}

	public float getDeductable() {
		return deductable;
	}

	public void setDeductable(float deductable) {
		this.deductable = deductable;
	}

}
