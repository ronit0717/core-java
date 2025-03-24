class Node {
    int index;
    long time;
    public Node(int i, long t) {
        this.index = i;
        this.time = t;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int large = 1000000007;
        List<List<Integer[]>> adj  = buildAdj(n, roads);
        int[] ways = new int[n];
        long[] dist = initDist(n);
        ways[0] = 1;
        dist[0] = 0;
        PriorityQueue<Node> q = new PriorityQueue<Node>((x, y) -> (int)(x.time - y.time));
        q.add(new Node(0, 0L));
        while(!q.isEmpty()) {
            Node node = q.poll();
            int index = node.index;
            long time = node.time;
            for (Integer[] next : adj.get(index)) {
                int nextIndex = next[0];
                int timeDiff = next[1];
                long newTime = time + timeDiff;
                if (newTime == dist[nextIndex]) {
                    ways[nextIndex] = (ways[nextIndex] % large + ways[index] % large) % large;
                } else if (newTime < dist[nextIndex]) {
                    q.add(new Node(nextIndex, newTime));
                    dist[nextIndex] = newTime;
                    ways[nextIndex] = ways[index] % large;
                }
            }
        }
        return ways[n - 1] % large;
    }

    private long[] initDist(int n) {
        long[] dist = new long[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        return dist;
    }

    private List<List<Integer[]>> buildAdj(int n, int[][] roads) {
        List<List<Integer[]>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0];
            int dest = roads[i][1];
            int time = roads[i][2];
            adj.get(src).add(new Integer[]{dest, time});
            adj.get(dest).add(new Integer[]{src, time});
        }
        return adj;
    }
}