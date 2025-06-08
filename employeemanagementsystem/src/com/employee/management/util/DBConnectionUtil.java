package com.employee.management.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {


	    private static final String URL = "jdbc:mysql://localhost:3306/demohib"; // Change `yourdb`
	    private static final String USER = "root"; // Change if needed
	    private static final String PASSWORD = "password"; // Change if needed

	    static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure the JDBC driver is loaded
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}


