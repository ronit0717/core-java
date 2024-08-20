/**
 * Solution 1.4: Tabulation with space optimisation (no prev array used) 
 */
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */
            int[] dp = new int[maxWeight + 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int w = maxWeight; w >= 0; w--) {
                    int pickVal = 0;
                    int notPickVal = 0;
                    if (i != n - 1) {
                        notPickVal = dp[w];
                        if (weight[i] <= w) {
                            pickVal = value[i] + dp[w - weight[i]];
                        }
                    } else {
                        //last index case. not pick is not an option
                        if (weight[i] <= w) {
                            pickVal = value[i];
                        }
                    }
                    
                    dp[w] = Math.max(pickVal, notPickVal);
                }
            }
            return dp[maxWeight];
    }
}

/**
 * Solution 1.3: Tabulation with space optimisation
 */
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */
            int[] dp = new int[maxWeight + 1];
            int[] prev = new int[maxWeight + 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < dp.length; j++) {
                    prev[j] = dp[j];
                }
                for (int w = 0; w <= maxWeight; w++) {
                    int pickVal = 0;
                    int notPickVal = 0;
                    if (i != n - 1) {
                        notPickVal = prev[w];
                        if (weight[i] <= w) {
                            pickVal = value[i] + prev[w - weight[i]];
                        }
                    } else {
                        //last index case. not pick is not an option
                        if (weight[i] <= w) {
                            pickVal = value[i];
                        }
                    }
                    
                    dp[w] = Math.max(pickVal, notPickVal);
                }
            }
            return dp[maxWeight];
    }
}

/**
 * Solution 1.2: Tabulation
 */
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */
            Integer[][] dp = new Integer[n][maxWeight + 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int w = 0; w <= maxWeight; w++) {
                    int pickVal = 0;
                    int notPickVal = 0;
                    if (i != n - 1) {
                        notPickVal = dp[i + 1][w];
                        if (weight[i] <= w) {
                            pickVal = value[i] + dp[i + 1][w - weight[i]];
                        }
                    } else {
                        //last index case. not pick is not an option
                        if (weight[i] <= w) {
                            pickVal = value[i];
                        }
                    }
                    
                    dp[i][w] = Math.max(pickVal, notPickVal);
                }
            }
            return dp[0][maxWeight];
    }
}

/**
 * Solution 1.1: Memoisation
 */
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            /* Your class should be named Solution
            * Don't write main().
            * Don't read input, it is passed as function argument.
            * Change in the given tree itself.
            * No need to return or print the output.
            * Taking input and printing output is handled automatically.
            */
            Integer[][] dp = new Integer[n][maxWeight + 1];
            return evaluate(0, maxWeight, weight, value, dp);

    }

    private static int evaluate(int index, int maxWeight, int[] weight, int[] value, Integer[][] dp) {
        if (index >= weight.length) {
            return 0;
        }
        if (dp[index][maxWeight] != null) {
            return dp[index][maxWeight];
        }
        int pickValue = 0;
        int notPickValue = 0;
        if (index != weight.length - 1) {
            //for last index, not pick not an option if weight condition satisfied
            notPickValue = evaluate(index + 1, maxWeight, weight, value, dp);
        }
        if (weight[index] <= maxWeight) {
            pickValue = value[index] + evaluate(index + 1 , maxWeight - weight[index], weight, value, dp);
        }
        int result = Math.max(pickValue, notPickValue);
        dp[index][maxWeight] = result;
        return result;
    }
}