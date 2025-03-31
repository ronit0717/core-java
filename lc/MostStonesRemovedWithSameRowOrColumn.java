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

    private int getUParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        int uParent = getUParent(parent[x]);
        parent[x] = uParent;
        return uParent;
    }

    public void union(int x, int y) {
        int uParentX = getUParent(x);
        int uParentY = getUParent(y);
        if (uParentX == uParentY) {
            return;
        }
        if(size[uParentX] < size[uParentY]) {
            parent[uParentX] = uParentY;
            size[uParentY] += size[uParentX];
        } else {
            parent[uParentY] = uParentX;
            size[uParentX] += size[uParentY];
        }
    }

    public int getCountOfDisjointSet() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i && size[i] > 1) {
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRowIndex = -1;
        int maxColIndex = -1;
        for (int i = 0; i < stones.length; i++) {
            maxRowIndex = Math.max(maxRowIndex, stones[i][0]);
            maxColIndex = Math.max(maxColIndex, stones[i][1]);
        }
        int totalRows = maxRowIndex + 1;
        int totalCols = maxColIndex + 1;
        int totalNodes = totalRows + totalCols;
        DisjointSet ds = new DisjointSet(totalNodes);
        for (int i = 0; i < n; i++) {
           int rowNode = stones[i][0];
           int colNode = totalRows + stones[i][1];
           ds.union(rowNode, colNode);
        }
        int disjointSetCount = ds.getCountOfDisjointSet();
        return n - disjointSetCount;
    }
}