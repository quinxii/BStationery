package org.btm.bstationeryafter.model;

public class ShippingAddress {
	
	private String ShippingAddressId;
	private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    
	
	public ShippingAddress() {
		// TODO Auto-generated constructor stub
	}

	public String getShippingAddressId() {
		return ShippingAddressId;
	}

	public void setShippingAddressId(String shippingAddressId) {
		ShippingAddressId = shippingAddressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}
