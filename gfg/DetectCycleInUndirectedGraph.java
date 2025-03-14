//DFS
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i]) {
                continue;
            }
            boolean check = dfsCheck(i, -1, adj, visited);
            if (check) {
                return true;
            }
        }
        return false;
    }
    
    private boolean dfsCheck(int node, int prev, 
            ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int next : adj.get(node)) {
            if (next == prev) {
                continue;
            }
            if (visited[next]) {
                return true;
            }
            boolean nextCheck = dfsCheck(next, node, adj, visited);
            if (nextCheck) {
                return true;
            }
        }
        return false;
    }
}

//BFS
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i]) {
                continue;
            }
            q.add(new Integer[]{i, -1}); //first node with no prev
            visited[i] = true;
            while(!q.isEmpty()) {
                Integer[] node = q.poll();
                for (int next : adj.get(node[0])) {
                    if (next == node[1]) {
                        //current node's prev is current node
                        continue;
                    }
                    if(visited[next]) {
                        return true; //cycle detected
                    }
                    q.add(new Integer[]{next, node[0]});
                    visited[next] = true;
                }
            }
        }
        
        return false;
    }
}