package com.plasmadonation.modifications;

public class DateModification {

	/*
	 * Formatting date like 11-10-2020 to Nov 11
	 */
	public static String formattingDate(String date) {

		String[] stringArray = date.split("/");

		switch (stringArray[1]) {
		case "01": {
			return concateDate("Jan", stringArray[2]);
		}
		case "02": {
			return concateDate("Feb", stringArray[2]);
		}
		case "03": {
			return concateDate("Mar", stringArray[2]);
		}
		case "04": {
			return concateDate("Apr", stringArray[2]);
		}
		case "05": {
			return concateDate("May", stringArray[2]);
		}
		case "06": {
			return concateDate("Jun", stringArray[2]);
		}
		case "07": {
			return concateDate("Jul", stringArray[2]);
		}
		case "08": {
			return concateDate("Aug", stringArray[2]);
		}
		case "09": {
			return concateDate("Sep", stringArray[2]);
		}
		case "10": {
			return concateDate("Oct", stringArray[2]);
		}
		case "11": {
			return concateDate("Nov", stringArray[2]);
		}
		case "12": {
			return concateDate("Dec", stringArray[2]);
		}

		default:
			break;
		}

		return null;
	}

	private static String concateDate(String dateString, String date) {

		String modifiedDate = dateString + " " + date;
		return modifiedDate;
	}

}
