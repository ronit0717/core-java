class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = buildAdjList(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean status = dfs(i, visited, pathVisited, adj);
            if (status) {
                return false; //cycle, hence cant finish course 
            }
        }
        return true; //not cycle, hence can finish course
    }

    private boolean dfs(int index, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj) {
        if (visited[index] && !pathVisited[index]) {
            return false; //not cycle
        } else if (visited[index] && pathVisited[index]) {
            return true; //is cycle
        }
        visited[index] = true;
        pathVisited[index] = true;
        for (int next : adj.get(index)) {
            boolean status = dfs(next, visited, pathVisited, adj);
            if (status) {
                return status; //is cycle
            }
        }
        pathVisited[index] = false; //back track
        return false; //not cycle
    }

    private List<List<Integer>> buildAdjList(int num, int[][] pr) {
        List<List<Integer>> adj = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < pr.length; i++) {
            int start = pr[i][1];
            int end = pr[i][0];
            adj.get(start).add(end);
        }
        return adj;
    }

}