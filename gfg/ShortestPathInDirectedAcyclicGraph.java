//Problem Link: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
/*
1. Find topo
2. Follow topo stack and fill up the dist
*/
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<Integer[]>> adj = buildAdj(V, edges);
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            topo(i, visited, adj, st);
        }
        int[] dist = initDist(V);
        while(st.peek() != 0) { //source Node
            st.pop();
        }
        dist[0] = 0;
        while(!st.isEmpty()) {
            int node = st.pop();
            for (Integer[] nextNode : adj.get(node)) {
                int nextIndex = nextNode[0];
                int nextDist = nextNode[1];
                int newNextDist = dist[node] + nextDist;
                if (dist[nextIndex] == -1 || newNextDist < dist[nextIndex]) {
                    dist[nextIndex] = newNextDist;
                }
            }
        }
        return dist;
    }
    
    private int[] initDist(int V) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = -1;
        }
        return dist;
    }
    
    private void topo(int index, boolean[] visited, 
                    List<List<Integer[]>> adj, Stack<Integer> st) {
        
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        for (Integer[] nextNode : adj.get(index)) {
            int nextIndex = nextNode[0];
            topo(nextIndex, visited, adj, st);
        }
        st.push(index);
    }
    
    private List<List<Integer[]>> buildAdj(int V, int[][] edges) {
        List<List<Integer[]>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            adj.get(src).add(new Integer[]{dest, weight});
        }
        return adj;
    }
}