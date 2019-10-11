package com.karl.trustarc.airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App {
	
	private static DBHelper db = new DBHelper();
	protected static List<Flight> flight = new ArrayList<>();
	protected static List<Reservation> reserve = new ArrayList<>();
	static ResultSet rs = null;
	
//	public static void main(String args[]) {
//		
//		int pid=2;
//		int choice;
//		java.util.Scanner sc = new java.util.Scanner(System.in);
//		getFlights();
//		retrieveReservation();
////		do {
//		   	System.out.println("1.Create\n2.Retrieve\n3.Update\n4.Delete\n5.Search");
//		   	System.out.print("Pick your choice: ");
//	    	choice = sc.nextInt();
//	    	switch(choice) {
//	    		case 1:
//	    			String fname;
//	    			String lname;
//	    			System.out.print("Firstname: ");
//	    			fname = sc.next();
//	    			System.out.print("Lastname: ");
//	    			lname = sc.next();
//				for(int i = 0; i<flight.size();i++) {
//					System.out.print(i+". Flight Number: "+flight.get(i).getFlightID()+" Origin: "+flight.get(i).getOrigin()+" Destination: "+flight.get(i).getDestination()+" Departure Time: "+flight.get(i).getDepart_time()+" Arrival Time: "+flight.get(i).getArrive_time()+"\n");
//				}
//				System.out.print("Choose a flight schedule: \n");
//				int select =  sc.nextInt();
//	    		db.addPassenger(fname,lname);
//	    		db.makeReservation(flight.get(select).getFlightID(), pid);
//	    		pid++;
//	    		System.out.print("Reservation Created.");
//	    		break;
//	    		case 2:
//					for(int i = 0; i<reserve.size();i++) {
//						System.out.print("Firstname: "+reserve.get(i).getFname()+" Lastname: "+reserve.get(i).getLname()+" Flight Number: "+reserve.get(i).getFlight_id()+"\nOrigin: "+reserve.get(i).getOrigin()+" Destination: "+reserve.get(i).getDestination()+"\nDeparture Time: "+reserve.get(i).getDepart_time()+" Arrival Time: "+reserve.get(i).getArrive_time()+"\n\n");
//					}
//				break;
//	    		case 3:
//	    			for(int i = 0; i<reserve.size();i++) {
//						System.out.print("Firstname: "+reserve.get(i).getFname()+" Lastname: "+reserve.get(i).getLname()+" Flight Number: "+reserve.get(i).getFlight_id()+"\nOrigin: "+reserve.get(i).getOrigin()+" Destination: "+reserve.get(i).getDestination()+"\nDeparture Time: "+reserve.get(i).getDepart_time()+" Arrival Time: "+reserve.get(i).getArrive_time()+"\n\n");
//					}
//	    			System.out.print("Choose reservation to update: ");
//	    			int chosen = sc.nextInt();
//					for(int i = 0; i<flight.size();i++) {
//						System.out.print(i+". Flight Number: "+flight.get(i).getFlightID()+" Origin: "+flight.get(i).getOrigin()+" Destination: "+flight.get(i).getDestination()+" Departure Time: "+flight.get(i).getDepart_time()+" Arrival Time: "+flight.get(i).getArrive_time()+"\n");
//					}
//					System.out.print("Select new flight: ");
//	    			int selected = sc.nextInt();
//	    			db.updateReservation(chosen, selected);
//	    			System.out.print("Successfully updated reservation.");
//	    		break;
//	    		case 4:
//	    			for(int i = 0; i<reserve.size();i++) {
//						System.out.print("Firstname: "+reserve.get(i).getFname()+" Lastname: "+reserve.get(i).getLname()+" Flight Number: "+reserve.get(i).getFlight_id()+"\nOrigin: "+reserve.get(i).getOrigin()+" Destination: "+reserve.get(i).getDestination()+"\nDeparture Time: "+reserve.get(i).getDepart_time()+" Arrival Time: "+reserve.get(i).getArrive_time()+"\n\n");
//					}
//	    			System.out.print("Choose reservation to delete: ");
//	    			int delete = sc.nextInt();
//	    			db.deleteReservation(delete);
//	    			System.out.print("Successfully updated reservation.");
//	    		break;
//	    		case 5:
//	    			try {
//	    				String keyword="";
//	    				int k=0;
//		    			sc = new java.util.Scanner(System.in);
//		    			System.out.print("Search reservation by:");
//		    			System.out.print("\n1.Lastname");
//		    			System.out.print("\n2.Firstname");
//		    			System.out.print("\n3.Flight number");
//		    			int c1= sc.nextInt();
//		    			if(c1==1||c1==2) {
//			    			sc = new java.util.Scanner(System.in);
//			    			System.out.print("\nKeyword: ");
//			    			keyword = sc.nextLine();
//		    			}else if(c1==3) {
//			    			sc = new java.util.Scanner(System.in);
//			    			System.out.print("\nKeyword: ");
//			    			k = sc.nextInt();
//		    			}
//	    				Connection conn = null;
//	    			    Statement stmt = null;
//	    				Class.forName(db.JDBC_DRIVER);
//	    			    conn = DriverManager.getConnection(db.JDBC_URL, db.USER, db.PASS);
//	    			    conn.setAutoCommit(false);
//	    			    stmt = conn.createStatement();
//	    			    if(c1==1||c1==2) {
//	    			    	rs = stmt.executeQuery( "SELECT DISTINCT p.fname, p.lname, f.flight_id, f.origin, f.destination, f.depart_time, f.arrive_time FROM flight f, passenger p, reservation r where p.passenger_id = r.passenger_id AND f.flight_id = r.flight_id AND p.fname = '"+keyword+"' or p.lname = '"+keyword+"';");
//	    			    }else if(c1==3) {
//	    			    	rs = stmt.executeQuery( "SELECT DISTINCT p.fname, p.lname, f.flight_id, f.origin, f.destination, f.depart_time, f.arrive_time FROM flight f, passenger p, reservation r where p.passenger_id = r.passenger_id AND f.flight_id = r.flight_id AND f.flight_id = '"+k+"';");
//	    			    }
//	    				while(rs.next()) {
//	    					String lastname = rs.getString("lname");
//	    					String firstname = rs.getString("fname");
//	    					int fcode = rs.getInt("flight_id");
//	    					String orig = rs.getString("origin");
//	    					String dest = rs.getString("destination");
//	    					String dept_time =rs.getString("depart_time");
//	    					String arr_time = rs.getString("arrive_time");
//	    					System.out.print("Lastname: "+lastname+" Firstname: "+firstname+" flight number: "+fcode+"\nOrigin: "+orig+" Destination: "+dest+"\nDeparture Time: "+dept_time+"Arrival Time: "+arr_time);
//	    				}
//	    			    stmt.close();
//	    			    conn.commit();
//	    			    conn.close();
//	    			} catch (ClassNotFoundException e) {
//	    				// TODO Auto-generated catch block
//	    				e.printStackTrace();
//	    			} catch (SQLException e) {
//	    				// TODO Auto-generated catch block
//	    				e.printStackTrace();
//	    			}
//	    	}
//   }
//	
//	public static void retrieveReservation() {
//		try {
//			Connection c = null;
//		    Statement stmt = null;
//			Class.forName(db.JDBC_DRIVER);
//		    c = DriverManager.getConnection(db.JDBC_URL, db.USER, db.PASS);
//		    c.setAutoCommit(false);
//		    stmt = c.createStatement();
//		    rs = stmt.executeQuery( "SELECT DISTINCT r.res_id, p.passenger_id, p.fname, p.lname, f.flight_id, f.origin, f.destination, f.depart_time, f.arrive_time FROM flight f, passenger p, reservation r where p.passenger_id = r.passenger_id AND f.flight_id = r.flight_id;" );
//			while(rs.next()) {
//				reserve.add(new Reservation(
//						rs.getInt("res_id"),
//						rs.getInt("passenger_id"),
//						rs.getString("fname"),
//						rs.getString("lname"),
//						rs.getInt("flight_id"),
//						rs.getString("origin"),
//						rs.getString("destination"),
//						rs.getString("depart_time"),
//						rs.getString("arrive_time")
//						));
//			}
//		    stmt.close();
//		    c.commit();
//		    c.close();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public static void getFlights() {
//		try {
//			Connection c = null;
//		    Statement stmt = null;
//			Class.forName(db.JDBC_DRIVER);
//		    c = DriverManager.getConnection(db.JDBC_URL, db.USER, db.PASS);
//		    c.setAutoCommit(false);
//		    stmt = c.createStatement();
//		    rs = stmt.executeQuery( "SELECT * FROM flight;" );
//			while(rs.next()) {
//				flight.add(new Flight(
//						rs.getInt("flight_id"),
//						rs.getString("origin"),
//						rs.getString("destination"),
//						rs.getString("depart_time"),
//						rs.getString("arrive_time")
//						));
//			}
//		    stmt.close();
//		    c.commit();
//		    c.close();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
