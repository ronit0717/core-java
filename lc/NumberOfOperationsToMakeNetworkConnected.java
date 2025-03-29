//Disjoint set Algorithm
class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int getUltimateParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        int ultimateParent = getUltimateParent(parent[x]);
        parent[x] = ultimateParent;
        return ultimateParent;
    }

    public boolean isConnected(int x, int y) {
        int ultimateParentX = getUltimateParent(x);
        int ultimateParentY = getUltimateParent(y);
        return ultimateParentX == ultimateParentY;
    }

    public void union(int x, int y) {
        int ultimateParentX = getUltimateParent(x);
        int ultimateParentY = getUltimateParent(y);
        if (ultimateParentX == ultimateParentY) {
            return;
        }
        if (size[ultimateParentX] < size[ultimateParentY]) {
            parent[ultimateParentX] = ultimateParentY;
            size[ultimateParentY] += size[ultimateParentX];
        } else {
            parent[ultimateParentY] = ultimateParentX;
            size[ultimateParentX] += size[ultimateParentY];
        }
    }

    public int getDisjointSetCount() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for (int i = 0; i < connections.length; i++) {
            int x = connections[i][0];
            int y = connections[i][1];
            if (ds.isConnected(x, y)) {
                extraEdges++;
            } else {
                ds.union(x, y);
            }
        }
        int disjointSetCount = ds.getDisjointSetCount();
        int connectionsRequired = disjointSetCount - 1;
        if (extraEdges < connectionsRequired) {
            return -1;
        }
        return connectionsRequired;
    }
}