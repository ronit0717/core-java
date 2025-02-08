/**
 * Solution 2: Tabulation
 * TC = O(N*N*2*N), SC=O(N*N*2)
 */
public class Solution {
    public static int evaluateExp(String exp) {
        // Write your code here.
        int n = exp.length();
        int[][][] dp = new int[n][n][2];
        for (int i = n - 1; i >= 0; i-=2) {
            for (int j = i; j < n; j+=2) {
                for (int k = 0; k <= 1; k++) {
                    if (i == j) {
                        int count = 0;
                        if ((k == 1 && exp.charAt(i) == 'T') || (k == 0 && exp.charAt(i) == 'F')) {
                            count = 1;
                        }
                        dp[i][j][k] = count;
                        continue;
                    }
                    long count = 0;
                    int index = i + 1;
                    int largeNum = 1000000007;
                    while (index <= (j - 1)) {
                        char operation = exp.charAt(index);
                        if (operation == '|') {
                            if (k == 0) {
                                long leftFalse = dp[i][index - 1][0];
                                long rightFalse = dp[index + 1][j][0];
                                count += (leftFalse * rightFalse) % largeNum;
                            } else {
                                long leftTrue = dp[i][index - 1][1];
                                long leftFalse = dp[i][index - 1][0];
                                long rightTrue = dp[index + 1][j][1];
                                long rightFalse = dp[index + 1][j][0];
                                count += (leftTrue * rightTrue) % largeNum;
                                count += (leftTrue * rightFalse) % largeNum;
                                count += (leftFalse * rightTrue) % largeNum;
                            }
                        } else if (operation == '&') {
                            if (k == 0) {
                                long leftTrue = dp[i][index - 1][1];
                                long leftFalse = dp[i][index - 1][0];
                                long rightTrue = dp[index + 1][j][1];
                                long rightFalse = dp[index + 1][j][0];
                                count+= (leftTrue * rightFalse) % largeNum;
                                count+= (leftFalse * rightTrue) % largeNum;
                                count+= (leftFalse * rightFalse) % largeNum;
                            } else {
                                long leftTrue = dp[i][index - 1][1];
                                long rightTrue = dp[index + 1][j][1];
                                count+= (leftTrue * rightTrue) % largeNum;
                            }
                        } else if (operation == '^') {
                            long leftTrue = dp[i][index - 1][1];
                            long leftFalse = dp[i][index - 1][0];
                            long rightTrue = dp[index + 1][j][1];
                            long rightFalse = dp[index + 1][j][0];
                            if (k == 0) {
                                count+= (leftTrue * rightTrue) % largeNum;
                                count+= (leftFalse * rightFalse) % largeNum;
                            } else {
                                count+= (leftTrue * rightFalse) % largeNum;
                                count+= (leftFalse * rightTrue) % largeNum;
                            }
                        } else {
                            System.out.println("Oops :(");
                        }
                        index+=2;
                    }
                    dp[i][j][k] = (int)(count % 1000000007);
                }
            }
        }
        return dp[0][n-1][1];
    }
}

/**
 * Solution 1: Memoisation
 * TC = O(N*N*2*N), SC=O(N*N*2) + O(N) Auxilary stack space
 */
public class Solution {
    public static int evaluateExp(String exp) {
        // Write your code here.
        int n = exp.length();
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return calculate(0, n - 1, 1, exp, dp);
    }

    /**
    * i = start Index
    * j = end Index
    * k = expected result (0 for false, 1 for true)
    */
    private static int calculate(int i, int j, int k, String exp, int[][][] dp) {
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        if (i == j) {
            int count = 0;
            if ((k == 1 && exp.charAt(i) == 'T') || (k == 0 && exp.charAt(i) == 'F')) {
                 count = 1;
            }
            dp[i][j][k] = count;
            return count;
        }
        
        long count = 0;
        int index = i + 1;
        int largeNum = 1000000007;
        while (index <= (j - 1)) {
            char operation = exp.charAt(index);
            if (operation == '|') {
                if (k == 0) {
                    long leftFalse = calculate(i, index - 1, 0, exp, dp);
                    long rightFalse = calculate(index + 1, j, 0, exp, dp);
                    count += (leftFalse * rightFalse) % largeNum;
                } else {
                    long leftTrue = calculate(i, index - 1, 1, exp, dp);
                    long leftFalse = calculate(i, index - 1, 0, exp, dp);
                    long rightTrue = calculate(index + 1, j, 1, exp, dp);
                    long rightFalse = calculate(index + 1, j, 0, exp, dp);
                    count += (leftTrue * rightTrue) % largeNum;
                    count += (leftTrue * rightFalse) % largeNum;
                    count += (leftFalse * rightTrue) % largeNum;
                }
            } else if (operation == '&') {
                if (k == 0) {
                    long leftTrue = calculate(i, index - 1, 1, exp, dp);
                    long leftFalse = calculate(i, index - 1, 0, exp, dp);
                    long rightTrue = calculate(index + 1, j, 1, exp, dp);
                    long rightFalse = calculate(index + 1, j, 0, exp, dp);
                    count+= (leftTrue * rightFalse) % largeNum;
                    count+= (leftFalse * rightTrue) % largeNum;
                    count+= (leftFalse * rightFalse) % largeNum;
                } else {
                    long leftTrue = calculate(i, index - 1, 1, exp, dp);
                    long rightTrue = calculate(index + 1, j, 1, exp, dp);
                    count+= (leftTrue * rightTrue) % largeNum;
                }
            } else if (operation == '^') {
                long leftTrue = calculate(i, index - 1, 1, exp, dp);
                long leftFalse = calculate(i, index - 1, 0, exp, dp);
                long rightTrue = calculate(index + 1, j, 1, exp, dp);
                long rightFalse = calculate(index + 1, j, 0, exp, dp);
                if (k == 0) {
                    count+= (leftTrue * rightTrue) % largeNum;
                    count+= (leftFalse * rightFalse) % largeNum;
                } else {
                    count+= (leftTrue * rightFalse) % largeNum;
                    count+= (leftFalse * rightTrue) % largeNum;
                }
            } else {
                System.out.println("Oops :(");
            }
            index+=2;
        }
        dp[i][j][k] = (int)(count % 1000000007);
        return dp[i][j][k];
    }
}