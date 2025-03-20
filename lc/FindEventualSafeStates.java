//Solution 0 : DFS
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean[] safe = new boolean[v];
        boolean[] visited = new boolean[v];
        boolean[] pathVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            safe[i] = true;
        }
        for (int i = 0; i < v; i++) {
            if (visited[i]) {
                continue;
            }
            isSafeDFS(i, safe, visited, pathVisited, graph);
        }
        List<Integer> safeNodes = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(safe[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean isSafeDFS(int i, boolean[] safe, boolean[] visited, 
                        boolean[] pathVisited, int[][] graph) {
        if (visited[i] && pathVisited[i]) {
            return false;
        } else if (visited[i]) {
            return safe[i];
        }
        visited[i] = true;
        pathVisited[i] = true;
        boolean status = true;
        int next[] = graph[i];
        for (int j = 0; j < next.length; j++) {
            boolean nextStatus = isSafeDFS(next[j], safe, visited, pathVisited, graph);
            if (!nextStatus) {
                status = nextStatus;
            }
        }
        safe[i] = status;
        pathVisited[i] = false;
        return status;
    }
}

//Solution 1: BFS Kahn's Algorithm
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] inDegree = new int[graph.length];
        List<List<Integer>> adj = new ArrayList<>(graph.length);
        buildReverseGraphAndInDegree(adj, inDegree, graph);
        List<Integer> topo = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        initQueueAndTopo(q, topo, inDegree);
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int next : adj.get(node)) {
                inDegree[next] -= 1;
                if (inDegree[next] == 0) {
                    topo.add(next);
                    q.add(next);
                }
            }
        }
        Collections.sort(topo);
        return topo;
    }

    private void initQueueAndTopo(Queue<Integer> q, List<Integer> topo, int[] inDegree) {
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                topo.add(i);
            }
        }
    }

    private void buildReverseGraphAndInDegree(List<List<Integer>> adj, 
                                                int[] inDegree, int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            int[] next = graph[i];
            for (int j = 0; j < next.length; j++) {
                adj.get(next[j]).add(i);
                inDegree[i] += 1;
            }
        }
    }
}