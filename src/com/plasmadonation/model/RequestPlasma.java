package com.plasmadonation.model;

public class RequestPlasma {
	

	private String bloodGroup;
	private String confirmedTest;
	private String symptomsPresent;
	private String dateOfFirstSymptom;
	private String symptoms;
	private User user;
	
	
	public RequestPlasma() {
		super();
	}


	public RequestPlasma(String bloodGroup, String confirmedTest, String symptomsPresent, String dateOfFirstSymptom,
			String symptoms, User user) {
		super();
		this.bloodGroup = bloodGroup;
		this.confirmedTest = confirmedTest;
		this.symptomsPresent = symptomsPresent;
		this.dateOfFirstSymptom = dateOfFirstSymptom;
		this.symptoms = symptoms;
		this.user = user;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getConfirmedTest() {
		return confirmedTest;
	}


	public void setConfirmedTest(String confirmedTest) {
		this.confirmedTest = confirmedTest;
	}


	public String getSymptomsPresent() {
		return symptomsPresent;
	}


	public void setSymptomsPresent(String symptomsPresent) {
		this.symptomsPresent = symptomsPresent;
	}


	public String getDateOfFirstSymptom() {
		return dateOfFirstSymptom;
	}


	public void setDateOfFirstSymptom(String dateOfFirstSymptom) {
		this.dateOfFirstSymptom = dateOfFirstSymptom;
	}


	public String getSymptoms() {
		return symptoms;
	}


	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "RequestPlasma [bloodGroup=" + bloodGroup + ", confirmedTest=" + confirmedTest + ", symptomsPresent="
				+ symptomsPresent + ", dateOfFirstSymptom=" + dateOfFirstSymptom + ", symptoms=" + symptoms + ", user="
				+ user + "]";
	}


	
	

}
