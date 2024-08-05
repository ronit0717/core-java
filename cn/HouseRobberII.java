/**
 * Very similar to MaxSumOfNonAdjacentElements problem.
 * Case 1: Include the first element, and ignore the last element
 * Case 2: Dont include the first element, and include the last element
 * Result will be the max of case 1 and case 2.
 * 
 * Time complexity = O(N), Space complexity = O(1)
 * This is the tabulation solution, with space optimisation
 */
import java.util.* ;
import java.io.*; 
public class Solution {
	public static long houseRobber(int[] valueInHouse) {
		// Write your code here.
		int len = valueInHouse.length;
		if (len == 1) {
			return valueInHouse[0];
		}
		long sum1 = evaluate(0, len - 2, valueInHouse); //0th element picked
		long sum2 = evaluate(1, len - 1, valueInHouse); //0th element not picked
		return Math.max(sum1, sum2);
	}

	private static long evaluate(int startIndex, int lastIndex, int[] valueInHouse) {
		long prev2 = -1L;
		long prev = -1L;
		for (int i = lastIndex; i >= startIndex; i--) {
			if (i == lastIndex) {
				prev = valueInHouse[i];
				continue;
			}
			long sum1, sum2, sum = -1L;
			if (i == (lastIndex - 1)) {
				sum1 = valueInHouse[i]; //current picked
				sum2 = prev; //current not picked
			} else {
				sum1 = valueInHouse[i] + prev2; //current picked
				sum2 = prev; //current not picked
			}
			sum = Math.max(sum1, sum2);
			prev2 = prev;
			prev = sum;
		}
		return prev;
	}
}