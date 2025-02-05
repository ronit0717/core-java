/**
 * Solution 3: Tabulation with space optimisation
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2]; //+1 index
        int[] prev = new int[2];
        for (int i = prices.length; i >= 0 ; i--) {
            for (int k = 0; k < 2; k++) {
                prev[k] = dp[k];
            }
            for (int j = 1; j >= 0; j--) {
                if (i >= prices.length) {
                    dp[j] = 0;
                    continue;
                }
                int choice1 = 0;
                if (j == 1) { //buy
                    choice1 = prices[i] * -1 + prev[0];
                } else { //sell
                    choice1 = prices[i] + prev[1] - fee; //Reduced transaction fee
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
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2]; //+1 index
        for (int i = prices.length; i >= 0 ; i--) {
            for (int j = 1; j >= 0; j--) {
                if (i >= prices.length) {
                    dp[i][j] = 0;
                    continue;
                }
                int choice1 = 0;
                if (j == 1) { //buy
                    choice1 = prices[i] * -1 + dp[i + 1][0];
                } else { //sell
                    choice1 = prices[i] + dp[i + 1][1] - fee; //Reduced transaction fee
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
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(0, true, dp, prices, fee);
    }

    private int evaluate(int i, boolean isBuy, int[][] dp, int[] prices, int fee) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][isBuy ? 1 : 0] != -1) {
            return dp[i][isBuy ? 1 : 0];
        }
        int choice1 = 0;
        if (isBuy) {
            choice1 = -1 * prices[i] + evaluate(i + 1, !isBuy, dp, prices, fee);
        } else {
            choice1 = prices[i] + evaluate(i + 1, !isBuy, dp, prices, fee) - fee; //fee reduced after transaction
        }
        int choice2 = evaluate(i + 1, isBuy, dp, prices, fee);
        int profit = Math.max(choice1, choice2);
        dp[i][isBuy ? 1 : 0] = profit;
        return profit;
    }
}