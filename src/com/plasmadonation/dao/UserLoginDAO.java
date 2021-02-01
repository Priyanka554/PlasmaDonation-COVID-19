package com.plasmadonation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.plasmadonation.model.User;

/*
 * User Login DAO
 */
public class UserLoginDAO {

	/*
	 * DB Configuration Login logic
	 */

	public User doLogin(String email, String password) {

		Connection connection = null;
		PreparedStatement statement = null;

		User user = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonation", "root", "root");
			statement = connection.prepareStatement("Select * from user where email=? and password =?");
			statement.setString(1, email);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setCity(rs.getString("city"));
				user.setAddressLine2(rs.getString("addressline2"));
				user.setCountry(rs.getString("country"));
				user.setPostalCode(rs.getString("postalcode"));
				user.setProvince(rs.getString("province"));
				user.setStreetAddress(rs.getString("streetaddress"));
				user.setRole(rs.getString("role"));

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if (user.getEmail() != null) {
			return user;
		}
		user = null;
		return user;

	}

}
