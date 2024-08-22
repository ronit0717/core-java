/**
 * This is same as Partition with given difference problem.
 * 
 * Here is the tabulation solution, with space optimisation.
 */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int targetSum(int n, int target, int[] arr) {
    	int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int diff = sum - target;
        if (diff % 2 != 0 || diff < 0) {
            return 0;
        }
        int subTarget = diff / 2;
        int[] dp = new int[subTarget + 1];
        int[] prev = new int[subTarget + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < dp.length; j++) {
                prev[j] = dp[j];
            }
            for (int t = 0; t <= subTarget; t++) {
                int count = 0;
                if (i == n - 1) {
                    if (t == 0 || arr[i] == t) {
                        count = 1;
                    }
                } else {
                    count += prev[t]; //not pick case
                    if (arr[i] <= t) {
                        count += prev[t - arr[i]];
                    }
                }
                dp[t] = count;
            }
        }
        return dp[subTarget];
    }
}