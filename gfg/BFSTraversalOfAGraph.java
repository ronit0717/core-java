//Problem Link: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

//SC = O(V), TC = (O + 2E)
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfs = new ArrayList<>(V);
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
            
        queue.add(0);
        visited[0] = true;
        bfs.add(0);
        
        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> list = adj.get(node);
            for (Integer next : list) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                bfs.add(next);
                queue.add(next);
            }
        }
        return bfs;
    }
}