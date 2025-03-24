//Problem Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/

//Djisktra's Algorithm
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        } else if (n == 1) {
            return 1;
        }
        int[][] dist = initDist(n);
        Queue<Integer[]> q = new LinkedList<>();
        int[] dirX = { 1, 0, 1, -1, -1, -1,  0,  1};
        int[] dirY = { 1, 1, 0,  1,  0, -1, -1, -1};
        dist[0][0] = 1;
        q.add(new Integer[]{0, 0}); //src
        while(!q.isEmpty()) {
            Integer[] node = q.poll();
            int x = node[0];
            int y = node[1];
            for (int i = 0; i < 8; i++) {
                int nextX = x + dirX[i];
                int nextY = y + dirY[i];
                int newDist = dist[x][y] + 1;
                if (nextX == n - 1 && nextY == n - 1) {
                    return newDist; //destination reached
                }
                if (nextX < 0 || nextY < 0 || nextX == n || nextY == n || 
                    grid[nextX][nextY] == 1 || dist[nextX][nextY] <= newDist
                ) {
                    continue;
                }
                dist[nextX][nextY] = newDist;
                q.add(new Integer[]{nextX, nextY});
            }
        }
        return -1;
    }

    private int[][] initDist(int n) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        return dist;
    }
}