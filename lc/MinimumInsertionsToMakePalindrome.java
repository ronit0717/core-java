/**
 * Solution 2: Space optimsed (2 1D arrays DP and Prev)
 */
class Solution {
    public int minInsertions(String s) {
        String rev = reverse(s);
        int len = s.length();
        int[] dp = new int[len];
        int[] prev = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            for (int k = 0; k < len; k++) {
                prev[k] = dp[k];
            }
            for (int j = len - 1; j >= 0; j--) {
                int lcs = 0;
                if (s.charAt(i) == rev.charAt(j)) {
                    lcs = 1;
                    if (i != len - 1 && j != len - 1) {
                        lcs += prev[j + 1];
                    }
                } else if (i != len - 1 || j != len - 1) {
                    int lcs1 = (i != len - 1) ? prev[j] : 0;
                    int lcs2 = (j != len - 1) ? dp[j + 1] : 0;
                    lcs = Math.max(lcs1, lcs2);
                }
                dp[j] = lcs;
            }
        }
        return len - dp[0]; //string length - LCS length
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

/**
 * Soltion 1
 */
class Solution {
    public int minInsertions(String s) {
        String rev = reverse(s);
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                int lcs = 0;
                if (s.charAt(i) == rev.charAt(j)) {
                    lcs = 1;
                    if (i != len - 1 && j != len - 1) {
                        lcs += dp[i + 1][j + 1];
                    }
                } else if (i != len - 1 || j != len - 1) {
                    int lcs1 = (i != len - 1) ? dp[i + 1][j] : 0;
                    int lcs2 = (j != len - 1) ? dp[i][j + 1] : 0;
                    lcs = Math.max(lcs1, lcs2);
                }
                dp[i][j] = lcs;
            }
        }
        return len - dp[0][0]; //string length - LCS length
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}