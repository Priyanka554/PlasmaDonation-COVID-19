
package com.plasmadonation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.plasmadonation.model.User;

public class UserRegisterDAO {

	public static int registerUser(User user) {

		/*
		 * Database Configuration And working with DB register user into db
		 */

		Connection connection = null;
		PreparedStatement statement = null;
		int count = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonation", "root",
					"root");
			statement = (PreparedStatement) connection
					.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getGender());
			statement.setString(6, user.getStreetAddress());
			statement.setString(7, user.getAddressLine2());
			statement.setString(8, user.getCity());
			statement.setString(9, user.getProvince());
			statement.setString(10, user.getPostalCode());
			statement.setString(11, user.getCountry());
			statement.setString(12, user.getRole());
			statement.execute();
			count++;
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

		return count;
	}
}
