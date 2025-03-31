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

    public int getSize(int x) {
        int uParent = getUParent(x);
        return size[uParent];
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
}

class Solution {
    public int largestIsland(int[][] grid) {
        DisjointSet ds = buildDisjointSet(grid);
        int maxSize = -1;
        int n = grid.length;
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, -1, 0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int size = 1;
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nextI = i + dirX[k];
                    int nextJ = j + dirY[k];
                    if (nextI < 0 || nextJ < 0 || nextI == n 
                            || nextJ == n || grid[nextI][nextJ] == 0) {
                        continue;
                    }
                    int y = nextI * n + nextJ;
                    int ultimateParentY = ds.getUParent(y);
                    if (set.contains(ultimateParentY)) {
                        continue;
                    }
                    set.add(ultimateParentY);
                    int newSize = ds.getSize(ultimateParentY);
                    size += ds.getSize(ultimateParentY);
                }
                if (size > maxSize) {
                    maxSize = size;
                }
            }
        }
        if (maxSize == -1) {
            return n * n; //all 1's case
        }
        return maxSize;
    }

    private DisjointSet buildDisjointSet(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, -1, 0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int x = i * n + j;
                for (int k = 0; k < 4; k++) {
                    int nextI = i + dirX[k];
                    int nextJ = j + dirY[k];
                    if (nextI < 0 || nextJ < 0 || nextI == n 
                            || nextJ == n || grid[nextI][nextJ] == 0) {
                        continue;
                    }
                    int y = nextI * n + nextJ;
                    ds.union(x, y);
                }
            }
        }
        return ds;
    }
}