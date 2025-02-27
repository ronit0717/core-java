/**
 * TC = O(2 * M * N), SC = O(M * N);
 */
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j]; //first row
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0]; //first column
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 
                    0 : (1 + min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]));
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}