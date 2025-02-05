/**
 * Solution 3: Tabulation space optimised 1DP DP
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        int[] prev = new int[2];
        for (int i = prices.length; i >= 0 ; i--) {
            for (int k = 0; k <= 1; k++) {
                prev[k] = dp[k];
            }
            for (int j = 1; j >= 0; j--) {
                if (i == prices.length) {
                    dp[j] = 0;
                    continue;
                }
                int choice1 = prices[i] * (j == 0 ? 1 : -1) + prev[j == 0 ? 1 : 0];
                int choice2 = prev[j]; //skip case
                dp[j] = Math.max(choice1, choice2);
            }
        }
        return dp[1];
    }
}

/**
 * Solution 2: Tabulation with 2D DP
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int i = prices.length; i >= 0 ; i--) {
            for (int j = 1; j >= 0; j--) {
                if (i == prices.length) {
                    dp[i][j] = 0;
                    continue;
                }
                int choice1 = prices[i] * (j == 0 ? 1 : -1) + dp[i + 1][j == 0 ? 1 : 0];
                int choice2 = dp[i + 1][j]; //skip case
                dp[i][j] = Math.max(choice1, choice2);
            }
        }
        return dp[0][1];
    }
}

/**
 * Solution 1: Memoisation
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(0, true, dp, prices);
    }

    private int evaluate(int i, boolean isBuy, int[][] dp, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][isBuy ? 1 : 0] != -1) {
            return dp[i][isBuy ? 1 : 0];
        }
        int choice1 = prices[i] * (isBuy ? -1 : 1) + evaluate(i + 1, !isBuy, dp, prices);
        int choice2 = evaluate(i + 1, isBuy, dp, prices);
        int profit = Math.max(choice1, choice2);
        dp[i][isBuy ? 1 : 0] = profit;
        return profit;
    }
}