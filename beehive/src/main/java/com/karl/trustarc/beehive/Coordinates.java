package com.karl.trustarc.beehive;

public class Coordinates {

	private int x;
	private int y;
	private int z;
	private int cID;
	
	public Coordinates(int x, int y, int z, int cID) {
		this.x=x;
		this.y=y;
		this.z=z;
		this.cID=cID;
	}
	
	public Coordinates(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public Coordinates(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Coordinates() {}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getcID() {
		return cID;
	}

}
