package com.plasmadonation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.plasmadonation.model.User;

public class UserUpdateDAO {

	public static String updateUser(User user) {

		/*
		 * Database Configuration And working with DB Update user
		 */

		Connection connection = null;
		PreparedStatement statement = null;
		String role = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonation", "root",
					"root");
			statement = (PreparedStatement) connection.prepareStatement("update user set firstname = ?,lastname=?,"
					+ "password = ?,streetaddress = ?,addressline2 = ?, city = ?, province = ?,"
					+ "postalcode = ?, country = ? where email = ?");
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getStreetAddress());
			statement.setString(5, user.getAddressLine2());
			statement.setString(6, user.getCity());
			statement.setString(7, user.getProvince());
			statement.setString(8, user.getPostalCode());
			statement.setString(9, user.getCountry());
			statement.setString(10, user.getEmail());
			statement.execute();
			statement = connection.prepareStatement("select role from user where email = ?");
			statement.setString(1, user.getEmail());

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				role = rs.getString("role");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return role;
	}

}
