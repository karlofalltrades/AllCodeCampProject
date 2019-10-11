package com.karl.trustarc.airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	
	protected static final String JDBC_DRIVER="org.postgresql.Driver";
	protected static final String JDBC_URL="jdbc:postgresql://localhost:5432/airline";
	protected static final String USER="postgres";
	protected static final String PASS="1234";
	
	public DBHelper() {}
	
	Connection c = null;
    Statement stmt = null;
	public void addPassenger(String fname, String lname) {
		try {
			Class.forName(JDBC_DRIVER);
		    c = DriverManager.getConnection(JDBC_URL, USER, PASS);
		    c.setAutoCommit(false);
		    stmt = c.createStatement();
		    String sql = "INSERT INTO passenger (fname,lname) VALUES ('"+fname+"', '"+lname+"');";
		 	stmt.executeUpdate(sql);
		    stmt.close();
		    c.commit();
		    c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void makeReservation(int flight_id, int passenger_id) {
		try {
			Class.forName(JDBC_DRIVER);
		    c = DriverManager.getConnection(JDBC_URL, USER, PASS);
		    c.setAutoCommit(false);
		    stmt = c.createStatement();
		    String sql = "INSERT INTO reservation (flight_id) VALUES ('"+flight_id+"');";
		 	stmt.executeUpdate(sql);
		    stmt.close();
		    c.commit();
		    c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateReservation(int res_id, int flight_id) {
		try {
			Class.forName(JDBC_DRIVER);
		    c = DriverManager.getConnection(JDBC_URL, USER, PASS);
		    c.setAutoCommit(false);
		    stmt = c.createStatement();
		    String sql = "update reservation set flight_id = '"+flight_id+"' where res_id = '"+res_id+"'";
		 	stmt.executeUpdate(sql);
		    stmt.close();
		    c.commit();
		    c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteReservation(int res_id) {
		try {
			Class.forName(JDBC_DRIVER);
		    c = DriverManager.getConnection(JDBC_URL, USER, PASS);
		    c.setAutoCommit(false);
		    stmt = c.createStatement();
		    String sql = "delete from reservation where res_id = '"+res_id+"'";
		 	stmt.executeUpdate(sql);
		    stmt.close();
		    c.commit();
		    c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
