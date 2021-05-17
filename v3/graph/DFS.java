class Solution
{
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> dfs = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            dfsUtil(visited, adj, i, dfs);
        }
        return dfs;
    }
    
    private static void dfsUtil(boolean[] visited, 
                                ArrayList<ArrayList<Integer>> adj, 
                                int curr, 
                                ArrayList<Integer> dfs) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        dfs.add(curr);
        ArrayList<Integer> next = adj.get(curr);
        for (Integer n : next) {
            dfsUtil(visited, adj, n, dfs);
        }
    }
}