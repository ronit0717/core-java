class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int weight = 0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x,y) -> x[2] - y[2]);
        pq.add(new Integer[]{0, -1, 0});
        boolean[] visited = new boolean[V];
        while(!pq.isEmpty()) {
            Integer[] node = pq.poll();
            int prevNode = node[1];
            int currNode = node[0];
            int edgeWeight = node[2];
            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;
            weight += edgeWeight;
            for (int[] next : adj.get(currNode)) {
                int nextNode = next[0];
                int nextWeight = next[1];
                if (visited[nextNode]) {
                    continue;
                }
                pq.add(new Integer[]{nextNode, currNode, nextWeight});
            }
        }
        return weight;
    }
}