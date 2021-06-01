import java.util.ArrayList;

//Cyclic detection using DFS for undirected graph

public class HelloWorld{

     public static void main(String []args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        prepareGraph(adj);
        
        int v = adj.size(); //number of vertices
        boolean[] visited = new boolean[v]; //visited array
        
        System.out.println("Cycle detection started...\n");
        boolean status = false;
        
        for (int i = 0; i < v; i++) { //this is to ensure this algo works for disjointed components

            if (visited[i]) { //if current node is already visited, ignore it
                continue;
            }
            
            status = isCyclicDFSUtil(i, -1, adj, visited); //prev node set to -1, ie no prev node
            if (status) {
                break;
            }
        }
        
        if (status) {
            System.out.println("Cycle detected !!!");
        } else {
            System.out.println("Not cyclic graph");
        }
        
     }
     
     private static boolean isCyclicDFSUtil (   int curr, 
                                                int prev, 
                                                ArrayList<ArrayList<Integer>> adj, 
                                                boolean[] visited) {
         visited[curr] = true;
         for (Integer n : adj.get(curr)) {
             if (n == prev) { //if next node is prev, ignore it and move to other adjancent nodes
                 continue;
             }
             if (visited[n]) {
                 return true;
             }
             boolean status = isCyclicDFSUtil(n, curr, adj, visited);
             if (status) { //if cycle detected, we can stop further iteration and return true
                 return status;
             }
         }
         return false; //cycle not detected
     }
     
     private static void prepareGraph(ArrayList<ArrayList<Integer>> adj) {
        
        addEdge(adj, new Integer[]{1}); //0th node
        addEdge(adj, new Integer[]{0, 2}); //1st node
        addEdge(adj, new Integer[]{1}); //2nd node
        addEdge(adj, new Integer[]{4, 5}); //3rd node
        addEdge(adj, new Integer[]{3, 6}); //4th node
        addEdge(adj, new Integer[]{3, 7}); //5th node
        addEdge(adj, new Integer[]{4, 8}); //6th node
        //addEdge(adj, new Integer[]{4}); //6th node
        addEdge(adj, new Integer[]{5, 8}); //7th node
        addEdge(adj, new Integer[]{6, 7, 9}); //8th node
        //addEdge(adj, new Integer[]{7, 9}); //8th node
        addEdge(adj, new Integer[]{8}); //9th node
        
        
        System.out.println("Graph:");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Node: "+i + " => " + adj.get(i));
        }
        
        System.out.println("==================");
     }
     
     private static void addEdge(ArrayList<ArrayList<Integer>> adj, Integer[] nexts) {
         ArrayList<Integer> list = new ArrayList<>();
         for (Integer i : nexts) {
             list.add(i);
         }
         adj.add(list);
     }
}