class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (i == 0 || i == grid.length - 1) {
                for (int j = 0; j < grid[0].length; j++) {
                    bfs(grid, i, j, visited);
                }
            } else {
                bfs(grid, i, 0, visited);
                bfs(grid, i, grid[0].length - 1, visited);
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{i, j});
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Integer[] node = q.poll();
                int ii = node[0];
                int jj = node[1];
                for (int m = 0; m < 4; m++) {
                    int nextI = ii + dirX[m];
                    int nextJ = jj + dirY[m];
                    if(nextI < 0 || nextJ < 0 || nextI >= grid.length || nextJ >= grid[0].length
                        || grid[nextI][nextJ] == 0 || visited[nextI][nextJ]) {
                        continue;
                    }
                    q.add(new Integer[]{nextI, nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
        }
    }
}