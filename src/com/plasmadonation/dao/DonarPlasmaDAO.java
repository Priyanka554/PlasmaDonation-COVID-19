package com.plasmadonation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.plasmadonation.model.AnalyticsResponse;
import com.plasmadonation.model.DonarPlasma;

/*
 * 
 * Donar DAO Class
 */
public class DonarPlasmaDAO {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	/*
	 * Configuring Database Storing Donar User In Database
	 */

	public void dbConfiguration() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonation", "root", "root");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int addDonarPlasmaUser(DonarPlasma donarPlasma) {

		int count = 0;

		try {
			dbConfiguration();

			preparedStatement = connection
					.prepareStatement("insert into donar values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, donarPlasma.getUser().getFirstName());
			preparedStatement.setString(2, donarPlasma.getUser().getLastName());
			preparedStatement.setString(3, donarPlasma.getUser().getEmail());
			preparedStatement.setString(4, donarPlasma.getUser().getGender());
			preparedStatement.setString(5, donarPlasma.getUser().getStreetAddress());
			preparedStatement.setString(6, donarPlasma.getUser().getAddressLine2());
			preparedStatement.setString(7, donarPlasma.getUser().getCity());
			preparedStatement.setString(8, donarPlasma.getUser().getProvince());
			preparedStatement.setString(9, donarPlasma.getUser().getPostalCode());
			preparedStatement.setString(10, donarPlasma.getUser().getCountry());
			preparedStatement.setString(11, donarPlasma.getBloodGroup());
			preparedStatement.setString(12, donarPlasma.getConfirmedTest());
			preparedStatement.setString(13, donarPlasma.getCovidTest());
			preparedStatement.setString(14, donarPlasma.getCurrentlySymptoms());
			preparedStatement.setString(15, donarPlasma.getLastDateOfSymptom());
			preparedStatement.setString(16, donarPlasma.getLastDayCovidBefore14days());
			preparedStatement.setString(17, RequestPlasmaDAO.getDate());

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
	 * 
	 * Deleting donar request
	 */

	public int deleteDonarRequest(String email) {
		int count = 0;
		try {
			dbConfiguration();
			preparedStatement = connection.prepareStatement("delete from donar where email = ?");
			preparedStatement.setString(1, email);
			preparedStatement.execute();
			count++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return count;
	}

	/*
	 * Retrive Data from Database
	 */

	public List<AnalyticsResponse> getCountByDate() {

		List<AnalyticsResponse> analyticsResponses = new ArrayList<AnalyticsResponse>();
		try {
			dbConfiguration();
			preparedStatement = connection
					.prepareStatement("select count(*),date from donar  group by date order by date ASC");

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

}
