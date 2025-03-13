class Solution {
    public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int m = 0; m < edges.length; m++) {
            int node1 = edges[m][0];
            int node2 = edges[m][1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        ArrayList<Integer> component = null;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (visited[i]) {
                continue;
            }
            if (component != null) {
                Collections.sort(component);
                ans.add(component);
            }
            component = new ArrayList<>();
            component.add(i);
            visited[i] = true;
            Stack<Integer> st = new Stack<>();
            st.push(i);
            while (!st.isEmpty()) {
                ArrayList<Integer> list = graph.get(st.pop());
                for (Integer node : list) {
                    if (visited[node]) {
                        continue;
                    }
                    component.add(node);
                    visited[node] = true;
                    st.push(node);
                }
            }
        }
        if (component != null) {
            Collections.sort(component);
            ans.add(component);
        }
        return ans;
    }
}