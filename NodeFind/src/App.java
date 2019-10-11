
public class App { 

    public static void main(String[] args){ 

        Helper g = new Helper(100); 
        g.addEdge(1,2); 
        g.addEdge(1,3); 
        g.addEdge(1,4); 
        g.addEdge(1,5); 
        g.addEdge(1,6); 
        g.addEdge(1,7); 
        g.addEdge(7,8); 
        g.addEdge(2,8); 
        g.addEdge(2,9); 
        g.addEdge(2,7);
        g.addEdge(2,10);
        g.addEdge(2,1);
        g.addEdge(2,3);
        g.addEdge(3,1);
        g.addEdge(3,2);
        g.addEdge(3,10);
        g.addEdge(3,11);
        g.addEdge(3,12);
        g.addEdge(3,4);
        g.addEdge(4,3);
        g.addEdge(4,12);
        g.addEdge(4,13);
        g.addEdge(4,14);
        g.addEdge(4,5);
        g.addEdge(4,1);

        int source = 1; 
        
        int destination = 8; 
      
        System.out.println("Following are all different paths from "+source+" to "+destination); 
        g.printAllPaths(source, destination); 
  
    } 
} 