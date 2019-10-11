import java.util.ArrayList;

public class CoordinateGraph {

	public static ArrayList<Coordinates>getCoordinates(ArrayList<Coordinates> coordinates, Coordinates coords){
		ArrayList<Coordinates> mycoords = new ArrayList<Coordinates>();
		Coordinates[] arrcoords = {new Coordinates(coords.getX()+1,coords.getY()+0),
								   new Coordinates(coords.getX()+1,coords.getY()-1),
								   new Coordinates(coords.getX()+0,coords.getY()-1),
								   new Coordinates(coords.getX()-1,coords.getY()+0),
								   new Coordinates(coords.getX()-1,coords.getY()+1),
								   new Coordinates(coords.getX()+0,coords.getY()+1)};
		
		return mycoords;
	}
}
