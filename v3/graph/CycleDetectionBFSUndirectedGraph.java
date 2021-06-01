import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

//Cyclic detection using BFS for undirected graph

public class HelloWorld{

     public static void main(String []args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        prepareGraph(adj);
        
        int v = adj.size(); //number of vertices
        boolean[] visited = new boolean[v]; //visited array
        
        //add all adjacent nodes in queue in pair (node, prevNode)
        Queue<Integer[]> q = new LinkedList<>();
        
        System.out.println("Cycle detection started...\n");
        
        for (int i = 0; i < v; i++) { //this is to ensure this algo works for disjointed components

            if (visited[i]) { //if current node is already visited, ignore it
                continue;
            }
            
            q.add(new Integer[]{i, -1}); //prev node set to -1
            
            while (!q.isEmpty()) {
                Integer[] node = q.poll();
                visited[node[0]] = true;
                
                for (Integer n : adj.get(node[0])) {
                    if (node[1] == n) { //prev node is the next node, then ignore
                        continue;
                    }
                    if (visited[n]) {
                        System.out.println("Cycle detected !!!");
                        return;
                    }
                    q.add(new Integer[]{n, node[0]});
                }
                
            }
            
        }
        System.out.println("Not cyclic graph");
        
     }
     
     private static void prepareGraph(ArrayList<ArrayList<Integer>> adj) {
        
        addEdge(adj, new Integer[]{1}); //0th node
        addEdge(adj, new Integer[]{0, 2}); //1st node
        addEdge(adj, new Integer[]{1}); //2nd node
        addEdge(adj, new Integer[]{4, 5}); //3rd node
        addEdge(adj, new Integer[]{3, 6}); //4th node
        addEdge(adj, new Integer[]{3, 7}); //5th node
        //addEdge(adj, new Integer[]{4, 8}); //6th node
        addEdge(adj, new Integer[]{4}); //6th node
        addEdge(adj, new Integer[]{5, 8}); //7th node
        //addEdge(adj, new Integer[]{6, 7, 9}); //8th node
        addEdge(adj, new Integer[]{7, 9}); //8th node
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