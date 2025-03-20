class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];
        populateAdjListAndInDegree(adj, inDegree, prerequisites);
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>(numCourses);
        populateQueueAndTopo(q, topo, inDegree);
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
        if (topo.size() != numCourses) {
            return new int[]{}; //empty array / cycle condition
        }
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = topo.get(i);
        }
        return order;
    }

    private void populateQueueAndTopo(Queue<Integer> q, List<Integer> topo, int[] inDegree) {
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                topo.add(i);
            }
        }
    }

    private void populateAdjListAndInDegree(List<List<Integer>> adj, int[] inDegree, int[][] pre) {
        for (int i = 0; i < inDegree.length; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < pre.length; i++) {
            int start = pre[i][1];
            int end = pre[i][0];
            adj.get(start).add(end);
            inDegree[end] += 1;
        }
    }
}