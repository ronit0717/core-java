/**
 * Solution 3: Tabulation space optimised
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];
        for (int i = m; i >= 0; i--) {
            for (int k = 0; k <= n; k++) {
                prev[k] = dp[k];
            }
            for (int j = n; j >= 0; j--) {
                int dist = 0;
                if (i == m) {
                    dist = n - j;
                } else if (j == n) {
                    dist = m - i;
                } else if (word1.charAt(i) == word2.charAt(j)) {
                    dist = prev[j + 1];
                } else {
                    int replace = prev[j + 1];
                    int delete = prev[j];
                    int insert = dp[j + 1];
                    dist = 1 + min(replace, delete, insert);
                }
                dp[j] = dist;
            }
        }
        return dp[0];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

/**
 * Solution 2: Tabulation
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                int dist = 0;
                if (i == m) {
                    dist = n - j;
                } else if (j == n) {
                    dist = m - i;
                } else if (word1.charAt(i) == word2.charAt(j)) {
                    dist = dp[i + 1][j + 1];
                } else {
                    int replace = dp[i + 1][j + 1];
                    int delete = dp[i + 1][j];
                    int insert = dp[i][j + 1];
                    dist = 1 + min(replace, delete, insert);
                }
                dp[i][j] = dist;
            }
        }
        return dp[0][0];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

/**
 * Solution 1: Memoisation
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(0, 0, word1, word2, dp);
    }

    private int evaluate(int i, int j, String word1, String word2, int[][] dp) {
        int m = word1.length();
        int n = word2.length();
        if (i == m) {
            return n - j;
        } else if (j == n) {
            return m - i;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int dist = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            dist = evaluate(i + 1, j + 1, word1, word2, dp);
        } else {
            int replace = evaluate(i + 1, j + 1, word1, word2, dp);
            int delete = evaluate(i + 1, j, word1, word2, dp);
            int insert = evaluate(i, j + 1, word1, word2, dp);
            dist = 1 + min(replace, delete, insert);
        }
        dp[i][j] = dist;
        return dist;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}