package com.plasmadonation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * User Delete DAO
 */
public class UserDeleteDAO {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	/*
	 * Configuring Database Deleting user
	 */

	public void dbConfiguration() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonation", "root", "root");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int deleteUser(String email) {
		int count = 0;
		try {
			dbConfiguration();
			preparedStatement = connection.prepareStatement("delete from user where email = ?");
			preparedStatement.setString(1, email);
			preparedStatement.execute();
			preparedStatement = connection.prepareStatement("delete from donar where email = ?");
			preparedStatement.setString(1, email);
			preparedStatement.execute();
			preparedStatement = connection.prepareStatement("delete from request where email = ?");
			preparedStatement.setString(1, email);
			preparedStatement.execute();
			count++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return count;
	}

}
