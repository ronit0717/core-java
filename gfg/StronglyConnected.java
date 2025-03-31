//Kosaraju Algorithm

class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            buildStack(st, i, visited, adj);
        }
        ArrayList<ArrayList<Integer>> revAdj = reverse(adj);
        return countSCC(st, revAdj);
    }
    
    private int countSCC(Stack<Integer> st, ArrayList<ArrayList<Integer>> revAdj) {
        int count = 0;
        boolean[] visited = new boolean[revAdj.size()];
        while(!st.isEmpty()) {
            int index = st.pop();
            if (visited[index]) {
                continue;
            }
            count++;
            dfs(index, visited, revAdj);
        }
        return count;
    }
    
    private void dfs(int index, boolean[] visited, 
                        ArrayList<ArrayList<Integer>> revAdj) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        for (Integer next : revAdj.get(index)) {
            dfs(next, visited, revAdj);
        }
    }
    
    private ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (Integer next : adj.get(i)) {
                revAdj.get(next).add(i);
            }
        }
        return revAdj;
    }
    
    private void buildStack(Stack<Integer> st, int index, 
                                    boolean[] visited, 
                                    ArrayList<ArrayList<Integer>> adj) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        for (Integer next : adj.get(index)) {
            buildStack(st, next, visited, adj);
        }
        st.push(index);
    }
}