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

    public int getUParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        int uParent = getUParent(parent[x]);
        parent[x] = uParent;
        return uParent;
    }

    public boolean isConnected(int x, int y) {
        int uParentX = getUParent(x);
        int uParentY = getUParent(y);
        return uParentX == uParentY;
    }

    public void union(int x, int y) {
        int uParentX = getUParent(x);
        int uParentY = getUParent(y);
        if (uParentX == uParentY) {
            return;
        }
        if (size[uParentX] < size[uParentY]) {
            parent[uParentX] = uParentY;
            size[uParentY] += size[uParentX];
        } else {
            parent[uParentY] = uParentX;
            size[uParentX] += size[uParentY];
        }
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        DisjointSet ds = new DisjointSet(size);
        int startIndex = 0;
        int endIndex = size - 1;
        for (int t = 0; t < size; t++) {
            modifyDS(grid, t, ds);
            if (ds.isConnected(startIndex, endIndex)) {
                return t;
            }
        }
        return -1;
    }

    private void modifyDS(int[][] grid, int time, DisjointSet ds) {
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != time) {
                    continue;
                }
                //cell found matching the time
                int x = i * n + j;
                for (int k = 0; k < 4; k++) {
                    int ii = i + dirX[k];
                    int jj = j + dirY[k];
                    if (ii < 0 || jj < 0 || ii == n || jj == n || grid[ii][jj] > time) {
                        continue;
                    }
                    int y = ii * n + jj;
                    ds.union(x, y);
                }
                return;
            }
        }
    }
}