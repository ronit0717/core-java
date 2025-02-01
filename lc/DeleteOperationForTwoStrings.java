/**
 * Solution 2: Space optimised
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n];
        int[] prev = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int k = 0; k < n; k++) {
                prev[k] = dp[k];
            }
            for (int j = n - 1; j >= 0; j--) {
                int lcs = 0; //lcs length
                if (word1.charAt(i) == word2.charAt(j)) {
                    lcs = 1;
                    if (i != m - 1 && j != n - 1) {
                        lcs += prev[j + 1];
                    }
                } else if (i != m - 1 || j != n - 1) {
                    int lcs1 = (i != m - 1) ? prev[j] : 0;
                    int lcs2 = (j != n - 1) ? dp[j + 1] : 0;
                    lcs = Math.max(lcs1, lcs2);
                }
                dp[j] = lcs;
            }
        }
        return (m - dp[0]) + (n - dp[0]);
    }
}

/**
 * Solution 1
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int lcs = 0; //lcs length
                if (word1.charAt(i) == word2.charAt(j)) {
                    lcs = 1;
                    if (i != m - 1 && j != n - 1) {
                        lcs += dp[i + 1][j + 1];
                    }
                } else if (i != m - 1 || j != n - 1) {
                    int lcs1 = (i != m - 1) ? dp[i + 1][j] : 0;
                    int lcs2 = (j != n - 1) ? dp[i][j + 1] : 0;
                    lcs = Math.max(lcs1, lcs2);
                }
                dp[i][j] = lcs;
            }
        }
        return (m - dp[0][0]) + (n - dp[0][0]);
    }
}