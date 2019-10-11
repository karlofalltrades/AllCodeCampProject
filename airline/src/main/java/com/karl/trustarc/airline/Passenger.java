package com.karl.trustarc.airline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	@Id @GeneratedValue
	@Column(name="passenger_id")
	private int passenger_id;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="fname")
	private String fname;
	
	public Passenger() {}
	
	public Passenger(int passenger_id, String lname, String fname) {
		this.passenger_id=passenger_id;
		this.fname=fname;
		this.lname=lname;
	}
	
	public int getID() {
		return passenger_id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
