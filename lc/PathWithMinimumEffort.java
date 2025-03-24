//Djisktra's Algo
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effortGrid = initEffort(m, n);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x, y) -> (x[2] - y[2]));
        pq.add(new Integer[]{0, 0, 0}); //src
        effortGrid[0][0] = 0;
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, -1, 0, 1};
        while(!pq.isEmpty()) {
            Integer[] node = pq.poll();
            int x = node[0];
            int y = node[1];
            int currMaxEffort = node[2]; //max effort in the curr path
            if (x == m - 1 && y == n - 1) { //destination
                return currMaxEffort;
            }
            for (int i = 0; i < 4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                if (newX < 0 || newY < 0 || newX == m || newY == n) {
                    continue;
                }
                int effort = (int)Math.abs(heights[newX][newY] - heights[x][y]);
                effort = Math.max(effort, currMaxEffort);
                if (effort >= effortGrid[newX][newY]) {
                    continue;
                }
                effortGrid[newX][newY] = effort;
                pq.add(new Integer[]{newX, newY, effort});
            }
        }
        return -1;
    }

    private int[][] initEffort(int m, int n) {
        int[][] effort = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                effort[i][j] = Integer.MAX_VALUE;
            }
        }
        return effort;
    }
}