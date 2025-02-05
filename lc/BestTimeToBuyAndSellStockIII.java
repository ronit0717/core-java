/**
 * Solution 3: Tabulation space optimised
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[5];
        int[] prev = new int[5];
        for (int i = prices.length; i >= 0 ; i--) {
            for (int k = 0; k <= 4; k++) {
                prev[k] = dp[k];
            }
            for (int j = 4; j >= 0; j--) {
                if (i == prices.length || j == 4) {
                    dp[j] = 0;
                    continue;
                }
                int choice1 = prices[i] * (j % 2 == 0 ? -1 : 1) + prev[j + 1];
                int choice2 =prev[j]; //skip case
                dp[j] = Math.max(choice1, choice2);
            }
        }
        return dp[0];
    }
}

/**
 * Solution 2 : Tabulation
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][5];
        for (int i = prices.length; i >= 0 ; i--) {
            for (int j = 4; j >= 0; j--) {
                if (i == prices.length || j == 4) {
                    dp[i][j] = 0;
                    continue;
                }
                int choice1 = prices[i] * (j % 2 == 0 ? -1 : 1) + dp[i + 1][j + 1];
                int choice2 = dp[i + 1][j]; //skip case
                dp[i][j] = Math.max(choice1, choice2);
            }
        }
        return dp[0][0];
    }
}

/**
 * Solution 1 : Memoisation
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(0, 0, dp, prices);
    }

    private int evaluate(int i, int j, int[][] dp, int[] prices) {
        if (i >= prices.length || j >= 4) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        //j is even -> buy, j is odd -> sell
        int choice1 = prices[i] * (j % 2 == 0 ? -1 : 1) + evaluate(i + 1, j + 1, dp, prices);
        int choice2 = evaluate(i + 1, j, dp, prices); //skip
        int profit = Math.max(choice1, choice2);
        dp[i][j] = profit;
        return profit;
    }
}