/**
 * Problem is an extension of PartitionEqualSubSet problem
 * 
 * This is the tabulation solution with space optimisation
 */
public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int sum = 0;
		for (int i = 0; i < n; i++) {
			sum+= arr[i];
		}
		int target = sum;
		boolean[] dp = new boolean[target + 1];
		boolean[] prev = new boolean[target + 1];
		for (int i = n-1; i >= 0; i--) {
			for (int j = 0; j <= target; j++) {
				prev[j] = dp[j];
			}
			for (int t = 0; t <= target; t++) {
				if (t == 0) {
					dp[t] = true;
					continue;
				}
				if (i == (n-1)) {
					if (arr[i] == t) {
						dp[t] = true;
					} else {
						dp[t] = false;
					}
				} else {
					boolean notPick = prev[t];
					boolean pick = false;
					if (arr[i] == t) {
						pick = true;
					} else if (arr[i] < t) {
						pick = prev[t - arr[i]];
					}
					dp[t] = notPick || pick;
				}
			}
		}

        //The dp array gives us the data if a particular target can be acheived by the subsequence or not
        int minDelta = sum;
        for (int t = 0; t <= sum/2; t++) {
            int sum1 = dp[t] ? t : 0;
            int sum2 = sum - sum1;
            int delta = Math.abs(sum2 - sum1);
            minDelta = Math.min(minDelta, delta);
        }
        return minDelta;
    }
}