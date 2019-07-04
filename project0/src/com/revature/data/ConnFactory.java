package com.revature.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {

	// singleton connection factory
	private static ConnFactory cf = new ConnFactory();

	// constructor
	private ConnFactory() {
		super();
	}

	// creates a sync'd instance of the ConnFactory if none exists and returns an
	// instance of itself
	public static synchronized ConnFactory getInstance() {
		if (cf == null) { // if no instance exists
			cf = new ConnFactory(); // create a new instance of the ConnFactory
		}
		return cf;
	}

	//attempts a connection with a sql database
	public Connection getConnection() {

		Connection conn = null;					//sets the connection to null
		Properties prop = new Properties();		//creates a new properties field

		try {//attempts the connection and throws an appropriate exception if failure occurs
			
			prop.load(new FileReader("database.properties"));		//reads in the sql settings from the database.properties file included
			Class.forName(prop.getProperty("driver"));				//pulls the value for the driver
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"),prop.getProperty("password"));		//sets the values for url, username and password for the sql server
			
		} catch (FileNotFoundException e) {	//file was not found
			e.printStackTrace();
		} catch (IOException e) {			//IOException
			e.printStackTrace();
		} catch (SQLException e) {			//SQLException
			e.printStackTrace();	
		} catch (ClassNotFoundException e) {	//ClassNotFound
			e.printStackTrace();
		}

		return conn;

	}
}
