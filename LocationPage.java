package com.perscholas.homeinsurance;

/* @Author Neerja Balasubramanian
 */
public class LocationPage {

	private int locationId;
	private int userId;
	private String residenceType;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String zipCode;
	private String residenceUse;

	public LocationPage() {
	}

	public LocationPage(int locationId, int userId, String residenceType, String addressline1, String addressline2,
			String city, String state, String zipCode, String residenceUse) {
		super();
		this.locationId = locationId;
		this.userId = userId;
		this.residenceType = residenceType;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.residenceUse = residenceUse;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getResidenceUse() {
		return residenceUse;
	}

	public void setResidenceUse(String residenceUse) {
		this.residenceUse = residenceUse;
	}

}
