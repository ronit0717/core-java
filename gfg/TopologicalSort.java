class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i, visited, st, adj);
        }
        ArrayList<Integer> topo = new ArrayList<>(st.size());
        while(!st.isEmpty()) {
            topo.add(st.pop());
        }
        return topo;
    }
    
    private static void dfs(int index, boolean[] visited, 
                            Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        for (Integer next : adj.get(index)) {
            dfs(next, visited, st, adj);
        }
        st.push(index);
    }
    
}