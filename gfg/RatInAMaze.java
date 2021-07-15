//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

/*
Simple backtracking logic

TC  = 4 ^ (n * m), as 4 choices and max depth n * m
SC = O(n * m) for stack depth
*/
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> paths = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[][] dir = { {1, 0}, {0, -1}, {0, 1}, {-1, 0} };
        //char[] dirChar = { 'D', 'R', 'U', 'L' }; //this order will give the shortest path first
        char[] dirChar = { 'D', 'L', 'R', 'U' }; //this order will give the lexicographical order with sort
        
        if(m[0][0] == 0) {
            return paths;
        }
        
        m[0][0] = -1; //visited
        
        pathUtil(m, n, 0, 0, paths, sb, dir, dirChar);
        
        m[0][0] = 1; //backtrack
        
        //Collections.sort(paths); //to make it lexicographically sorted in case dirChar is changed
        
        return paths;
    }
    
    private static void pathUtil(int[][] m, int n, int x, int y, 
                            ArrayList<String> paths, StringBuilder sb, 
                            int[][] dir, char[] dirChar) {
        if (x == n-1 && y == n - 1) {
            paths.add(new String(sb.toString()));
            return;
        }
        for (int i = 0; i < dir.length; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            
            if (newX < 0 || newX >= n || newY < 0 || newY >= n 
                || m[newX][newY] == -1 || m[newX][newY] == 0) {
                continue;
            }
            
            sb.append(dirChar[i]);
            m[newX][newY] = -1; //means the position is visited
            
            pathUtil(m, n, newX, newY, paths, sb, dir, dirChar);
            
            //backtrack
            int len = sb.length();
            sb.deleteCharAt(len - 1); 
            m[newX][newY] = 1;
        }
    }
}