/**
 * Solution 1.4: Tabulation with space optimisation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int[] dp = new int[n];
		for (int i = (m-1); i >= 0; i--) {
			for (int j = (n-1); j >= 0; j--) {
				if (i == (m-1) && j == (n-1)) {
					dp[j] = 1;
					continue;
				}
				int val = 0;
				if (i != (m-1)) {
					val += dp[j]; //down
				}
				if (j != (n-1)) {
					val += dp[j+1]; //right
				}
				dp[j] = val;
			}
		}
		return dp[0];
	}
}

/**
 * Solution 1.3: Tabulation with 2D DP
 */
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int[][] dp = new int[m][n];
		for (int i = (m-1); i >= 0; i--) {
			for (int j = (n-1); j >= 0; j--) {
				if (i == (m-1) && j == (n-1)) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = 0;
				if (i != (m-1)) {
					dp[i][j] += dp[i + 1][j]; //down
				}
				if (j != (n-1)) {
					dp[i][j] += dp[i][j+1]; //right
				}
			}
		}
		return dp[0][0];
	}
}

/**
 * Solution 1.2: Tabulation with 1D DP
 */
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int[] dp = new int[m*n];
		for (int i = (m*n-1); i>=0; i--) {
			if (i == (m*n-1)) {
				dp[i] = 1;
				continue;
			}
			int row = i / n;
			int col = i % n;
			dp[i] = 0;
			if (col != (n-1)) {
				int rightIndex = (row)*n + (col + 1);
				dp[i] += dp[rightIndex];
			}
			if (row != (m-1)) {
				int downIndex = (row + 1)*n + (col);
				dp[i] += dp[downIndex];
			}
		}
		return dp[0];
	}
}

/**
 * Solution 1.1: Memoisation
 * 
 * In this solution no visisted array required as we can either move down or right. Which means we cannot come back to the same location
 */
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}
		return evaluate(0, 0, m, n, dp);
	}

	private static int evaluate(int i, int j, int m, int n, int dp[][]) {
		if (i >= m || j >= n) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (i == (m - 1) && j == (n - 1)) {
			dp[i][j] = 1;
		} else {
			dp[i][j] = evaluate(i + 1, j, m, n, dp) + evaluate(i, j + 1, m, n, dp);
		}
		return dp[i][j];
	}
}