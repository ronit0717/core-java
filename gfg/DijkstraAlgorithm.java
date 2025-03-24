//Problem Link: https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        ArrayList<Integer> dist = buildDist(adj.size());
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        dist.set(src, 0);
        pq.add(new Integer[]{src, 0});
        while(!pq.isEmpty()) {
            Integer[] node = pq.poll();
            int nodeIndex = node[0];
            int currDist = node[1];
            for(iPair next : adj.get(nodeIndex)) {
                int nextIndex = next.first;
                int nextWeight = next.second;
                int newDist = nextWeight + currDist;
                if (newDist < dist.get(nextIndex)) {
                    dist.set(nextIndex, newDist);
                    pq.add(new Integer[]{nextIndex, newDist});
                }
            }
        }
        return dist;
    }
    
    private ArrayList<Integer> buildDist(int count) {
        ArrayList<Integer> dist = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            dist.add(Integer.MAX_VALUE);
        }
        return dist;
    } 
}