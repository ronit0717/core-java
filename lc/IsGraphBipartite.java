class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            boolean status = util(i, 1, visited, graph);
            if (!status) {
                return false;
            }
        }
        return true;
    }

    private boolean util(int index, int color, int[] visited, int[][] graph) {
        if (visited[index] != 0 && color == visited[index]) {
            return true;
        } else if (visited[index] != 0 && color != visited[index]) {
            return false;
        }
        visited[index] = color;
        int[] nextArr = graph[index];
        for (int i = 0; i < nextArr.length; i++) {
            int newColor = (color == 1) ? -1 : 1;
            boolean status = util(nextArr[i], newColor, visited, graph);
            if (!status) {
                return false;
            }
        }
        return true;
    }
}