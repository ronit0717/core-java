//Problem Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

//Solution 2: BFS (Kahn's Algorithm)
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        int[] inDegree = buildInDegree(adj);
        populateTopoAndQueue(inDegree, q, topo);
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int next : adj.get(node)) {
                inDegree[next] -= 1;
                if (inDegree[next] == 0) {
                    q.add(next);
                    topo.add(next);
                }
            }
            
        }
        if (topo.size() != adj.size()) {
            return true;
        }
        return false;
    }
    
    private void populateTopoAndQueue(int[] inDegree, Queue<Integer> q, List<Integer> topo) {
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                topo.add(i);
            }
        }
    }
    
    private int[] buildInDegree(ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            for (int next : adj.get(i)) {
                inDegree[next] += 1;
            }
        }
        return inDegree;
    }
}

//Solution 1: DFS
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        boolean[] pathVisited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if(visited[i]) {
                continue;
            }
            boolean isCyclic = check(i, visited, pathVisited, adj);
            if (isCyclic) {
                return true;
            }
        }
        return false;
    }
    
    private boolean check(int index, boolean[] visited, 
                            boolean[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
        
        if (visited[index] && pathVisited[index]) {
            return true;
        } else if (visited[index]) {
            return false;
        }            
        visited[index] = true;
        pathVisited[index] = true;
        
        for (Integer next : adj.get(index)) {
            boolean isCyclic = check(next, visited, pathVisited, adj);
            if (isCyclic) {
                return true;
            }
        }
        pathVisited[index] = false;
        return false;
    }
}