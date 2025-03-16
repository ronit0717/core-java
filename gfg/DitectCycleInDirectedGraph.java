//Problem Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

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