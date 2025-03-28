class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] dist = new int[V];
        int large = 100000000;
        for (int i = 0; i < V; i++) {
            dist[i] = large;
        }
        dist[src] = 0;
        boolean checkNegative = false;
        for (int i = 0; i < V; i++) {
            if (i == (V - 1)) { //Last Loop
                checkNegative = true;
            }
            for (int j = 0; j < edges.length; j++) {
                int start = edges[j][0];
                int end = edges[j][1];
                int weight = edges[j][2];
                if (dist[start] == large) {
                    continue;
                }
                int newDist = dist[start] + weight;
                if (newDist < dist[end]) {
                    if (checkNegative) {
                        return new int[]{-1}; //negative cycle
                    }
                    dist[end] = newDist;
                }
            }
        }
        return dist;
    }
}