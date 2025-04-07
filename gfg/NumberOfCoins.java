//Problem link: https://www.geeksforgeeks.org/problems/number-of-coins1824/1

//Solution 3: Tabulation space optimised
class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int[] dp = new int[sum + 1];
        int[] prev = new int[sum + 1];
        Arrays.sort(coins);
        int large = 100000000;
        for (int i = 0; i <= coins.length; i++) {
            for (int k = 0; k <= sum; k++) {
                prev[k] = dp[k];
            }
            for (int j = 0; j <= sum; j++) {
                
                if (i == 0) {
                    dp[j] = large;
                    continue;
                }
                if (j == 0) {
                    dp[j] = 0;
                    continue;
                }
                
                int price = coins[i - 1];
                if (j < price) {
                    dp[j] = prev[j];
                } else {
                    int pick = 1 + dp[j - price];
                    int notPick = prev[j];
                    dp[j] = Math.min(pick, notPick);
                }
            }
        }
        return dp[sum] >= large ? - 1 : dp[sum];
    }
    
}


//Solution 2: Tabulation
class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int[][] dp = new int[coins.length + 1][sum + 1];
        Arrays.sort(coins);
        int large = 100000000;
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    dp[i][j] = large;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int price = coins[i - 1];
                if (j < price) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int pick = 1 + dp[i][j - price];
                    int notPick = dp[i - 1][j];
                    dp[i][j] = Math.min(pick, notPick);
                }
            }
        }
        return dp[coins.length][sum] == large ? - 1 : dp[coins.length][sum];
    }
    
}

//Solution 1: Memoisation
class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int[][] dp = new int[coins.length][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        Arrays.sort(coins);
        int count = getCount(coins.length - 1, sum, coins, dp);
        if (count >= 100000000) {
            return -1;
        }
        return count;
    }
    
    private int getCount(int index, int sum, int[] coins, int[][] dp) {
        if (sum == 0) {
            return 0;
        }
        if (index < 0) {
            return 100000000; //large num
        }
        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }
        int count = 0;
        if (sum < coins[index]) {
            count = getCount(index - 1, sum, coins, dp);
        } else {
            int pick = 1 + getCount(index, sum - coins[index], coins, dp);
            int notPick = getCount(index - 1, sum, coins, dp);
            count = Math.min(pick, notPick);
        }
        dp[index][sum] = count;
        return count;
    }
}