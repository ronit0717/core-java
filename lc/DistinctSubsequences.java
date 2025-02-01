/**
 * Solution 4: Tabulation space optimised with single 1D DP array
 */
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = 0; j <= n; j++) { //reverse direction
                if (j == n) {
                    dp[j] = 1;
                } else if (i == m) {
                    dp[j] = 0;
                } else if (s.charAt(i) == t.charAt(j)) {
                    dp[j] = dp[j + 1] + dp[j];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[0];
    }    
}

/**
 * Solution 3: Tabulation Space Optimised
 */
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];
        for (int i = m; i >= 0; i--) {
            for (int k = 0; k <= n; k++) {
                prev[k] = dp[k];
            }
            for (int j = n; j >=0; j--) {
                if (j == n) {
                    dp[j] = 1;
                } else if (i == m) {
                    dp[j] = 0;
                } else if (s.charAt(i) == t.charAt(j)) {
                    dp[j] = prev[j + 1] + prev[j];
                } else {
                    dp[j] = prev[j];
                }
            }
        }
        return dp[0];
    }    
}

/**
 * Solution 2: Tabulation
 */
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >=0; j--) {
                if (j == n) {
                    dp[i][j] = 1;
                } else if (i == m) {
                    dp[i][j] = 0;
                } else if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }    
}

/**
 * Solution: 1 Memoisation
 */
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(0, 0, s, t, dp);
    }

    private int evaluate(int i, int j, String s, String t, int[][] dp) {
        if (j == t.length()) {
            return 1;
        } else if (i == s.length()) {
            return 0;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            int pick = evaluate(i + 1, j + 1, s , t, dp);
            int notPick = evaluate(i + 1, j, s, t, dp);
            result = pick + notPick;
        } else {
            result = evaluate(i + 1, j, s, t, dp);
        }
        dp[i][j] = result;
        return result;
    }
}