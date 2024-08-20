/**
 * Solution 1.3: Tabulation space optimisation
 */
import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int[] dp = new int[tar + 1];
        int[] prev = new int[tar + 1];
        for (int i = num.length - 1; i >= 0; i--) {
            for (int j = 0; j < dp.length; j++) {
                prev[j] = dp[j];
            }
            for (int t = 0; t <= tar; t++) {
                int count = 0;
                if (i == num.length - 1) {
                    if (t == 0 && num[i] == 0) {
                        count = 2; //pick and not pick -> 2 possibilities
                    } else if (t == 0 || t == num[i]) {
                        count = 1;
                    } else {
                        count = 0;
                    }
                } else {
                    count += prev[t]; //not pick
                    if (num[i] <= t) {
                        count+= prev[t - num[i]]; //pick case
                    }
                }
                dp[t] = count % 1000000007;
            }
        }
        return dp[tar];
    }
}

/**
 * Solution 1.2: Tabulation
 */
import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int[][] dp = new int[num.length][tar + 1];
        for (int i = num.length - 1; i >= 0; i--) {
            for (int t = 0; t <= tar; t++) {
                int count = 0;
                if (i == num.length - 1) {
                    if (t == 0 && num[i] == 0) {
                        count = 2; //pick and not pick -> 2 possibilities
                    } else if (t == 0 || t == num[i]) {
                        count = 1;
                    } else {
                        count = 0;
                    }
                } else {
                    count += dp[i + 1][t]; //not pick
                    if (num[i] <= t) {
                        count+= dp[i + 1][t - num[i]]; //pick case
                    }
                }
                dp[i][t] = count % 1000000007;
            }
        }
        return dp[0][tar];
    }
}

/**
 * Solution 1.1: Memoisation
 */
import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int[][] dp = new int[num.length][tar + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(0, num, tar, dp);
    }

    private static int evaluate(int index, int[] nums, int tar, int[][] dp) {
        if (dp[index][tar] != -1) {
            return dp[index][tar];
        }
        int count = 0;
        if (index == nums.length - 1) {
            if (tar == 0 && nums[index] == 0) {
                count = 2; //pick and not pick two possibilities
            } else if (tar == 0 || tar == nums[index]) {
                count = 1;
            } else {
                count = 0;
            }
            dp[index][tar] = count;
            return count;
        }
        
        count += evaluate(index + 1, nums, tar, dp); //not pick
        if (nums[index] <= tar) {
            count += evaluate(index + 1, nums, tar - nums[index], dp);
        }
        int large = 1000000007;
        count = count % large;
        dp[index][tar] = count ;
        return count;
    }
}