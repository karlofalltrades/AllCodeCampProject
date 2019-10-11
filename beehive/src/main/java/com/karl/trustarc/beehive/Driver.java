package com.karl.trustarc.beehive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Driver {
	
    public static void main( String... args ){
		int radius = 10;
		int number = 2;
		int x=0, y=0;
		
		Grid graph = new Grid();
		
		ArrayList<Coordinates> offset = new ArrayList<Coordinates>();
		Map<Integer,ArrayList<Coordinates>> map = new HashMap<Integer, ArrayList<Coordinates>>();
		ArrayList<Coordinates> Coordinatestemp = new ArrayList<Coordinates>();
		ArrayList<Coordinates> integer = new ArrayList<Coordinates>();
		
		Coordinates origin = new Coordinates(x,y,1);
		offset.add(origin); // add the first cell

		  for( int N = 1; N <= radius; ++N ) {
		    for(int i=0; i<N; ++i) offset.add(new Coordinates(++x, y,number++));  // move right
		    for(int i=0; i<N-1; ++i) offset.add(new Coordinates(x, ++y,number++)); // move down right. Note N-1
		    for(int i=0; i<N; ++i) offset.add(new Coordinates(--x, ++y,number++)); // move down left
		    for(int i=0; i<N; ++i) offset.add(new Coordinates(--x, y,number++)); // move left
		    for(int i=0; i<N; ++i) offset.add(new Coordinates(x, --y,number++)); // move up left
		    for(int i=0; i<N; ++i) offset.add(new Coordinates(++x, --y,number++)); // move up right
		  }
		
		for(Coordinates temporary : offset ) {
			Coordinatestemp = getCoordinates(offset, temporary);
			for(Coordinates p : Coordinatestemp){
				integer.add(p);
			}
			map.put(temporary.getZ(), new ArrayList<Coordinates>(integer));
			integer.clear();
		}
		
	    for(Entry<Integer, ArrayList<Coordinates>> xy : map.entrySet()) {
			for(Coordinates o : xy.getValue()) {
				graph.addEdge(xy.getKey().toString(), Integer.toString(o.getZ()));
			}
		}
		System.out.print("Source: ");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int source = sc.nextInt();
		System.out.print("Destination: ");
		int destination = sc.nextInt();
		List<String> result = graph.shortestPath(Integer.toString(source),Integer.toString(destination));
		System.out.println(result);
				
	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public static ArrayList<Coordinates>getCoordinates(ArrayList<Coordinates> coordinates, Coordinates coords){
		ArrayList<Coordinates> mycoords = new ArrayList<Coordinates>();
		Coordinates[] arrcoords = {new Coordinates(coords.getX()+1,coords.getY()+0),
								   new Coordinates(coords.getX()+1,coords.getY()-1),
								   new Coordinates(coords.getX()+0,coords.getY()-1),
								   new Coordinates(coords.getX()-1,coords.getY()+0),
								   new Coordinates(coords.getX()-1,coords.getY()+1),
								   new Coordinates(coords.getX()+0,coords.getY()+1)};
		
		for(Coordinates c : coordinates) {
			Coordinates temp = c;
			
			if(	(arrcoords[0].getX() == (temp.getX()) && arrcoords[0].getY() == (temp.getY())) ||
				(arrcoords[1].getX() == (temp.getX()) && arrcoords[1].getY() == (temp.getY())) ||
				(arrcoords[2].getX() == (temp.getX()) && arrcoords[2].getY() == (temp.getY())) ||
				(arrcoords[3].getX() == (temp.getX()) && arrcoords[3].getY() == (temp.getY())) ||
				(arrcoords[4].getX() == (temp.getX()) && arrcoords[4].getY() == (temp.getY())) ||
				(arrcoords[5].getX() == (temp.getX()) && arrcoords[5].getY() == (temp.getY()))) {
				mycoords.add(temp);
			}
		}
		return mycoords;
	}
}