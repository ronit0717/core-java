class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    addQueue(grid, visited, i, j, q);
                }
            }
        }
        int day = 0;
        while(!q.isEmpty()) {
            day++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int index = q.poll();
                int i = index / grid[0].length;
                int j = index % grid[0].length;
                addQueue(grid, visited, i, j, q);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return day;
    }

    private void addQueue(int[][] grid, boolean[][] visited, int i, int j, Queue<Integer> q) {
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        for (int m = 0; m < 4; m++) {
            int newI = i + dirX[m];
            int newJ = j + dirY[m];
            if(newI < 0 || newJ < 0 || newI >= grid.length || newJ >= grid[0].length 
            || grid[newI][newJ] != 1 || visited[newI][newJ]) {
                continue;
            }
            visited[newI][newJ] = true;
            int newIndex = newI * grid[0].length + newJ;
            q.add(newIndex);
        }
    }
}