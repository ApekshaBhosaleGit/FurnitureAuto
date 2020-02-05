package com.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBUtils {

	Connection connection = null;

	public DBUtils() {
		connection = getDBConnection();
	}

	public Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://okmry52647dns.eastus.cloudapp.azure.com:3306/mysql?serverTimezone=UTC";
			String USER = "sdetuser1";
			String PASS = "Welcome123$";
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Map<String, String> getSupportDetails() {
		String query = "select * from <table_name> where cond1=value1";
		try {
			Map<String, String> supportDetails = new HashMap<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				supportDetails.put("email", rs.getString("email"));
			}
			return supportDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
