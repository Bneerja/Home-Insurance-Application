package com.perscholas.homeinsurance.bo;

import java.util.Calendar;

import com.perscholas.homeinsurance.PropertyDetails;
import com.perscholas.homeinsurance.utils.PremiumFactor;

public class QuoteCalculation {
	public static final int RATE = 5;
	public static final int EXPOSURE_UNITS = 1000;

	public float calculateMonthlyPremium(PropertyDetails property, String residencyType) {
		

		float yearly_premium = (RATE * (property.getMarketvalue() / EXPOSURE_UNITS));
		float factorValue = 0f;
		for(PremiumFactor factor : PremiumFactor.values()) {
			if(factor.getFactorName().equalsIgnoreCase(residencyType)) {
				factorValue = factor.getValue();
			}
		}
		float actualPremium = yearly_premium + (factorValue * yearly_premium)/100;
		System.out.println("actualPremium:::::::::"+actualPremium);
		return (actualPremium / 12);

	}

	public float calculateDwellingCoverage(PropertyDetails property) {

		int squareFootArea = property.getSquarefoot();
		double homeValue = 120 * squareFootArea;
		
		int currentyear = Calendar.getInstance().get(Calendar.YEAR);
		int ageOfHome = currentyear - property.getYear();
		if (ageOfHome < 5) { // reduce 10% from homeValue

			homeValue = homeValue - ((10 * homeValue)/100);

		} else if ((ageOfHome > 5) && (ageOfHome < 10)) { // reduce 20% from home value
			homeValue = homeValue - (0.2 * homeValue);

		} else if ((ageOfHome > 10) && (ageOfHome < 20)) { // reduce 30% from home value
			homeValue = homeValue - (0.3 * homeValue);

		} else if ((ageOfHome > 20)) { // reduce 50% from home value

			homeValue = homeValue - (0.5 * homeValue);
		}
		System.out.println("homeValue:::::::::"+homeValue);

		return (float) ((property.getMarketvalue() * 0.5) + homeValue);
	}

	public float getDetatchedStructure(PropertyDetails property) {
		float dwellCoverage = calculateDwellingCoverage(property);
		float detatchedStructure = (float) (0.1 * dwellCoverage);
		return detatchedStructure;
	}

	public float getPersonalProperty(PropertyDetails property) {
		float dwellCoverage = calculateDwellingCoverage(property);
		float personalProperty = (float) (0.6 * dwellCoverage);
		return personalProperty;
	}

	public float getAddLivingExp(PropertyDetails property) {

		float dwellCoverage = calculateDwellingCoverage(property);
		float addLivingExp = (float) (0.2 * dwellCoverage);
		return addLivingExp;
	}

	public float getDeductable(PropertyDetails property) {

		return (float) (property.getMarketvalue() * 0.01);
	}

	public float getMedicalExpenses() {

		int medicalExp = 5000;
		return medicalExp;
	}

}
