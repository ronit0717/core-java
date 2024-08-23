/**
 * Solution 1.3: Tabulation with space optimisation (Single 1D DP Array)
 */
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			for (int t = 0; t <= n; t++) {
				int money = 0;
				if (i == 0) {
					money = t * price[i];
				} else {
					int notCut = dp[t];
					int cut = -1;
					if ((i + 1) <= t) {
						cut = price[i] + dp[t - (i + 1)];
					}
					money = Math.max(cut, notCut);
				}
				dp[t] = money;
			}
		}
		return dp[n];
	}
}

/**
 * Solution 1.2: Tabulation
 */
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp = new int[n][n + 1];
		for (int i = 0; i < n; i++) {
			for (int t = 0; t <= n; t++) {
				int money = 0;
				if (i == 0) {
					money = t * price[i];
				} else {
					int notCut = dp[i - 1][t];
					int cut = -1;
					if ((i + 1) <= t) {
						cut = price[i] + dp[i][t - (i + 1)];
					}
					money = Math.max(cut, notCut);
				}
				dp[i][t] = money;
			}
		}
		return dp[n - 1][n];
	}
}

/**
 * Solution 1.1: Memoisation
 */
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp = new int[n][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = -1;
			}
		}
		return evaluate(n - 1, n, price, dp);
	}

	private static int evaluate(int index, int target, int[] price, int[][] dp) {
		if (dp[index][target] != -1) {
			return dp[index][target];
		}
		int money = 0;
		if (index == 0) {
			money = target * price[0];
		} else {
			int notCut = evaluate(index - 1, target, price, dp);
			int cut = -1;
			if ((index + 1) <= target) {
				cut = price[index] + evaluate(index, target - (index + 1), price, dp);
			}
			money = Math.max(cut, notCut);
		}
		dp[index][target] = money;
		return money;
	}
}