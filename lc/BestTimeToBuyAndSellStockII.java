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