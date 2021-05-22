import java.util.ArrayList;
import java.lang.Math;


/*Algo:
Find topological sort of the graph
make a dist array, set initial distance for all as infinite (unreachable)
start from start index, set the distance as 0
distance of adjacent node = distance of last node + 1

*/
public class ShortestPathDAG{

     private static int index = -1;
     
     public static void main(String []args){
        
        int n = 8000;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> nList = new ArrayList<>();
            if ((3*i) <= n) {
                nList.add(3*i - 1);
            }
            if ((i + 1) <= n) {
                nList.add(i);
            }
            adj.add(nList);
        }
        
        int[] top = new int[n]; //topological sort
        boolean[] visited = new boolean[n];
        index = n - 1;
        topUtil(top, adj, 0, visited);
        
        int topIndex = 0;
        for (int i = 0; i < n; i++) {
            if (top[i] == 0) { 
                topIndex = i;  //start index
                break;
            }
        }
        
        //init
        int[] dist = new int[n]; //dist array
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int i = topIndex; i < n; i++) {
            if (i == topIndex) {
                dist[top[i]] = 0;
            }
            ArrayList<Integer> next = adj.get(i);
            for (Integer j : next) {
                dist[top[j]] = Math.min(dist[top[j]], (dist[top[i]] + 1));
            }
        }
        
        System.out.println(dist[n - 1]);
        
     }
     
     private static void print(int[] a) {
         for (int i = 0; i < a.length; i++) {
             System.out.print(a[i] + " ");
         }
         System.out.println();
     }
     
     private static void topUtil(int[] top, ArrayList<ArrayList<Integer>> adj, int curr, boolean[] visited) {
        if(visited[curr]) {
            return;
        }
        visited[curr] = true;
        for (Integer n : adj.get(curr)) {
            topUtil(top, adj, n, visited);
        }
        if (adj.get(curr).size() == 2) {
            topUtil(top, adj, adj.get(curr).get(0), visited);
            topUtil(top, adj, adj.get(curr).get(1), visited);
        } else if (adj.get(curr).size() == 1) {
            topUtil(top, adj, adj.get(curr).get(0), visited);
        }
        top[index] = curr;
        index--;
    }
}

/*
Quick Solution

class Solution{
    
    static int minStep(int n){
        //complete the function here
        int count = 0;
        while (n > 1) {
            if (n % 3 == 0) {
                n/=3;
            } else {
                n--;
            }
            count++;
        }
        return count;
    }
}

*/