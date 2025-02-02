/**
 * Solution 3: Tabulation space optimised
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[n + 1];
        boolean[] prev = new boolean[n + 1];
        for (int i = m; i >= 0; i--) {
            for (int k = 0; k <= n; k++) {
                prev[k] = dp[k];
            }
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    dp[j] = true;
                } else if (i == m) {
                    //all remaining characters in pattern need to be wildcard
                    int k = j;
                    boolean match = true;
                    while (k < n) {
                        if (p.charAt(k) != '*') {
                            match = false;
                            break;
                        }
                        k++;
                    }
                    dp[j] = match;
                } else if (j == n) {
                    dp[j] = false; //pattern exhausted
                } else {
                    boolean match = false;
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                        match = prev[j+1];
                    } else if (p.charAt(j) == '*') {
                        boolean wildCardConsideredEmpty = dp[j + 1];
                        boolean wildCardConsideredForCharacter = prev[j];
                        match = wildCardConsideredEmpty || wildCardConsideredForCharacter;
                    }
                    dp[j] = match;
                }
            }
        }
        return dp[0];
    }
}

/**
 * Solution 2: Tabulation
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    dp[i][j] = true;
                } else if (i == m) {
                    //all remaining characters in pattern need to be wildcard
                    int k = j;
                    boolean match = true;
                    while (k < n) {
                        if (p.charAt(k) != '*') {
                            match = false;
                            break;
                        }
                        k++;
                    }
                    dp[i][j] = match;
                } else if (j == n) {
                    dp[i][j] = false; //pattern exhausted
                } else {
                    boolean match = false;
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                        match = dp[i+1][j+1];
                    } else if (p.charAt(j) == '*') {
                        boolean wildCardConsideredEmpty = dp[i][j + 1];
                        boolean wildCardConsideredForCharacter = dp[i + 1][j];
                        match = wildCardConsideredEmpty || wildCardConsideredForCharacter;
                    }
                    dp[i][j] = match;
                }
            }
        }
        return dp[0][0];
    }
}

/**
 * Solution 1: Memoisation
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] dp = new Boolean[m][n];
        return evaluate(0, 0, s, p, dp);
    }

    private boolean evaluate(int i, int j, String s, String p, Boolean[][] dp) {
        int m = s.length();
        int n = p.length();
        if (i == m && j == n) {
            return true;
        } else if (i == m) {
            //all remaining characters in pattern need to be wildcard
            while (j < n) {
                if (p.charAt(j) != '*') {
                    return false;
                }
                j++;
            }
            return true;
        } else if (j == n) {
            return false; //pattern exhausted
        } else if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean match = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            match = evaluate(i+1, j+1, s, p, dp);
        } else if (p.charAt(j) == '*') {
            boolean wildCardConsideredEmpty = evaluate(i, j + 1, s, p, dp);
            boolean wildCardConsideredForCharacter = evaluate(i + 1, j, s, p, dp);
            match = wildCardConsideredEmpty || wildCardConsideredForCharacter;
        }
        dp[i][j] = match;
        return match;
    }
}