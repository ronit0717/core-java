import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.lang.Object;

public class HelloWorld{

     public static void main(String []args) {
        ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>();
        prepareGraph(adj);
        
        int v = adj.size(); //number of vertices
        
        Integer[] dist = new Integer[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[0] = 0;
       
        //First Pass
        for (int i = 0; i < v; i++) {
            if (dist[i] == Integer.MAX_VALUE) { //if curr dist is +infinity, ignore as adjacent dist wont be improved
                continue;
            }
            for (Integer[] n : adj.get(i)) {
                if (dist[i] == Integer.MIN_VALUE) { //if curr dist is -infinity, all adjacent will be -infinity
                    dist[n[0]] = Integer.MIN_VALUE;
                } else if (dist[n[0]] > (dist[i] + n[1])) { //if distance improving, update
                    dist[n[0]] = (dist[i] + n[1]);
                }
            }
        }
        
        //v-1 iterations
        int count = 1;
        while (count < v) {
            count++;
            
            for (int i = 0; i < v; i++) {
                if (dist[i] == Integer.MAX_VALUE) { //if curr dist is +infinity, ignore as adjacent dist wont be improved
                    continue;
                }
                for (Integer[] n : adj.get(i)) {
                    if (dist[i] == Integer.MIN_VALUE) { //if curr dist is -infinity, all adjacent will be -infinity
                        dist[n[0]] = Integer.MIN_VALUE;
                    } else if (dist[n[0]] > (dist[i] + n[1])) { //if distance still improving, update to -infinity. This is negative loop
                        dist[n[0]] = Integer.MIN_VALUE;
                    }
                }
            }
        }
       
        print(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7 ,8});
        print(dist); // 0   1   -inf    -inf    -inf    5   5   8   +inf
     }
     
     private static void print(Integer[] a) {
         for (int i = 0; i < a.length; i++) {
             if (a[i] == Integer.MAX_VALUE) {
                System.out.print("+inf\t");    
             } else if (a[i] == Integer.MIN_VALUE) {
                System.out.print("-inf\t");    
             } else {
                System.out.print(a[i] + "\t");   
             }
         }
         System.out.println();
     }
     
     private static void prepareGraph(ArrayList<ArrayList<Integer[]>> adj) {
        ArrayList<Integer[]> list = null;
        //0th node
        list = new ArrayList<>();
        list.add(new Integer[]{ 1, 1 }); //node and weight
        adj.add(list);
        
        //1st node
        list = new ArrayList<>();
        list.add(new Integer[]{ 2, 1 });
        list.add(new Integer[]{ 5, 4 });
        list.add(new Integer[]{ 6, 4 });
        adj.add(list);
        
        //2nd node
        list = new ArrayList<>();
        list.add(new Integer[]{ 4, 1 });
        adj.add(list);
        
        //3rd node
        list = new ArrayList<>();
        list.add(new Integer[]{ 2, 1 });
        adj.add(list);
        
        //4th node
        list = new ArrayList<>();
        list.add(new Integer[]{ 3, -3 });
        adj.add(list);
        
        //5th node
        list = new ArrayList<>();
        list.add(new Integer[]{ 6, 5 });
        list.add(new Integer[]{ 7, 3 });
        adj.add(list);
        
        //6th node
        list = new ArrayList<>();
        list.add(new Integer[]{ 7, 4 });
        adj.add(list);
        
        //7th node
        list = new ArrayList<>();
        adj.add(list);
        
        //8th node
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