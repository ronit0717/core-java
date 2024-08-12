/**
 * Solution 1.3: Tabulation space optimised
 */
import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		if (matrix.length == 1) {
			int maxSum = Integer.MIN_VALUE;
			for (int j = 0; j < matrix[0].length; j++) {
				maxSum = Math.max(maxSum, matrix[0][j]);
			}
			return maxSum;
		}
		// Write your code here
		int[] dp = new int[matrix[0].length];
		int[] prevDp = new int[matrix[0].length];
		for (int i = matrix.length - 1; i >= 1; i--) {
			for (int k = 0; k < dp.length; k++) {
				prevDp[k] = dp[k];
			}
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				if (i == (matrix.length - 1)) {
					dp[j] = matrix[i][j];
				} else {
					int maxSum = Integer.MIN_VALUE;
					for (int k = -1; k <= 1; k++) {
						int col = j + k;
						if (col < 0 || col >= matrix[i].length) {
							continue;
						}
						maxSum = Math.max((matrix[i][j] + prevDp[col]), maxSum);
					}
					dp[j] = maxSum;
				}
			}
		}
		
		//0th row
		int maxSum = Integer.MIN_VALUE;
		for (int k = 0; k < dp.length; k++) {
			prevDp[k] = dp[k];
		}
		for (int j = 0; j < matrix[0].length; j++) {
			for (int k = -1; k <= 1; k++) {
				int col = j + k;
				if (col < 0 || col >= matrix[0].length) {
					continue;
				}
				maxSum = Math.max((matrix[0][j] + prevDp[col]), maxSum);
			}
		}
		return maxSum;
	}
}

/**
 * Solution 1.2: Tabulation
 */
import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		if (matrix.length == 1) {
			int maxSum = Integer.MIN_VALUE;
			for (int j = 0; j < matrix[0].length; j++) {
				maxSum = Math.max(maxSum, matrix[0][j]);
			}
			return maxSum;
		}
		// Write your code here
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = matrix.length - 1; i >= 1; i--) {
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				if (i == (matrix.length - 1)) {
					dp[i][j] = matrix[i][j];
				} else {
					int maxSum = Integer.MIN_VALUE;
					for (int k = -1; k <= 1; k++) {
						int col = j + k;
						if (col < 0 || col >= matrix[i].length) {
							continue;
						}
						maxSum = Math.max((matrix[i][j] + dp[i+1][col]), maxSum);
					}
					dp[i][j] = maxSum;
				}
			}
		}
		
		//0th row
		int maxSum = Integer.MIN_VALUE;
		for (int j = 0; j < matrix[0].length; j++) {
			for (int k = -1; k <= 1; k++) {
				int col = j + k;
				if (col < 0 || col >= matrix[0].length) {
					continue;
				}
				maxSum = Math.max((matrix[0][j] + dp[1][col]), maxSum);
			}
		}
		return maxSum;
	}
}

/**
 * Solution 1.1: Memoisation
 */
import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		if (matrix.length == 1 && matrix[0].length == 1) {
			return matrix[0][0];
		}
		Integer[][] dp = new Integer[matrix.length][matrix[0].length];
		int maxSum = Integer.MIN_VALUE;
		for (int j = 0; j < matrix[0].length; j++) {
			for (int k = -1; k <= 1; k++) {
				int nextCol = j + k;
				if (nextCol < 0 || nextCol >= matrix[0].length) {
					continue;
				}
				int sum = matrix[0][j] + evaluate(1, nextCol, matrix, dp);
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}

	private static int evaluate(int i, int j, int[][] matrix, Integer[][] dp) {
		if (i >= matrix.length) {
			return 0;
		}
		if (dp[i][j] != null) {
			return dp[i][j];
		}
		int maxSum = Integer.MIN_VALUE;
		for (int k = -1; k <=1; k++) {
			int nextCol = j + k;
			if (nextCol < 0 || nextCol >= matrix[i].length) {
				continue;
			}
			int sum = matrix[i][j] + evaluate(i + 1, j + k, matrix, dp);
			maxSum = Math.max(maxSum, sum);
		}
		dp[i][j] = maxSum;
		return maxSum;
	}
}