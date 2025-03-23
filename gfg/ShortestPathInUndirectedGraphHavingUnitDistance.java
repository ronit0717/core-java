//Problem Link: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int[] dist = initDistArr(adj);
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{src, 0});
        dist[src] = 0;
        while(!q.isEmpty()) {
            Integer[] node = q.poll();
            int nodeIndex = node[0];
            int currDist = node[1];
            int nextDist = currDist + 1;
            for (Integer next : adj.get(nodeIndex)) {
                if (dist[next] == -1 || dist[next] > nextDist) {
                    q.add(new Integer[]{next, nextDist});
                    dist[next] = nextDist;
                }
            }
        }
        return dist;
    }
    
    private int[] initDistArr(ArrayList<ArrayList<Integer>> adj) {
        int[] dist = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            dist[i] = -1;
        }
        return dist;
    }
}