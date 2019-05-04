package com.perscholas.homeinsurance.utils;

public enum PremiumFactor {
	
	SINGLE_FAMILY_HOME("Single Family Home", 0.05f), 
	CONDO("Condo", 0.06f),
	DUPLEX("Duplex", 0.06f),
	APARTMENT("Apartment", 0.06f),
	TOWN_HOUSE("Townhouse", 0.07f),
	ROW_HOUSE("Rowhouse", 0.07f);
	
	
	private final String factorName;
	private final float value;
	
	PremiumFactor(String factorName, float value) {
		this.factorName = factorName;
		this.value = value;
		
	}
	
	public String getFactorName() {
		return this.factorName;
	}
	
	public float getValue() {
		return this.value;
	}
	
	

}
