package com.karl.trustarc.airline;
import java.util.Scanner;

public class Driver {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String... args) {
		DBConnection db = new DBConnection();
		
		int choice;
		System.out.println("1.Create\n2.Retrieve\n3.Update\n4.Delete\n5.Search");
	   	System.out.print("Pick your choice: ");
    	choice = sc.nextInt();
    	switch(choice) {
    	case 1: 
    		String fname,lname,dest,orig,arrive,depart;
    		int fcode;
    		System.out.print("Firstname: ");
    		fname = sc.next();
    		System.out.print("Lastname: ");
    		lname = sc.next();
    		db.readFlights();
    		System.out.print("Flight Code: ");
    		fcode = sc.nextInt();
    		db.createReservation(lname, fname,fcode);
    		break;
    	case 2:
    		db.readReservation();
    		break;
    	case 3:
    		int res_id;
    		db.readReservation();
    		System.out.print("\nPick reservation code:");
    		res_id = sc.nextInt();
    		db.readFlights();
    		int flight_id;
    		System.out.print("Flight Code: ");
    		flight_id = sc.nextInt();
    		db.updateReservation(res_id, flight_id);
    		break;
    	case 4:
    		db.readReservation();
    		System.out.print("\nPick reservation code:");
    		res_id = sc.nextInt();
    		db.deleteReservation(res_id);
    		break;
    	case 5:
    		String key;
    		int id;
    		System.out.print("Search by:\n");
    		System.out.print("1.Firstname or Lastname:\n");
    		System.out.print("2.Flight Code:\n");
    		res_id=sc.nextInt();
    		if(res_id==1) {
    			System.out.print("Keyword: ");
    			key=sc.next();
    			db.searchName(key);
    		}else if(res_id==2) {
    			System.out.print("Flight Code: ");
    			id=sc.nextInt();
    			db.searchByFlight(id);;
    		}
    		break;
    	}
		
	}

}
