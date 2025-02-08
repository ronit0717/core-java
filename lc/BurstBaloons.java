/**
 * Solution 2: Tabulation
 * TC = O(N^3), SC = O(N^2)
 */
class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1; //first index
        arr[arr.length - 1] = 1; //last index
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[p] = nums[i];
            p++;
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int i = arr.length - 2; i >= 1; i--) {
            for (int j = i; j <= arr.length - 2; j++) { //smallest subproblem first
                int maxCost = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = arr[i - 1] * arr[k] * arr[j + 1];
                    cost += dp[i][k - 1]; //left cost
                    cost += dp[k + 1][j]; //right cost
                    maxCost = Math.max(cost, maxCost);
                }
                dp[i][j] = maxCost;
            }
        }
        return dp[1][arr.length - 2];
    }
}

/**
 * Solution 1: Memoisation
 * TC = O(N^3), SC = O(N^2) + O(N) Auxilary Stack Space
 */
class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1; //first index
        arr[arr.length - 1] = 1; //last index
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[p] = nums[i];
            p++;
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j] = -1;
            }
        }
        return calculate(1, arr.length - 2, arr, dp);
    }

    private int calculate(int i, int j, int[] arr, int[][] dp) {
        if (j < i) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int maxCost = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = arr[i - 1] * arr[k] * arr[j + 1];
            cost += calculate(i, k - 1, arr, dp); //left cost
            cost += calculate(k + 1, j, arr, dp); //right cost
            maxCost = Math.max(cost, maxCost);
        }
        dp[i][j] = maxCost;
        return maxCost;
    }
}