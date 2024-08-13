/**
 * Solution 1.3: Space Optimised Tabulation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int[][] dp = new int[c][c];
		int[][] prevDP = new int[c][c];
		for (int i = (r-1); i >= 0; i--) {
			for (int m = 0; m < c; m++) {
				for (int n = 0; n < c; n++) {
					prevDP[m][n] = dp[m][n];
				}
			}
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < c; k++) {
					int sum = (j == k) ? grid[i][j] : (grid[i][j] + grid[i][k]);
					if (i != (r-1)) {
						int max = -1;
						for (int m = -1; m <= 1; m++) {
							for (int n = -1; n <= 1; n++) {
								int newJ = j + m;
								int newK = k + n;
								if (newJ < 0 || newK < 0 || newJ >= c || newK >= c) {
									continue;
								}
								int downSum = prevDP[newJ][newK];
								max = Math.max(downSum, max);
							}
						}
						sum += max;
					}
					dp[j][k] = sum;
				}
			}
		}
		return dp[0][c-1];
	}
}

/**
 * Solution 1.2: Tabulation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int[][][] dp = new int[r][c][c];
		for (int i = (r-1); i >= 0; i--) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < c; k++) {
					int sum = (j == k) ? grid[i][j] : (grid[i][j] + grid[i][k]);
					if (i != (r-1)) {
						int max = -1;
						for (int m = -1; m <= 1; m++) {
							for (int n = -1; n <= 1; n++) {
								int newJ = j + m;
								int newK = k + n;
								if (newJ < 0 || newK < 0 || newJ >= c || newK >= c) {
									continue;
								}
								int downSum = dp[i + 1][newJ][newK];
								max = Math.max(downSum, max);
							}
						}
						sum += max;
					}
					dp[i][j][k] = sum;
				}
			}
		}
		return dp[0][0][c-1];
	}
}

/**
 * Solution 1.1: Memoisation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int[][][] dp = new int[r][c][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < c; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		return evaluate(0, 0, c - 1, grid, dp);
	}

	private static int evaluate(int i, int j, int k, int[][] grid, int[][][] dp) {
		if (j < 0 || k < 0 || j >= grid[0].length || k >= grid[0].length) {
			return Integer.MIN_VALUE;
		}
		if (dp[i][j][k] != -1) {
			return dp[i][j][k];
		}
		if ( i == (grid.length - 1)) {
			dp[i][j][k] = (j == k) ? grid[i][j] : grid[i][j] + grid[i][k];
		} else {
			int maxSum = -1;
			for (int m = -1; m <= 1; m++) {
				for (int n = -1; n <= 1; n++) {
					int sum = (j == k) ? grid[i][j] : grid[i][j] + grid[i][k];
					sum += evaluate(i + 1, j + m, k + n, grid, dp);
					maxSum = Math.max(maxSum, sum);
				}
			}
			dp[i][j][k] = maxSum;
		}
		return dp[i][j][k];
	}
}