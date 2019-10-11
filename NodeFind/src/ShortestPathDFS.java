import java.util.*;
public class ShortestPathDFS {
    
    public static void main(String[] args) {
    	
        Map<Integer, LinkedList<Edge>> g = new HashMap<>();
        Edge.addEdge(g, 1, 2);
        Edge.addEdge(g, 1, 3);
        Edge.addEdge(g, 1, 4);
        Edge.addEdge(g, 1, 5);
        Edge.addEdge(g, 1, 6);
        Edge.addEdge(g, 1, 7);
        Edge.addEdge(g, 2, 1);
        Edge.addEdge(g, 2, 7);
        Edge.addEdge(g, 2, 8);
        Edge.addEdge(g, 2, 9);
        Edge.addEdge(g, 2, 10);
        Edge.addEdge(g, 2, 3);
        Edge.addEdge(g, 3, 1);
        Edge.addEdge(g, 3, 2);
        Edge.addEdge(g, 3, 4);
        Edge.addEdge(g, 3, 10);
        Edge.addEdge(g, 3, 11);
        Edge.addEdge(g, 3, 12);
        Edge.addEdge(g, 4, 1);
        Edge.addEdge(g, 4, 3);
        Edge.addEdge(g, 4, 5);
        Edge.addEdge(g, 4, 12);
        Edge.addEdge(g, 4, 13);
        Edge.addEdge(g, 4, 14);
        Edge.addEdge(g, 5, 1);
        Edge.addEdge(g, 5, 4);
        Edge.addEdge(g, 5, 6);
        Edge.addEdge(g, 5, 14);
        Edge.addEdge(g, 5, 15);
        Edge.addEdge(g, 5, 16);
        Edge.addEdge(g, 6, 1);
        Edge.addEdge(g, 6, 5);
        Edge.addEdge(g, 6, 7);
        Edge.addEdge(g, 6, 16);
        Edge.addEdge(g, 6, 17);
        Edge.addEdge(g, 6, 18);
        Edge.addEdge(g, 7, 1);
        Edge.addEdge(g, 7, 2);
        Edge.addEdge(g, 7, 6);
        Edge.addEdge(g, 7, 8);
        Edge.addEdge(g, 7, 18);
        Edge.addEdge(g, 7, 19);

        int source, dest;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Source: ");
        source=sc.nextInt();
        System.out.print("Destination: ");
        dest=sc.nextInt();
        
        Edge.printShortestDistance(g, source, dest, g.size());
    }
}