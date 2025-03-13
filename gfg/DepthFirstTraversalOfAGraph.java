//Problem link: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

//Recursive Approach
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        evaluate(dfs, adj, 0, visited);
        return dfs;
    }
    
    private void evaluate(ArrayList<Integer> dfs, 
                            ArrayList<ArrayList<Integer>> adj, 
                            int node, 
                            boolean[] visited) {
        if(visited[node]) {
            return;
        }
        dfs.add(node);
        visited[node] = true;
        for (Integer next : adj.get(node)) {
            evaluate(dfs, adj, next, visited);
        }
    }
}

//Iterative Approach
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        while(!st.isEmpty()) {
            int node = st.pop();
            if (visited[node]) {
                continue;
            }
            visited[node] = true; 
            dfs.add(node);
            List<Integer> nextList = adj.get(node);
            for (int i = nextList.size() - 1; i >= 0; i--) {
                int next = nextList.get(i);
                st.push(next);
            }
        }
        return dfs;
    }
}