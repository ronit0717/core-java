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
            for (int k = 0; k < dp.length; k++) {
                prev[k] = dp[k];
            }
            for (int j = 0; j <= tar; j++) {
                if (j == 0) {
                    dp[j] = 1;
                    continue;
                }
                int count = 0;
                int large = 1000000007;
                if (i == num.length - 1) {
                    if (num[i] == j) {
                        count += 1;
                    }
                } else {
                    count += prev[j]; //not pick case
                    if (num[i] < j) {
                        count = (count % large + (prev[j - num[i]] % large)) % large;
                    } else if (num[i] == j) {
                        count += 1;
                    }
                }
                dp[j] = count % large;
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
            for (int j = 0; j <= tar; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int count = 0;
                int large = 1000000007;
                if (i == num.length - 1) {
                    if (num[i] == j) {
                        count += 1;
                    }
                } else {
                    count += dp[i + 1][j]; //not pick case
                    if (num[i] < j) {
                        count = (count % large + (dp[i + 1][j - num[i]] % large)) % large;
                    } else if (num[i] == j) {
                        count += 1;
                    }
                }
                dp[i][j] = count % large;
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
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index][tar] != -1) {
            return dp[index][tar];
        }
        if (tar == 0) {
            dp[index][tar] = 1;
            return 1;
        }
        int count = 0;
        int large = 1000000007;
        count += evaluate(index + 1, nums, tar, dp) % large; //not pick
        if (nums[index] < tar) {
            count = ((count % large) + (evaluate(index + 1, nums, tar - nums[index], dp) % large)) % large;
        } else if (nums[index] == tar) {
            count = (count % large + 1 % large) % large;
        }
        dp[index][tar] = count;
        return count;
    }
}