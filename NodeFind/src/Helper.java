import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Helper {
	
	private int v;  
    private ArrayList<Integer>[] adjList;  
    
    public Helper(int vertices){ 
        this.v = vertices; 
        initAdjList();  
    } 

    @SuppressWarnings("unchecked") 
    private void initAdjList() { 
        adjList = new ArrayList[v];
        for(int i = 0; i < v; i++){ 
            adjList[i] = new ArrayList<>(); 
        } 
    }
    
    public void addEdge(int u, int v){ adjList[u].add(v); } 
 
    public void printAllPaths(int s, int d){ 
    	HashMap<Integer, Boolean> visit = new HashMap<Integer,Boolean>();
        boolean[] isVisited = new boolean[v]; 
        ArrayList<Integer> pathList = new ArrayList<>();           
        pathList.add(s); 
        printAllPathsUtil(s, d, isVisited, pathList); 
    } 
    
    private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) { 
        isVisited[u] = true; 
          
        if (u.equals(d)){ 
            System.out.println(localPathList);
            isVisited[u]= false; 
            return ; 
        } 
        
        for (Integer i : adjList[u]){ 
            if (!isVisited[i]){
                localPathList.add(i); 
                printAllPathsUtil(i, d, isVisited, localPathList);
                //System.out.print(adjList[u]);
                localPathList.remove(i); 
            } 
        }
        
        isVisited[u] = false; 
    }

}
