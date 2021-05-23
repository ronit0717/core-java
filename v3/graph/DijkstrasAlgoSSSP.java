import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HelloWorld{

     public static void main(String []args) {
        ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>();
        prepareGraph(adj);
        
        int v = adj.size(); //number of vertices
        
        Integer[] dist = new Integer[v];
        Arrays.fill(dist, -1); //dist array init
        
        PriorityQueue<Integer[]> pq = new PriorityQueue<>( (a, b) -> (a[1] - b[1]) );
        
        dist[0] = 0;
        pq.add(new Integer[]{0, 0});
        while (!pq.isEmpty()) {
            Integer[] curr = pq.poll();
            
            if (dist[curr[0]] != -1 && dist[curr[0]] < curr[1]) {
                continue;
            }
            
            ArrayList<Integer[]> next = adj.get(curr[0]);
            for (Integer[] n : next) {
                int newDist = dist[curr[0]] + n[1];
                if ( (dist[n[0]] == -1) || ( dist[n[0]] > newDist) ) {
                    dist[n[0]] = newDist;
                }
                pq.add(new Integer[]{ n[0], newDist });
            }
            
        }
        
        System.out.print("Result: ");
        print(dist);
     }
     
     private static void print(Integer[] a) {
         for (int i = 0; i < a.length; i++) {
             System.out.print(a[i] + " ");
         }
         System.out.println();
     }
     
     private static void prepareGraph(ArrayList<ArrayList<Integer[]>> adj) {
        ArrayList<Integer[]> list = null;
        //0th node
        list = new ArrayList<>();
        list.add(new Integer[]{ 1, 4 }); //node and weight
        list.add(new Integer[]{ 2, 1 });
        adj.add(list);
        
        //1st node
        list = new ArrayList<>();
        list.add(new Integer[]{ 3, 1 });
        adj.add(list);
        
        //2nd node
        list = new ArrayList<>();
        list.add(new Integer[]{ 1, 2 });
        list.add(new Integer[]{ 3, 5 });
        adj.add(list);
        
        //3rd node
        list = new ArrayList<>();
        list.add(new Integer[]{ 4, 3 });
        adj.add(list);
        
        //4th node
        list = new ArrayList<>();
        adj.add(list);
        
        System.out.println("Graph:");
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer[]> n = adj.get(i);
            System.out.println("------");
            System.out.println("Node: " + i);
            for (int j = 0; j < n.size(); j++) {
                print(n.get(j));
            }
        }
        
        System.out.println("==================");
     }
}