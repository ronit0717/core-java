//Problem Link: https://www.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new LinkedList<>());
        }
        for (int j = 0; j < edges.length; j++) {
            int node1 = edges[j][0];
            int node2 = edges[j][1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        return graph;
    }
}