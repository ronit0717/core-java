/**
 * Solution 3: Tabulation with space optimisation (Fastest Solution on Leetcode : beats 100%)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        int[] prev = new int[2];
        int[] prev2 = new int[2];
        for (int i = prices.length + 1; i >= 0 ; i--) {
            for (int k = 0; k < 2; k++) {
                prev2[k] = prev[k];
                prev[k] = dp[k];
            }
            for (int j = 1; j >= 0; j--) {
                if (i >= prices.length) {
                    dp[j] = 0;
                    continue;
                }
                int choice1 = 0;
                if (j == 1) { //Buy
                    choice1 = prices[i] * -1 + prev[0];
                } else { //Sell
                    choice1 = prices[i] + prev2[1];
                }
                int choice2 = prev[j]; //skip case
                dp[j] = Math.max(choice1, choice2);
            }
        }
        return dp[1];
    }
}

/**
 * Solution 2 : Tabulation
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2]; //+2 index
        for (int i = prices.length + 1; i >= 0 ; i--) {
            for (int j = 1; j >= 0; j--) {
                if (i >= prices.length) {
                    dp[i][j] = 0;
                    continue;
                }
                int choice1 = 0;
                if (j == 1) {
                    choice1 = prices[i] * -1 + dp[i + 1][0];
                } else {
                    choice1 = prices[i] + dp[i + 2][1];
                }
                int choice2 = dp[i + 1][j]; //skip case
                dp[i][j] = Math.max(choice1, choice2);
            }
        }
        return dp[0][1];
    }
}

/**
 * Solution 1 : Memoisation
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
        int choice1 = 0;
        if (isBuy) {
            choice1 = -1 * prices[i] + evaluate(i + 1, !isBuy, dp, prices);
        } else {
            choice1 = prices[i] + evaluate(i + 2, !isBuy, dp, prices);
        }
        int choice2 = evaluate(i + 1, isBuy, dp, prices);
        int profit = Math.max(choice1, choice2);
        dp[i][isBuy ? 1 : 0] = profit;
        return profit;
    }
}