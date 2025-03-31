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
        if(parent[x] == x) {
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
        
        if(size[uParentY] < size[uParentX]) {
            parent[uParentY] = uParentX;
            size[uParentX] +=  size[uParentY];
        } else {
            parent[uParentX] = uParentY;
            size[uParentY] += uParentX;
        }
    }
}

class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        DisjointSet ds = new DisjointSet(rows*cols);
        List<Integer> result = new ArrayList<>(operators.length);
        int countIslands = 0;
        boolean[][] visited = new boolean[rows][cols];
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        for (int i = 0; i < operators.length; i++) {
            int iRow = operators[i][0];
            int iCol = operators[i][1];
            if (visited[iRow][iCol]) {
                result.add(countIslands);
                continue;
            }
            visited[iRow][iCol] = true;
            int iIndex = iRow * cols + iCol;
            countIslands++;
            for (int j = 0; j < 4; j++) {
                int jRow = iRow + dirX[j];
                int jCol = iCol + dirY[j];
                if (jRow < 0 || jCol < 0 || jRow == rows || jCol == cols || 
                    !visited[jRow][jCol]) {
                    continue;
                }
                int jIndex = jRow * cols + jCol;
                if (!ds.isConnected(iIndex, jIndex)) {
                    countIslands--;
                    ds.union(iIndex, jIndex);
                }
            }
            result.add(countIslands);
        }
        return result;
    }
    
}