/**
 * Solution 1.3: Tabulation space optimised
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    dp[j] = grid[i][j]; //last index
                    continue;
                }
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (i != grid.length - 1) { //curr row is not last row
                    down = dp[j];
                }
                if (j != grid[0].length - 1) { //curr col is not last col
                    right = dp[j + 1];
                }
                dp[j] = grid[i][j] + Math.min(right, down);
            }
        }
        return dp[0];
    }
}

/**
 * Solution 1.2: Tabulation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j]; //last index
                    continue;
                }
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (i != grid.length - 1) { //curr row is not last row
                    down = dp[i + 1][j];
                }
                if (j != grid[0].length - 1) { //curr col is not last col
                    right = dp[i][j + 1];
                }
                dp[i][j] = grid[i][j] + Math.min(right, down);
            }
        }
        return dp[0][0];
    }
}

/**
 * Solution 1.1: Memoisation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(0, 0, grid, dp);
    }

    private static int evaluate(int i, int j, int[][] grid, int[][] dp) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE; //highest cost
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) { //last index
            dp[i][j] = grid[i][j];
        } else {
            dp[i][j] = grid[i][j] + Math.min(evaluate(i + 1, j, grid, dp), evaluate(i, j + 1, grid, dp));
        }
        return dp[i][j];
    }
}