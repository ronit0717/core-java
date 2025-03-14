class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = buildAdjList(isConnected);
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
            } else {
                continue;
            }
            Stack<Integer> st = new Stack<>();
            st.push(i);
            while(!st.isEmpty()) {
                int city = st.pop();
                if (visited[city]) {
                    continue;
                }
                visited[city] = true;
                for (Integer next : adj.get(city)) {
                    st.push(next);
                }
            }
        }
        return count;
    }

    private List<List<Integer>> buildAdjList(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    list.add(j);
                }
            }
            adj.add(list);
        }
        return adj;
    }
}