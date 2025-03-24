//Djisktra's Algorithm
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Integer[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        int[] dist = buildDist(n);
        List<List<Integer[]>> adj = buildAdj(times, n);
        dist[k] = 0;
        q.add(new Integer[]{k, 0});
        while(!q.isEmpty()) {
            Integer[] node = q.poll();
            int nodeIndex = node[0];
            int time = node[1];
            for (Integer[] next : adj.get(nodeIndex)) {
                int nextIndex = next[0];
                int timeDiff = next[1];
                int nextTime = time + timeDiff;
                if (dist[nextIndex] > nextTime) {
                    dist[nextIndex] = nextTime;
                    q.add(new Integer[]{nextIndex, nextTime});
                }
            }
        }
        int totalTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; //unreachable node
            }
            totalTime = Math.max(totalTime, dist[i]);
        }
        return totalTime;
    }

    private int[] buildDist(int n) {
        int[] dist = new int[n + 1]; //1 based index
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        return dist;
    }

    private List<List<Integer[]>> buildAdj(int[][] times, int n) {
        List<List<Integer[]>> adj = new ArrayList<>(n);
        for (int i = 0; i <= n; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int node = times[i][0];
            int next = times[i][1];
            int weight = times[i][2];
            adj.get(node).add(new Integer[]{next, weight});
        }
        return adj;
    }
}