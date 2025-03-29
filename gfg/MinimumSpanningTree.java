//Solution 1: Prim's Algorithm
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int weight = 0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x,y) -> x[2] - y[2]);
        pq.add(new Integer[]{0, -1, 0});
        boolean[] visited = new boolean[V];
        while(!pq.isEmpty()) {
            Integer[] node = pq.poll();
            int prevNode = node[1];
            int currNode = node[0];
            int edgeWeight = node[2];
            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;
            weight += edgeWeight;
            for (int[] next : adj.get(currNode)) {
                int nextNode = next[0];
                int nextWeight = next[1];
                if (visited[nextNode]) {
                    continue;
                }
                pq.add(new Integer[]{nextNode, currNode, nextWeight});
            }
        }
        return weight;
    }
}

//Solution 2: Kruskal's Algorithm
class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;
    
    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
    
}

class DisjointSet {
    int[] parent;
    int[] size;
    
    public DisjointSet(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    
    private int getUltimateParent(int x) {
        if (this.parent[x] == x) {
            return x;
        }
        int ultimateParent = getUltimateParent(this.parent[x]);
        this.parent[x] = ultimateParent;
        return ultimateParent;
    }
    
    public void union(int x, int y) {
        int ultimateParentX = getUltimateParent(x);
        int ultimateParentY = getUltimateParent(y);
        if (ultimateParentX == ultimateParentY) {
            return;
        }
        
        if (this.size[ultimateParentX] < this.size[ultimateParentY]) {
            this.parent[ultimateParentX] = ultimateParentY;
            this.size[ultimateParentY] = this.size[ultimateParentX] + this.size[ultimateParentY];
        } else {
            this.parent[ultimateParentY] = ultimateParentX;
            this.size[ultimateParentY] = this.size[ultimateParentX] + this.size[ultimateParentY];
        }
    }
    
    public boolean isConnected(int x, int y) {
        int ultimateParentX = getUltimateParent(x);
        int ultimateParentY = getUltimateParent(y);
        return ultimateParentX == ultimateParentY;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        List<Edge> edges = buildSortedEdgeList(adj);
        int sizeSum = 0;
        DisjointSet ds = new DisjointSet(V);
        for (Edge edge : edges) {
            int x = edge.start;
            int y = edge.end;
            if (ds.isConnected(x, y)) {
                continue;
            }
            ds.union(x, y);
            sizeSum += edge.weight;
        }
        return sizeSum;
    }
    
    private static List<Edge> buildSortedEdgeList(List<List<int[]>> adj) {
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int start = i;
                int end = adj.get(i).get(j)[0];
                int weight = adj.get(i).get(j)[1];
                Edge edge = new Edge(start, end, weight);
                edgeList.add(edge);
            }
        }
        Collections.sort(edgeList);
        return edgeList;
    }
}