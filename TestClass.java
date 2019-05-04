package com.perscholas.homeinsurance.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestClass {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		String propFileName = "db.properties";
		
		/*InputStream inputStream; inputStream = DBConnectionUtils.class.getClassLoader()
				.getResourceAsStream("/db.properties");*/
		
		InputStream inputStream = DBConnectionUtils.class.getClassLoader().getResourceAsStream("./db.properties");
		System.out.println("inputStream::::::::::::"+inputStream);

		if (inputStream != null) {
			try {
				prop.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(prop);

	}

}
