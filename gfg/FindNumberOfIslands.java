//Problem Link: https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Solution {
    public int numIslands(char[][] grid) {
        // Code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }
    
    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length 
            || grid[i][j] == '0' || visited[i][j]
        ) {
            return;
        }
        visited[i][j] = true;
        int[] dirX = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] dirY = {-1, -1, -1, 0, 1, 1, 1, 0};      
        for (int k = 0; k < 8; k++) {
            int nextI = i + dirX[k];
            int nextJ = j + dirY[k];
            dfs(nextI, nextJ, grid, visited);
        }
    }
}