import java.lang.reflect.Array;
import java.util.ArrayList;

public class Node {

    private int value;
    //    An arraylist containing a list of Nodes that
    //    This node is directly connected to - It's child nodes.
    Node leftChild;
    Node rightChild;
    private int id;
    private int y;
    private int x;
    private int z;

    public Node(int value, Node firstChild, Node secondChild){
        this.value=value;
        this.leftChild = firstChild;
        this.rightChild = secondChild;
    }
    
    public Node(int id, int x, int y, int z) {
    	this.id=id;
    	this.x=x;
    	this.y=y;
    	this.z=z;
    }
    
    public int getId() {
		return id;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	public int getZ() {
		return z;
	}

	public int getValue() {
    	return value;
    }

    public ArrayList<Node> getChildren(){
        ArrayList<Node> childNodes = new ArrayList<>();
        if(this.leftChild != null)
        {
            childNodes.add(leftChild);
        }
        if(this.rightChild != null) {
            childNodes.add(rightChild);
        }
        return childNodes;
    }

    public boolean removeChild(Node n){
        return false;
    }

}