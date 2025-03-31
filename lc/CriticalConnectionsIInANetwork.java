class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = buildAdj(n, connections);
        List<List<Integer>> criticalConnections = new LinkedList<>();
        int[] time = {0};
        int[] inTime = new int[n];
        int[] min = new int[n]; //min intime of adjacent node expect parent
        dfs(0, -1, time, inTime, min, adj, criticalConnections);
        return criticalConnections;
    }

    private void dfs(int node, int prev, int[] time, int[] inTime, int[] min, 
                        List<List<Integer>> adj, List<List<Integer>> connections) {
        if (inTime[node] != 0) {
            //visited
            return;
        }
        time[0] += 1;
        inTime[node] = time[0];
        min[node] = time[0];
        for (int next : adj.get(node)) {
            if (next == prev) {
                continue; //ignore parent
            }
            dfs(next, node, time, inTime, min, adj, connections);
            min[node] = Math.min(min[node], min[next]);
            if (min[next] > inTime[node]) {
                //brige identified
                List<Integer> connection = new ArrayList<>(2);
                connection.add(node);
                connection.add(next);
                connections.add(connection);
            }
        }
    }

    private List<List<Integer>> buildAdj(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            int first = connections.get(i).get(0);
            int second = connections.get(i).get(1);
            adj.get(first).add(second);
            adj.get(second).add(first);
        }
        return adj;
    }
}