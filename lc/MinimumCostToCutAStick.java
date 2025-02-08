/**
 * Solution 2: Tabulation
 * TC = O(N^3), SC=O(N^2)
 */
class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] cuts2 = new int[cuts.length + 2];
        cuts2[cuts2.length - 1] = n;
        int p = 1;
        for (int i = 0; i < cuts.length; i++) {
            cuts2[p] = cuts[i];
            p++;
        }
        int[][] dp = new int[cuts2.length][cuts2.length];
        for (int i = cuts2.length - 2; i >= 1; i--) {
            for (int j = i; j <= cuts2.length - 2; j++) { //smallest subproblem first
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = cuts2[j + 1] - cuts2[i - 1]; //current cost
                    cost += dp[i][k - 1]; //left cost
                    cost += dp[k + 1][j]; //right cost
                    minCost = Math.min(cost, minCost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][cuts2.length - 2];
    }
}

/**
 * Solution 1: Memoisation
 * TC = O(N^3), SC=O(N^2) + O(N) auxilary space
 */
class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] cuts2 = new int[cuts.length + 2];
        cuts2[cuts2.length - 1] = n;
        int k = 1;
        for (int i = 0; i < cuts.length; i++) {
            cuts2[k] = cuts[i];
            k++;
        }
        int[][] dp = new int[cuts2.length][cuts2.length];
        for (int i = 0; i < cuts2.length; i++) {
            for (int j = 0; j < cuts2.length; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(1, cuts2.length - 2, cuts2, dp);
    }

    private int evaluate(int i, int j, int[] cuts2, int[][] dp) {
        if (j < i) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts2[j + 1] - cuts2[i - 1]; //current cost
            cost += evaluate(i, k - 1, cuts2, dp); //left cost
            cost += evaluate(k + 1, j, cuts2, dp); //right cost
            minCost = Math.min(cost, minCost);
        }
        dp[i][j] = minCost;
        return minCost;
    }
}