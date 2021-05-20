class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>();
        
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (visited[curr]) {
                continue;
            }
            visited[curr] = true;
            bfs.add(curr);
            for (Integer n : adj.get(curr)) {
                q.add(n);
            }
        }
        return bfs;
    }
}