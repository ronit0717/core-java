class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Integer[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Integer[] node = q.poll();
                int i = node[0];
                int j = node[1];
                for (int k = 0; k < 4; k++) {
                    int newI = i + dirX[k];
                    int newJ = j + dirY[k];
                    if (newI < 0 || newJ < 0 || newI >= m || newJ >= n || visited[newI][newJ]) {
                        continue;
                    }
                    dist[newI][newJ] = 1 + dist[i][j];
                    q.add(new Integer[]{newI, newJ});
                    visited[newI][newJ] = true;
                }
            }
        }
        return dist;
    }
}