package com.plasmadonation.model;

public class DonarPlasma {
	
	private User user;
	private String bloodGroup;
	private String confirmedTest;
	private String currentlySymptoms;
	private String lastDayCovidBefore14days;
	private String lastDateOfSymptom;
	private String covidTest;
	
	
	public DonarPlasma() {
		super();
	}


	public DonarPlasma(User user, String bloodGroup, String confirmedTest, String currentlySymptoms,
			String lastDayCovidBefore14days, String lastDateOfSymptom, String covidTest) {
		super();
		this.user = user;
		this.bloodGroup = bloodGroup;
		this.confirmedTest = confirmedTest;
		this.currentlySymptoms = currentlySymptoms;
		this.lastDayCovidBefore14days = lastDayCovidBefore14days;
		this.lastDateOfSymptom = lastDateOfSymptom;
		this.covidTest = covidTest;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
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


	public String getCurrentlySymptoms() {
		return currentlySymptoms;
	}


	public void setCurrentlySymptoms(String currentlySymptoms) {
		this.currentlySymptoms = currentlySymptoms;
	}


	public String getLastDayCovidBefore14days() {
		return lastDayCovidBefore14days;
	}


	public void setLastDayCovidBefore14days(String lastDayCovidBefore14days) {
		this.lastDayCovidBefore14days = lastDayCovidBefore14days;
	}


	public String getLastDateOfSymptom() {
		return lastDateOfSymptom;
	}


	public void setLastDateOfSymptom(String lastDateOfSymptom) {
		this.lastDateOfSymptom = lastDateOfSymptom;
	}


	public String getCovidTest() {
		return covidTest;
	}


	public void setCovidTest(String covidTest) {
		this.covidTest = covidTest;
	}


	@Override
	public String toString() {
		return "DonarPlasmaDAO [user=" + user + ", bloodGroup=" + bloodGroup + ", confirmedTest=" + confirmedTest
				+ ", currentlySymptoms=" + currentlySymptoms + ", lastDayCovidBefore14days=" + lastDayCovidBefore14days
				+ ", lastDateOfSymptom=" + lastDateOfSymptom + ", covidTest=" + covidTest + "]";
	}
	
	
	

}
