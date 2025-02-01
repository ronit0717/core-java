//Longest Common Substring

/**
 * Solution 3: Single DP array
 */
public class Solution {
    public static int lcs(String str1, String str2){
        // Write your code here.
        int m = str1.length();
        int n = str2.length();
        int[] dp = new int[n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) { //right to left iteration
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[j] = 1 + ((i > 0 && j > 0) ? dp[j - 1] : 0);
                    maxLength = Math.max(maxLength, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return maxLength;
    }
}

/**
 * Solution 2: Space optimised (dp and prev 1D array)
 */
public class Solution {
    public static int lcs(String str1, String str2){
        // Write your code here.
        int m = str1.length();
        int n = str2.length();
        int[] dp = new int[n];
        int[] prev = new int[n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                prev[k] = dp[k];
            }
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[j] = 1 + ((i > 0 && j > 0) ? prev[j - 1] : 0);
                    maxLength = Math.max(maxLength, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return maxLength;
    }
}


/**
 * Solution 1
 */
public class Solution {
    public static int lcs(String str1, String str2){
        // Write your code here.
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + ((i > 0 && j > 0) ? dp[i - 1][j - 1] : 0);
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }
}