/**
 * Solution 1.3: Tabulation with space optimisation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int[] dp = new int[x + 1];
        int[] prev = new int[x + 1];
        for (int i = num.length - 1; i >= 0; i--) {
            for (int j = 0; j < dp.length; j++) {
                prev[j] = dp[j];
            }
            for (int t = 0; t <= x; t++) {
                int count = 1000000000;
                if (i == (num.length - 1)) {
                    if (t % num[i] == 0) {
                        count = t / num[i];
                    }
                } else {
                    int notPickCount = prev[t];
                    int pickCount = 1000000000;
                    if (num[i] < t) {
                        pickCount = 1 + dp[t - num[i]];
                    } else if (num[i] == t) {
                        pickCount = 1;
                    }
                    count = Math.min(pickCount, notPickCount);
                }
                dp[t] = count; 
            }
        }
        return (dp[x] >= 1000000000) ? -1 : dp[x];
    }
}

/**
 * Solution 1.2: Tabulation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int[][] dp = new int[num.length][x + 1];
        for (int i = num.length - 1; i >= 0; i--) {
            for (int t = 0; t <= x; t++) {
                int count = 1000000000;
                if (i == (num.length - 1)) {
                    if (t % num[i] == 0) {
                        count = t / num[i];
                    }
                } else {
                    int notPickCount = dp[i + 1][t];
                    int pickCount = 1000000000;
                    if (num[i] < t) {
                        pickCount = 1 + dp[i][t - num[i]];
                    } else if (num[i] == t) {
                        pickCount = 1;
                    }
                    count = Math.min(pickCount, notPickCount);
                }
                dp[i][t] = count; 
            }
        }
        return (dp[0][x] >= 1000000000) ? -1 : dp[0][x];
    }
}


/**
 * Solution 1.1: Memoisation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int[][] dp = new int[num.length][x + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= x; j++) {
                dp[i][j] = -1;
            }
        }
        int count = evaluate(num.length - 1, x, num, dp);
        if (count >= 1000000) {
            return -1;
        }
        return count;
    }

    private static int evaluate(int index, int target, int nums[], int[][] dp) {
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int count = 1000000;
        if (index == 0) {
            if (target % (nums[index]) == 0) {
                count = target / nums[index];
            }   
        } else {
            int notPickCount = evaluate(index - 1, target, nums, dp);
            int pickCount = 1000000;
            if (nums[index] < target) {
                pickCount = 1 + evaluate(index, (target - nums[index]), nums, dp);
            } else if (nums[index] == target) {
                pickCount = 1;
            }
            count = Math.min(notPickCount, pickCount);
        }
        dp[index][target] = count;
        return count;
    }
}