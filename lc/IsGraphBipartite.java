class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length]; //0 means not visited, 1 represent first color, -1 represent other color
        
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            boolean status = dfsUtil(i, -1, graph, visited, 1);
            if (!status) {
                return status;
            }
        }
        return true;
    }
    
    private static boolean dfsUtil(int curr, int prev, int[][] graph, int[] visited, int color) {
        if (visited[curr] != 0) {
            if (color != visited[curr]) {
                return false;
            } else {
                return true;
            }
        }
        visited[curr] = color;
        int[] next = graph[curr];
        for (Integer n : next) {
            if (n == prev) {
                continue;
            }
            boolean status = dfsUtil(n, curr, graph, visited, (color*-1));
            if (!status) {
                return status;
            }
        }
        return true;
    }
}