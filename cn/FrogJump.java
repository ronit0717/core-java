/** Solution 1.4: K Jump (Here k = 2) */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        return evaluate(n - 1, heights);
    }

    private static int evaluate(int index, int[] heights) {
        if (index == 0) {
            return 0;
        }
        int k = 2; //2 steps allowed
        List<Integer> prev = new ArrayList<>(k);
        for (int i = 0; i <= index; i++) {
            if (i == 0) {
                prev.add(0);
                continue;
            }
            int sum = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if ((i - j) < 0) {
                    break;
                }
                int currSum = prev.get(prev.size() - j) + computeEnergy(i, i - j, heights);
                sum = Math.min(sum, currSum);
            }
            if (prev.size() == k) {
                prev.remove(0);
                prev.add(sum);
            } else {
                prev.add(sum);
            }
        }
        return prev.get(prev.size() - 1); //last
    }

    private static int computeEnergy(int pos1, int pos2, int[] heights) {
        return Math.abs(heights[pos1] - heights[pos2]);
    }

}

/** Solution 1.3: Tabulation space optimised */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        return evaluate(n - 1, heights);
    }

    private static int evaluate(int index, int[] heights) {
        if (index == 0) {
            return 0;
        }
        int prev2 = 0;
        int prev1 = computeEnergy(1, 0, heights);
        if (index == 1) {
            return prev1;
        }
        for (int i = 2; i <= index; i++) {
            int sum1 = prev1 + computeEnergy(i, i - 1, heights);
            int sum2 = prev2 + computeEnergy(i, i - 2, heights);
            prev2 = prev1;
            prev1 = Math.min(sum1, sum2);
        }
        return prev1;
    }

    private static int computeEnergy(int pos1, int pos2, int[] heights) {
        return Math.abs(heights[pos1] - heights[pos2]);
    }

}

/** Solution 1.2: Tabulation */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        return evaluate(n - 1, heights);
    }

    private static int evaluate(int index, int[] heights) {
        int[] dp = new int[index + 1];
        dp[0] = 0;
        for (int i = 1; i <= index; i++) {
            int sum1 = dp[i - 1] + computeEnergy(i, i - 1, heights);
            int sum2 = Integer.MAX_VALUE;
            if (i > 1) {
                sum2 = dp[i - 2] + computeEnergy(i, i - 2, heights);
            }
            dp[i] = Math.min(sum1, sum2);
        }
        return dp[index];
    }

    private static int computeEnergy(int pos1, int pos2, int[] heights) {
        return Math.abs(heights[pos1] - heights[pos2]);
    }

}

/** Solution 1.1: Memoisation */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        
        //create dp array
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return evaluate(n - 1, dp, heights);
    }

    private static int evaluate(int index, int[] dp, int[] heights) {
        if (dp[index] != -1) {
            return dp[index];
        }
        if (index == 0) {
            dp[index] = 0;
        } else {
            int sum1 = Integer.MAX_VALUE;
            int sum2 = Integer.MAX_VALUE;
            sum1 = evaluate(index - 1, dp, heights) + computeEnergy(index, index - 1, heights);
            if (index > 1) {
                sum2 = evaluate(index - 2, dp, heights) + computeEnergy(index, index - 2, heights);
            }
            dp[index] = Math.min(sum1, sum2);
        }
        return dp[index];
    }

    private static int computeEnergy(int pos1, int pos2, int[] heights) {
        return Math.abs(heights[pos1] - heights[pos2]);
    }

}