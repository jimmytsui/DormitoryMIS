package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	String url = "jdbc:postgresql://localhost/dormitorymis";
	//String url = "jdbc:postgresql://127.0.0.1/dormitorymis";
	Connection connection = null;

	public DbConnection() {

		// TODO Auto-generated constructor stub
		try {
			try {
				Class.forName("org.postgresql.Driver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(url, "postgres",
					"324409476");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnect() {

		return connection;
	}
}
