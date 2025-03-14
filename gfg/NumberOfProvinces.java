//Problem Link: https://www.geeksforgeeks.org/problems/number-of-provinces/1

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] visited = new boolean[V];
        int count = 0;
        ArrayList<ArrayList<Integer>> adjList = buildAdjList(adj);
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }
    
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (Integer next : adjList.get(node)) {
            dfs(next, adjList, visited);
        }
    }
    
    private static ArrayList<ArrayList<Integer>> buildAdjList(ArrayList<ArrayList<Integer>> adjMat) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int node = 0; node < adjMat.size(); node++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int next = 0; next < adjMat.get(node).size(); next++) {
                if (node == next || adjMat.get(node).get(next) == 0) {
                    continue;
                }
                list.add(next);
            }
            adjList.add(list);
        }
        return adjList;
    }
};