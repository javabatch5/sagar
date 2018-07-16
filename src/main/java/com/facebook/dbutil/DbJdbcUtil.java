package com.facebook.dbutil;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class DbJdbcUtil {
	/**
	 * Connect to Database
	 * @author hany.said
	 */
	public static class ConnectionFactory {
	    public static final String URL = "jdbc:mysql://localhost:3306/sys";
	    public static final String USER = "root";
	    public static final String PASS = "vishnu";
	    /**
	     * Get a connection to database
	     * @return Connection object
	     */
	    public static java.sql.Connection getConnection()
	    {
	      try {
	          DriverManager.registerDriver(new Driver());
	          return DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root", "vishnu");
	      } catch (SQLException ex) {
	          throw new RuntimeException("Error connecting to the database", ex);
	      }
	    }
	    /**
	     * Test Connection
	     */
	    public static void main(String[] args) {
	        java.sql.Connection connection = ConnectionFactory.getConnection();
	    }
	}


}
