/**
 * Solution 1.3: Tabulation space optimised
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int[] dp = new int[n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) { //important
                if (i == (n-1)) {
                    dp[j] = triangle[i][j];
                } else {
                    int downSum = triangle[i][j] + dp[j];
                    int diagSum = triangle[i][j] + dp[j+1];
                    dp[j] = Math.min(downSum, diagSum);
                }
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
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        Integer[][] dp = new Integer[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (i == (n-1)) {
                    dp[i][j] = triangle[i][j];
                } else {
                    int downSum = triangle[i][j] + dp[i+1][j];
                    int diagSum = triangle[i][j] + dp[i+1][j+1];
                    dp[i][j] = Math.min(downSum, diagSum);
                }
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
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        Integer[][] dp = new Integer[n][n];
        evaluate(triangle, n, dp, 0, 0);
        return dp[0][0];
    }

    private static int evaluate(int[][] triangle, int n, Integer[][] dp, int i, int j) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (i == (n - 1)) { //last row
            dp[i][j] = triangle[i][j];
        } else {
            int downSum = triangle[i][j] + evaluate(triangle, n, dp, i + 1, j);
            int diagSum = triangle[i][j] + evaluate(triangle, n, dp, i + 1, j + 1);
            dp[i][j] = Math.min(downSum, diagSum);
        }
        return dp[i][j];
    }
}