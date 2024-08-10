/**
 * Just a additional condition compared to TotalUniquePaths problem 
 */
import java.util.ArrayList;

public class Solution {
    static int mazeObstacles(int m, int n, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        int mod = 1000000007; //logic: https://www.geeksforgeeks.org/modulo-1097-1000000007/
        int[] dp = new int[n];
		for (int i = (m-1); i >= 0; i--) {
			for (int j = (n-1); j >= 0; j--) {
                if (mat.get(i).get(j) == -1) {
                    dp[j] = 0;
                    continue;
                }
				if (i == (m-1) && j == (n-1)) {
					dp[j] = 1;
					continue;
				}
				int val = 0;
				if (i != (m-1)) {
					val += dp[j]; //down
				}
				if (j != (n-1)) {
					val += dp[j+1]; //right
				}
				dp[j] = val % mod;
			}
		}
		return dp[0] % mod;
    }

}