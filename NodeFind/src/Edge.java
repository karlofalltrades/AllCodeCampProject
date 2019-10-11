import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Edge {
	
        int endVertex;
        int weight;

    public Edge(int b, int c){
        this.endVertex= b;
        this.weight= c;
    }
    
    public Edge() {}

    protected static void printShortestDistance(Map<Integer, LinkedList<Edge>> g, int source, int dest, int size) {

        int[] dist = new int[size];
        boolean[] visited = new boolean[size];
        int[] previous = new int[size];

        Queue<Integer> queue= new LinkedList<>();
        Arrays.fill(previous, -1);
        Arrays.fill(dist, -1);
        Arrays.fill(visited, false);

        visited[source] = true;
        dist[source]= 0;

        boolean routeFound = false;
        queue.add(source);
        while(!queue.isEmpty()){
            Integer vertex = queue.poll();

            for(Edge e: g.get(vertex)){
                if(!visited[e.endVertex]){

                    dist[e.endVertex] = dist[vertex]+1;
                    previous[e.endVertex] = vertex;

                    visited[e.endVertex] = 
                    		true;
                    queue.add(e.endVertex);

                    if(e.endVertex == dest){
                        routeFound=true;
                        break;
                    }

                }
            }
        }

        if(routeFound) {
            System.out.print("Path is: ");
            int i = dest;
            LinkedList<Integer>path = new LinkedList<>();
            path.addLast(dest);
            //previous[i] will be 0 for source node
            while (previous[i] != -1) {
                //System.out.print(i + " ");
                i = previous[i];
                path.add(i);
            }
            Collections.reverse(path);
            System.out.print(path + " ");
        }
    }

    //Since its undirected, we need to have 2 edges, src to dest n dest to src
    protected static void addEdge(Map<Integer, LinkedList<Edge>> g, int src, int dest) {

        LinkedList<Edge> val;
        if(g.containsKey(src)){
            val = g.get(src);
        }
        else {
            val = new LinkedList<>();
        }
        val.add(new Edge(dest, 0));
        g.put(src, val);

        LinkedList<Edge> val2;
        if(g.containsKey(dest)){
            val2 = g.get(dest);
        }
        else {
            val2 = new LinkedList<>();
        }
        val2.add(new Edge(src, 0));
        g.put(dest, val2);

    }
}
