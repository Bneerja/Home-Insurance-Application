package com.perscholas.homeinsurance;

/* @Author Neerja Balasubramanian
 */
public class PropertyDetails {
	private int locationId;
	private float marketvalue;
	private int year;
	private int squarefoot;
	private String dwellingStyle;
	private String roofingMaterial;
	private String garageType;
	private int numberOfFullbaths;
	private int numberOfHalfbaths;
	private String swimmingPool;

	public PropertyDetails(int locationId) {
		this.locationId = locationId;
	}

	public PropertyDetails(int locationId, float marketvalue, int year, int squarefoot, String dwellingStyle,
			String roofingMaterial, String garageType, int numberOfFullbaths, int numberOfHalfbaths,
			String swimmingPool) {
		super();
		this.locationId = locationId;
		this.marketvalue = marketvalue;
		this.year = year;
		this.squarefoot = squarefoot;
		this.dwellingStyle = dwellingStyle;
		this.roofingMaterial = roofingMaterial;
		this.garageType = garageType;
		this.numberOfFullbaths = numberOfFullbaths;
		this.numberOfHalfbaths = numberOfHalfbaths;
		this.swimmingPool = swimmingPool;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public float getMarketvalue() {
		return marketvalue;
	}

	public void setMarketvalue(float marketvalue) {
		this.marketvalue = marketvalue;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSquarefoot() {
		return squarefoot;
	}

	public void setSquarefoot(int squarefoot) {
		this.squarefoot = squarefoot;
	}

	public String getDwellingStyle() {
		return dwellingStyle;
	}

	public void setDwellingStyle(String dwellingStyle) {
		this.dwellingStyle = dwellingStyle;
	}

	public String getRoofingMaterial() {
		return roofingMaterial;
	}

	public void setRoofingMaterial(String roofingMaterial) {
		this.roofingMaterial = roofingMaterial;
	}

	public String getGarageType() {
		return garageType;
	}

	public void setGarageType(String garageType) {
		this.garageType = garageType;
	}

	public int getNumberOfFullbaths() {
		return numberOfFullbaths;
	}

	public void setNumberOfFullbaths(int numberOfFullbaths) {
		this.numberOfFullbaths = numberOfFullbaths;
	}

	public int getNumberOfHalfbaths() {
		return numberOfHalfbaths;
	}

	public void setNumberOfHalfbaths(int numberOfHalfbaths) {
		this.numberOfHalfbaths = numberOfHalfbaths;
	}

	public String getSwimmingPool() {
		return swimmingPool;
	}

	public void setSwimmingPool(String swimmingPool) {
		this.swimmingPool = swimmingPool;
	}

}
