package com.plasmadonation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.plasmadonation.model.AnalyticsResponse;
import com.plasmadonation.model.RequestPlasma;

/*
 * 
 * Request plasma DAO
 */
public class RequestPlasmaDAO {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	/*
	 * Configuring Database Stroring Donar User In Database
	 */

	public void dbConfiguration() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonation", "root", "root");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int addRequestPlasmaUser(RequestPlasma requestPlasma) {

		int count = 0;

		try {
			dbConfiguration();
			preparedStatement = connection
					.prepareStatement("insert into request values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, requestPlasma.getUser().getFirstName());
			preparedStatement.setString(2, requestPlasma.getUser().getLastName());
			preparedStatement.setString(3, requestPlasma.getUser().getEmail());
			preparedStatement.setString(4, requestPlasma.getUser().getGender());
			preparedStatement.setString(5, requestPlasma.getUser().getStreetAddress());
			preparedStatement.setString(6, requestPlasma.getUser().getAddressLine2());
			preparedStatement.setString(7, requestPlasma.getUser().getCity());
			preparedStatement.setString(8, requestPlasma.getUser().getProvince());
			preparedStatement.setString(9, requestPlasma.getUser().getPostalCode());
			preparedStatement.setString(10, requestPlasma.getUser().getCountry());
			preparedStatement.setString(11, requestPlasma.getBloodGroup());
			preparedStatement.setString(12, requestPlasma.getConfirmedTest());
			preparedStatement.setString(13, requestPlasma.getSymptomsPresent());
			preparedStatement.setString(14, requestPlasma.getDateOfFirstSymptom());
			preparedStatement.setString(15, requestPlasma.getSymptoms());
			preparedStatement.setString(16, getDate());

			preparedStatement.execute();
			count++;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return count;

	}

	/*
	 * Delete Request Plasma Request
	 */

	public int deleteRequestUser(String email) {
		int count = 0;
		try {
			dbConfiguration();
			preparedStatement = connection.prepareStatement("delete from request where email = ?");
			preparedStatement.setString(1, email);
			preparedStatement.execute();
			count++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return count;
	}

	public List<AnalyticsResponse> getCountByDate() {

		List<AnalyticsResponse> analyticsResponses = new ArrayList<AnalyticsResponse>();
		try {
			dbConfiguration();
			preparedStatement = connection.prepareStatement("select count(*),date from request group by date");

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				AnalyticsResponse analyticsResponse = new AnalyticsResponse();
				analyticsResponse.setCount(Integer.parseInt(rs.getString("count(*)")));
				analyticsResponse.setDate(rs.getString("date"));

				analyticsResponses.add(analyticsResponse);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return analyticsResponses;

	}

	public static String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime date = LocalDateTime.now();

		return dtf.format(date);

	}

}
