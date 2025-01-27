/**
 * Solution 1.3: Tabulation space optimised
 */
import java.util.* ;

import java.io.*; 
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int prev = -1;
		int prev2 = -1;
		for (int i = nums.size() - 1; i >= 0; i--) {
			if (i == nums.size() - 1) {
				prev = nums.get(i);
			} else if (i == nums.size() - 2) {
				int sum = Math.max(prev, nums.get(i)); //Either current element will be picked or last element
				prev2 = prev;
				prev = sum;
			} else {
				int sum = Math.max((nums.get(i) + prev2), prev);
				prev2 = prev;
				prev = sum;
			}
		}
		return prev;
	}
}

/**
 * Solution 1.2: Tabulation
 */
import java.util.* ;

import java.io.*; 
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int[] dp = new int[nums.size()];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		for (int i = nums.size() - 1; i >= 0; i--) {
			if (i == nums.size() - 1) {
				dp[i] = nums.get(i);
			} else if (i == nums.size() - 2) {
				dp[i] = Math.max(dp[i + 1], nums.get(i)); //Either current element will be picked or last element
			} else {
				dp[i] = Math.max((nums.get(i) + dp[i + 2]), dp[i + 1]);
			}
		}
		return dp[0];
	}
}

/**
 * Solution 1.1: Memoisation
 */
import java.util.* ;

import java.io.*; 
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int[] dp = new int[nums.size()];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		return evaluate(0, nums, dp);
	}

	private static int evaluate(int index, ArrayList<Integer> nums, int[] dp) {
		if (index >= nums.size()) {
			return 0;
		}
		if (dp[index] != -1) {
			return dp[index];
		}
		if (dp[index] == (nums.size() - 1)) {
			dp[index] = nums.get(index); //implies adjacent was not picked. To maximise sum, we should pick it for sure
		} else {
			dp[index] = Math.max(evaluate(index + 1, nums, dp), (nums.get(index) + evaluate(index + 2, nums, dp)));
		}
		return dp[index];
	}
}
