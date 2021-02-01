package com.plasmadonation.model;

public class User {
	
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String password;
	private String gender;
	private String streetAddress;
	private String addressLine2;
	private String province;
	private String city;
	private String postalCode;
	private String country;
	
	
	

	public User() {
		super();
	}


	public User(String firstName, String lastName, String email, String role, String password, String gender,
			String streetAddress, String addressLine2, String province, String city, String postalCode,
			String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.password = password;
		this.gender = gender;
		this.streetAddress = streetAddress;
		this.addressLine2 = addressLine2;
		this.province = province;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}













	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getStreetAddress() {
		return streetAddress;
	}




	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}




	public String getAddressLine2() {
		return addressLine2;
	}




	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}




	public String getProvince() {
		return province;
	}




	public void setProvince(String provience) {
		this.province = provience;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getPostalCode() {
		return postalCode;
	}




	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}
	

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role
				+ ", password=" + password + ", gender=" + gender + ", streetAddress=" + streetAddress
				+ ", addressLine2=" + addressLine2 + ", province=" + province + ", city=" + city + ", postalCode="
				+ postalCode + ", country=" + country + "]";
	}



	
	
	
	


}