/*
Logic:

Survey mode:
------------
Iterate, find only rotten oranges
for the rotten oranges find the oranges which are not rotten which are not visited
add them to queue and mark the orange as visited (visited means its already added to queue)

Non survey mode:
----------------
Here we take fresh oranges and make them rot. Then again check for fresh oranges in adjacent which are not visited and add them to queue and mark the orange as visited

Do this till queue is not empty

In the end check the matrix if any fresh orange is left out
(We can check this by keeping a count of number of fresh oranges available during survey, and in non survey mode, decrement the freshOrange count. If in the end fresh orange count == 0, this means no fresh orange left)
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int size = rows * cols;
        
        boolean[] visited = new boolean[size];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < size; i++) {
            rottingUtil(true, grid, i, visited, q);
        }
        
        if (!q.isEmpty()) {
            q.add(-1); //change of level
        }
        
        int minutes = 0;
        while (!q.isEmpty()) {
            int currIndex = q.poll();
            
            if (currIndex == -1 && q.isEmpty()) { //q is finished
                minutes++;
            } else if (currIndex == -1) {
                minutes++;
                q.add(-1);
            } else {
                rottingUtil(false, grid, currIndex, visited, q);
            }
        }
        
        //alternatively: can keep count of fresh oranges available approach (faster)
        if (checkIfFreshExists(grid)) {
            return -1;
        } else {
            return minutes;
        }
        
    }
    
    private boolean checkIfFreshExists(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int size = rows * cols;
        
        for (int i = 0; i < size; i++) {
            int r = i / cols;
            int c = i % cols;
            if (grid[r][c] == 1) {
                return true;
            }
        }
        return false;
    }
    
    private void rottingUtil(boolean surveyMode, int[][] grid, int index, boolean[] visited, Queue<Integer> q) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int r = index / cols;
        int c = index % cols;
        
        if (surveyMode && grid[r][c] != 2) {
            return;
        } else {
            grid[r][c] = 2;
        }
        
        int[][] dir = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        for (int i = 0; i < dir.length; i++) {
            int new_r = r + dir[i][0];
            int new_c = c + dir[i][1];
            int new_index = new_r * cols + new_c;
            
            if (new_r < 0 || new_c < 0 || new_r >= rows || new_c >= cols || grid[new_r][new_c] != 1 || visited[new_index]) {
                continue;
            }
            
            q.add(new_index);
            visited[new_index] = true;
        }
    }
}