/**
 * Solution 1.3: Tabulation space optimised
 */
public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		if (s.length() == 0 || t.length() == 0) {
			return 0;
		}
		int[] dp = new int[t.length()];
		int[] prev = new int[t.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = 0; j < dp.length; j++) {
				prev[j] = dp[j];
			}
			for (int j = t.length() - 1; j >= 0; j--) {
				int len = 0;
				if (s.charAt(i) == t.charAt(j)) {
					len = 1;
					if ((i < (s.length() - 1)) && (j < (t.length() - 1))) {
						len += prev[j + 1];
					}
				} else {
					int len1 = 0;
					int len2 = 0;
					if (i < (s.length() - 1)) {
						len1 += prev[j];
					}
					if (j < (t.length() - 1)) {
						len2 += dp[j + 1];
					}
					len = Math.max(len1, len2);
				}
				dp[j] = len;
			}
		}
		return dp[0];
    }

}

/**
 * Solution 1.2: Tabulation
 */
public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		if (s.length() == 0 || t.length() == 0) {
			return 0;
		}
		int[][] dp = new int[s.length()][t.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = t.length() - 1; j >= 0; j--) {
				int len = 0;
				if (s.charAt(i) == t.charAt(j)) {
					len = 1;
					if ((i < (s.length() - 1)) && (j < (t.length() - 1))) {
						len += dp[i + 1][j + 1];
					}
				} else {
					int len1 = 0;
					int len2 = 0;
					if (i < (s.length() - 1)) {
						len1 += dp[i + 1][j];
					}
					if (j < (t.length() - 1)) {
						len2 += dp[i][j + 1];
					}
					len = Math.max(len1, len2);
				}
				dp[i][j] = len;
			}
		}
		return dp[0][0];
    }

}

/**
 * Solution 1.1: Memoisation
 */
public class Solution {

	public static int lcs(String s, String t) {
		//Your code goes here
		int[][] dp = new int[s.length()][t.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				dp[i][j] = -1;
			}
		}
		return evaluate(0, 0, dp, s, t);
    }

	private static int evaluate(int i, int j, int[][] dp, String s, String t) {
		if (i >= s.length() || j >= t.length()) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int len = 0;
		if (s.charAt(i) == t.charAt(j)) {
			len = 1 + evaluate(i + 1, j + 1, dp, s, t);
		} else {
			int len1 = evaluate(i + 1, j, dp, s, t);
			int len2 = evaluate(i, j + 1, dp, s, t);
			len = Math.max(len1, len2);
		}
		dp[i][j] = len;
		return len;
	}

}