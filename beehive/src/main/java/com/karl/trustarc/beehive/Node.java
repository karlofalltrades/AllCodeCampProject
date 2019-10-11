package com.karl.trustarc.beehive;
import java.util.ArrayList;
import java.util.List;

public class Node {
	  String number;
	  List<Node> neighbors = new ArrayList<Node>();

	  public Node(String number) {
	    this.number = number;
	  }

	  public String getnumber() {
	    return this.number;
	  }

	  public void addNeighbor(Node neighbor) {
	    neighbors.add(neighbor);
	  }

	  public List<Node> getNeighbors() {
	    return neighbors;
	  }

	  public String toint() {
	    return this.number;
	  }

}
