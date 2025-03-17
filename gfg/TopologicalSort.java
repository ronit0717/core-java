//Solution 2: BFS (Kahn's Algorithm)
class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int[] inDegree = buildInDegree(adj);
        ArrayList<Integer> topo = new ArrayList<>(adj.size());
        Queue<Integer> q = new LinkedList<>();
        populateTopoAndQueue(inDegree, topo, q, adj);
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
        return topo;
    }
    
    private static void populateTopoAndQueue(int[] inDegree,
                                ArrayList<Integer> topo, 
                                Queue<Integer> q, 
                                ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            if(inDegree[i] == 0) {
                topo.add(i);
                q.add(i);
            }
        }
    }
    
    private static int[] buildInDegree(ArrayList<ArrayList<Integer>> adj) {
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