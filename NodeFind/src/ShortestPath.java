public class ShortestPath {

    public static void main(String args[]){
        Node station1 = new Node(1, null, null);
        Node station2 = new Node(1, station1, null);
        Node station3 = new Node(1, station1, station2);
        Node station4 = new Node(7, station2, station3);
        Node station5 = new Node(2, new Node(8,null,null), new Node(9,null,null));
        Node station6 = new Node(8, new Node(9,null,null), new Node(20,null,null));
        BreadthFirstSearch bfs = new BreadthFirstSearch(station1, station6);

        if(bfs.compute())
            System.out.print("Path Found!");
    }
}
