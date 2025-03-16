//Problem link: https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<String> islandSet = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                List<Integer[]> islandList = new LinkedList<>();
                dfs(i, j, i, j, islandList, grid, visited);
                islandSet.add(getIslandInfo(islandList));
            }
        }
        return islandSet.size();
    }
    
    private String getIslandInfo(List<Integer[]> islandList) {
        StringBuffer sb = new StringBuffer();
        for(Integer[] coordinate : islandList) {
            sb.append("{" + coordinate[0] + "," + coordinate[1] + "} ");
        }
        return sb.toString();
    }
    
    private void dfs(int i, int j, int initI, int initJ, 
                    List<Integer[]> islandList, 
                    int[][] grid, boolean[][] visited) {
        
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length 
            || grid[i][j] == 0 || visited[i][j]
        ) {
            return;
        }
        visited[i][j] = true;
        int coordinateI = i - initI;
        int coordinateJ = j - initJ;
        Integer[] coordinate = new Integer[]{coordinateI, coordinateJ};
        islandList.add(coordinate);
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        for (int m = 0; m < 4; m++) {
            int newI = i + dirX[m];
            int newJ = j + dirY[m];
            dfs(newI, newJ, initI, initJ, islandList, grid, visited);
        }
    }
}