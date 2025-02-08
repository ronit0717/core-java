/**
 * Solution 1: Memoisation
 */
class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(1, arr.length - 1, dp, arr);
    }
    
    static int evaluate(int i, int j, int[][] dp, int[] arr) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minOps = Integer.MAX_VALUE;
        for (int k = i; k < j; k ++) {
            int ops = arr[i - 1] * arr[k] * arr[j];
            ops += evaluate(i, k, dp, arr);
            ops += evaluate(k + 1, j, dp, arr);
            minOps = Math.min(ops, minOps);
        }
        dp[i][j] = minOps;
        return minOps;
    }
}