/**
 * Extension of "Count Subsets with Sum K" problem
 * This is the tabulation solution with space optimisation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			totalSum += arr[i];
		}
		int diff = totalSum - d;
		if (diff % 2 != 0 || diff < 0) {
			return 0;
		}
		int tar = diff / 2;

		//Following code same as DP-17 problem (number of subsets with given target)
		int[] dp = new int[tar + 1];
        int[] prev = new int[tar + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < dp.length; j++) {
                prev[j] = dp[j];
            }
            for (int t = 0; t <= tar; t++) {
                int count = 0;
                if (i == n - 1) {
                    if (t == 0 && arr[i] == 0) {
                        count = 2; //pick and not pick -> 2 possibilities
                    } else if (t == 0 || t == arr[i]) {
                        count = 1;
                    } else {
                        count = 0;
                    }
                } else {
                    count += prev[t]; //not pick
                    if (arr[i] <= t) {
                        count+= prev[t - arr[i]]; //pick case
                    }
                }
                dp[t] = count % 1000000007;
            }
        }
        return dp[tar];

	}
}