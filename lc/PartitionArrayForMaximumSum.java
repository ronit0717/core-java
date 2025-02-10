/**
 * Solution 2: Tabulation
 * TC = O(N*K), SC = O(N) + O(N) of auxillary stack space
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxSum = Integer.MIN_VALUE;
            int localMax = Integer.MIN_VALUE;
            for (int j = i; j < arr.length; j++) {
                int len = j - i + 1;
                if (len > k) {
                    break;
                }
                localMax = Math.max(localMax, arr[j]);
                int sum = localMax * len + (j == arr.length - 1 ? 0 : dp[j + 1]);
                maxSum = Math.max(maxSum, sum);
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }
}

/**
 * Solution 1: Memoisation
 * TC = O(N*K), SC = O(N) + O(N) of auxillary stack space
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = -1;
        }
        return calculate(0, arr, k, dp);
    }

    private int calculate(int i, int[] arr, int k, int[] dp) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int maxSum = Integer.MIN_VALUE;
        int localMax = Integer.MIN_VALUE;
        for (int j = i; j < arr.length; j++) {
            int len = j - i + 1;
            if (len > k) {
                break;
            }
            localMax = Math.max(localMax, arr[j]);
            int sum = localMax * len + calculate(j + 1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }
        dp[i] = maxSum;
        return maxSum;
    }
}