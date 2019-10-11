import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class BFS {
	
	public static boolean shortPath(ArrayList<Integer> adjacent[],int source,int destination,int vertices, int predecessor[],int distance[]) {
		LinkedList<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[vertices];
		
		for (int i = 0; i < vertices; i++) { 
	        visited[i] = false; 
	        distance[i] = Integer.MAX_VALUE; 
	        predecessor[i] = -1; 
	    } 
		visited[source]=true;
		distance[source]=0;
		queue.add(source);
		while(!queue.isEmpty()) {
			int u = queue.getFirst();
			queue.removeFirst();
			for(int i =0; i<adjacent[u].size();i++) {
				if(visited[adjacent[u].get(i)]==false) {
					visited[adjacent[u].get(i)] = true; 
	                distance[adjacent[u].get(i)] = distance[u] + 1; 
	                predecessor[adjacent[u].get(i)] = u;
	                queue.addLast(adjacent[u].get(i));
	                if(adjacent[u].get(i)==destination) {
	                	return true;
	                }
				}
			}
		}
		return false;		
	}
	
	public static void printShortDistance(ArrayList<Integer> adjacent[], int source,int destination, int vertex) {
		int predecessor[] = new int[vertex];
		int distance[] = new int[vertex];
		if(shortPath(adjacent, source, destination, vertex, predecessor, distance) == false) {
			System.out.print("Given source and destination are not connected");
			return;
		}
		LinkedList<Integer> path = new LinkedList<>();
		int crawl = destination;
		path.addLast(crawl);
		while(predecessor[crawl]!=-1) {
			path.addLast(predecessor[crawl]);
			crawl=predecessor[crawl];
		}
		System.out.print("\nPath is:\n"); 
	    for (int i = path.size() - 1; i >= 0; i--) 
	        System.out.print(path.get(i)); 
	} 
	
	public static void addEdge(ArrayList<Integer> adjacent[], int source, int destination) {
		adjacent[source].add(destination);
		adjacent[destination].add(source);
	}
	
	public static void main(String... args) {
		int v = 100;
		
		ArrayList<Integer> adjacent[] = new ArrayList[100];
		
		BFS.addEdge(adjacent, 1, 2);
		BFS.addEdge(adjacent, 1, 3);
		BFS.addEdge(adjacent, 1, 4);
		BFS.addEdge(adjacent, 1, 5);
		BFS.addEdge(adjacent, 1, 6);
		BFS.addEdge(adjacent, 1, 7);
		BFS.addEdge(adjacent, 2, 8);
		BFS.addEdge(adjacent, 7, 8);
		BFS.addEdge(adjacent, 2, 9);
		BFS.addEdge(adjacent, 2, 10);
		BFS.addEdge(adjacent, 3, 10);
		BFS.addEdge(adjacent, 3, 11);
		int source =1, dest = 10; 
		BFS.printShortDistance(adjacent, source, dest, v); 
	}

}
