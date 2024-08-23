/**
 * Solution 1.3: Tabulation with space optimisation
 */
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[] dp = new int[w + 1];
        int[] prev = new int[w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dp.length; j++) {
                prev[j] = dp[j];
            }
            for (int t = 0; t <= w; t++) {
                int money = 0;
                if (i == 0) {
                    money = (t / weight[i]) * profit[i];
                } else {
                    int notPick = prev[t];
                    int pick = -1;
                    if (weight[i] <= t) {
                        pick = profit[i] + dp[t - weight[i]];
                    }
                    money = Math.max(notPick, pick);
                }
                dp[t] = money;
            }
        }
        return dp[w];
    }
}

/**
 * Solution 1.2: Tabulation
 */
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int t = 0; t <= w; t++) {
                int money = 0;
                if (i == 0) {
                    money = (t / weight[i]) * profit[i];
                } else {
                    int notPick = dp[i - 1][t];
                    int pick = -1;
                    if (weight[i] <= t) {
                        pick = profit[i] + dp[i][t - weight[i]];
                    }
                    money = Math.max(notPick, pick);
                }
                dp[i][t] = money;
            }
        }
        return dp[n - 1][w];
    }
}

/**
 * Solution 1.1: Memoisation
 */
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(n - 1, w, profit, weight, dp);
    }

    private static int evaluate(int index, int w, int[] profit, int[] weight, int[][] dp) {
        int money = 0;
        if (dp[index][w] != -1) {
            return dp[index][w];
        }
        if (index == 0) {
            money = (w / weight[0]) * profit[0];
        } else {
            int notPick = evaluate(index - 1, w, profit, weight, dp);
            int pick = -1;
            if (weight[index] <= w) {
                pick = profit[index] + evaluate(index, w - weight[index], profit, weight, dp);
            }
            money = Math.max(notPick, pick);
        }
        dp[index][w] = money;
        return money;
    }
}