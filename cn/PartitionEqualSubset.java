/**
 * Problem is an extension of PartitionEqualSubSet problem
 * 
 * This is the tabulation solution with space optimisation
 */
public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum+= arr[i];
		}
		if (sum % 2 != 0) {
			return false; //odd sum
		}
		int target = sum / 2;
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
		return dp[target];
	}
}