/**
 * Solution 1.3: Tabulation with space optimisation
 */
import java.util.Arrays;

public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here		
		long[] dp = new long[1 + value];
		long[] prev = new long[1 + value];
		for (int i = denominations.length - 1; i >= 0; i--) {
			for (int j = 0; j < dp.length; j++) {
				prev[j] = dp[j];
			}
			for (int t = 0; t <= value; t++) {
				long count = 0L;
				int coin = denominations[i];
				if (i == denominations.length - 1) {
					if (t == 0 || ((coin <= t) && (t % coin == 0))) {
						count = 1L;
					}
				} else {
					count += prev[t]; //Not pick case
					if (coin <= t) {
						count += dp[t - coin];
					}
				}
				dp[t] = count;
			}
		}
		return dp[value];
	}
	
}

/**
 * Solution 1.2: Tabulation
 */
import java.util.Arrays;

public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here		
		long[][] dp = new long[denominations.length][1 + value];
		for (int i = denominations.length - 1; i >= 0; i--) {
			for (int t = 0; t <= value; t++) {
				long count = 0L;
				int coin = denominations[i];
				if (i == denominations.length - 1) {
					if (t == 0 || ((coin <= t) && (t % coin == 0))) {
						count = 1L;
					}
				} else {
					count += dp[i + 1][t]; //Not pick case
					if (coin <= t) {
						count += dp[i][t - coin];
					}
				}
				dp[i][t] = count;
			}
		}
		return dp[0][value];
	}
	
}

/**
 * Solution 1.1: Memoization
 */
import java.util.Arrays;

public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        //write your code here		
		int[] coins = new int[denominations.length];
		for (int i = 0; i < denominations.length; i++) {
			coins[i] = denominations[i];
		}	
		Arrays.sort(coins); //Ensures less stack size (recursion)
		long[][] dp = new long[denominations.length][1 + value];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= value; j++) {
				dp[i][j] = -1L;
			}
		}
		return evaluate(denominations.length - 1, value, coins, dp);
	}

	private static long evaluate(int index, int target, int[] coins, long[][] dp) {
		if (dp[index][target] != -1L) {
			return dp[index][target];
		}
		long count = 0L;
		if (index == 0) {
			if (target == 0 || (target >= coins[index] && target % coins[index] == 0)) {
				count = 1L;
			}
		} else {
			count += evaluate(index - 1, target, coins, dp); //not pick case
			if (coins[index] <= target) {
				count += evaluate(index, target - coins[index], coins, dp);
			}
		}
		dp[index][target] = count;
		return count;
	}
	
}