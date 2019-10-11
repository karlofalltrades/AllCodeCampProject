package com.karl.trustarc.airline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	@Id @GeneratedValue
	@Column(name="flight_id")
	private int flight_id;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="depart_time")
	private String depart_time;
	
	@Column(name="arrive_time")
	private String arrive_time;
	
	public Flight() {}
	
	public Flight(int flight_id, String origin, String destination, String depart_time, String arrive_time) {
		this.flight_id=flight_id;
		this.origin=origin;
		this.destination=destination;
		this.depart_time=depart_time;
		this.arrive_time=arrive_time;
	}
	
	public int getFlightID() {
		return flight_id;
	}
	
	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String getDepart_time() {
		return depart_time;
	}

	public String getArrive_time() {
		return arrive_time;
	}
	
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setDepart_time(String depart_time) {
		this.depart_time = depart_time;
	}

	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}
}
