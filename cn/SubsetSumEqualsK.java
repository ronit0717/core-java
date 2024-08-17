/**
 * Solution 1.3: Tabulation space optimised
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[] dp = new boolean[k + 1];
        boolean[] prev = new boolean[k + 1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < dp.length; j++) {
                prev[j] = dp[j];
            }
            for (int t = 0; t <= k; t++) {
                if (t == 0) {
                    dp[t] = true;
                    continue;
                }
                if (i == (n-1)) { //last index
                    if (arr[i] == t) {
                        dp[t] = true;
                    }
                } else {
                    boolean notPick = prev[t];
                    boolean pick = false;
                    if (arr[i] < t) {
                        pick = prev[t - arr[i]];
                    } else if (arr[i] == t) {
                        pick = true;
                    }
                    dp[t] = notPick || pick;
                }
            }
        }
        return dp[k];
    }
}

/**
 * Solution 1.2: Tabulation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = n-1; i >= 0; i--) {
            for (int t = 0; t <= k; t++) {
                if (t == 0) {
                    dp[i][t] = true;
                    continue;
                }
                if (i == (n-1)) { //last index
                    if (arr[i] == t) {
                        dp[i][t] = true;
                    }
                } else {
                    boolean notPick = dp[i + 1][t];
                    boolean pick = false;
                    if (arr[i] < t) {
                        pick = dp[i+1][t - arr[i]];
                    } else if (arr[i] == t) {
                        pick = true;
                    }
                    dp[i][t] = notPick || pick;
                }
            }
        }
        return dp[0][k];
    }
}

/**
 * Solution 1.1: Memoization
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        evaluate(0, k, arr, dp);
        return dp[0][k] == 1;
    }

    private static boolean evaluate(int index, int target, int[] arr, int[][] dp) {
        if (index >= arr.length) {
            return false;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 1; 
        }
        boolean notPickCase = evaluate(index + 1, target, arr, dp);
        if (notPickCase) {
            dp[index][target] = 1;
            return notPickCase;
        }
        boolean pickCase = false;
        if (arr[index] < target) {
            pickCase = evaluate(index + 1, target - arr[index], arr, dp);
        } else if (arr[index] == target) {
            pickCase = true;
        }
        if (pickCase) {
            dp[index][target] = 1;
        } else {
            dp[index][target] = 0;
        }
        return pickCase;
    }
}