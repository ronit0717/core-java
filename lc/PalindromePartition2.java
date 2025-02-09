/**
 * Solution 2: Tabulation
 * TC = O(N^3), SC=O(N)
 */
class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if(isPalindrome(i, j, s)) {
                    int cost = (j == s.length() - 1) ? 0 : 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0];
    }

    private boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

/**
 * Solution 1: Memoisation
 * TC = O(N^3), SC=O(N) + O(N) Auxillary stack space
 */
class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length() - 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return calculate(0, s, dp);
    }

    private int calculate(int start, String s, int[] dp) {
        if (start >= s.length() - 1) {
            return 0;
        }
        if(dp[start] != -1) {
            return dp[start];
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(start, i, s)) {
                int cost = (i == (s.length() - 1)) ? 0 : 1 + calculate(i + 1, s, dp);
                minCost = Math.min(cost, minCost);
            }
        }
        dp[start] = minCost;
        return minCost;
    }

    private boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}