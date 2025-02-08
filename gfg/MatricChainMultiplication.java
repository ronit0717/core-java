/**
 * Solution 2: Tabulation
 * TC = O(N^3), SC=O(N^2)
 * 
 * Further space optimisation not possible.. as we need dp[k + 1][j] value
 */
class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int[][] dp = new int[arr.length][arr.length];
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = i; j < arr.length; j++) { //approach smaller sub problem first
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                int minOps = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int ops = arr[i - 1] * arr[k] * arr[j];
                    ops += dp[i][k];
                    ops += dp[k + 1][j];
                    minOps = Math.min(ops, minOps);
                }
                dp[i][j] = minOps;
            }
        }
        return dp[1][arr.length - 1];
    }
}

/**
 * Solution 1: Memoisation
 * TC = O(N^3), SC=O(N^2) + O(N) auxillary space
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