//Longest Common Substring
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