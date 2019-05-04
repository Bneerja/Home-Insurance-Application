package com.perscholas.homeinsurance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtils {

	public static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
		Properties prop = getProperties();
		Class.forName(prop.getProperty("driver"));
		final Connection connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
		return connection;
	}
	
	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String propFileName = "db.properties";
		InputStream inputStream = DBConnectionUtils.class.getClassLoader().getResourceAsStream("properties/db.properties");
		System.out.println("inputStrea,m::::::::::::"+inputStream);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		return prop;
	}
	
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
