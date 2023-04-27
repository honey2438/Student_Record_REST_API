package com.magic.models;

import javax.validation.constraints.NotNull;

public class Address {

	@NotNull(message = "City cannot be null")
	private String city;
	@NotNull(message = "State cannot be null")
	private String state;
	@NotNull(message = "Pincode cannot be null")
	private String pincode;

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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Address(@NotNull(message = "City cannot be null") String city,
			@NotNull(message = "State cannot be null") String state,
			@NotNull(message = "Pincode cannot be null") String pincode) {
		super();

		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

}
