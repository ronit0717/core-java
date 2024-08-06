/**
 * Solution 1.3: Tabulation space optimised
 */
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..

        //init dp array
        int dp[] = new int[3];
        int dpPrev[] = new int[3];
        for (int i = (n - 1); i >= 0; i--) {
            for (int d = 0; d < 3; d++) {
                dpPrev[d] = dp[d];
            }
            if (i == (n - 1)) {
                for (int j = 0; j < 3; j++) {
                    int maxPoint = 0;
                    for (int k = 0; k < 3; k++) {
                        if (j == k) {
                            continue;
                        }
                        int point = points[i][k];
                        if (point > maxPoint) {
                            maxPoint = point;
                        }
                    }
                    dp[j] = maxPoint;
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    int maxPoint = 0;
                    for (int k = 0; k < 3; k++) {
                        if (j == k) {
                            continue;
                        }
                        int point = points[i][k] + dpPrev[k];
                        if (point > maxPoint) {
                            maxPoint = point;
                        }
                    }
                    dp[j] = maxPoint;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }

}

/**
 * Solution 1.2: Tabulation
 */
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..

        //init dp array
        int dp[][] = new int[n][3];
        for (int i = (n - 1); i >= 0; i--) {
            if (i == (n - 1)) {
                for (int j = 0; j < 3; j++) {
                    int maxPoint = 0;
                    for (int k = 0; k < 3; k++) {
                        if (j == k) {
                            continue;
                        }
                        int point = points[i][k];
                        if (point > maxPoint) {
                            maxPoint = point;
                        }
                    }
                    dp[i][j] = maxPoint;
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    int maxPoint = 0;
                    for (int k = 0; k < 3; k++) {
                        if (j == k) {
                            continue;
                        }
                        int point = points[i][k] + dp[i + 1][k];
                        if (point > maxPoint) {
                            maxPoint = point;
                        }
                    }
                    dp[i][j] = maxPoint;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (dp[0][i] > result) {
                result = dp[0][i];
            }
        }
        return result;
    }

}

/**
 * Solution 1.1: Memoisation
 */
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..

        //init dp array
        int dp[][] = new int[n][3];
        return evaluate(0, points, dp, -1); //-1 indicates no last task
    }

    private static int evaluate(int index, int[][] points, int[][] dp, int lastTaskIndex) {
        // if (lastTaskIndex != -1 && dp[index][lastTaskIndex] != 0) {
        //     return dp[index][lastTaskIndex];
        // }
        int n = dp.length - 1; //max index
        int maxPoint = 0;
        if (index == n) { //last index
            for (int i = 0; i < 3; i++) { // Mentioned 3 tasks
                if (i == lastTaskIndex) {
                    continue;
                }
                int point = points[index][i];
                if (point > maxPoint) {
                    maxPoint = point;
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (i == lastTaskIndex) {
                    continue;
                }
                int point = points[index][i] + (dp[index + 1][i] != 0 ? dp[index + 1][i] : evaluate((index + 1), points, dp, i)) ;
                if (point > maxPoint) {
                    maxPoint = point;
                }
            }
        }
        if (lastTaskIndex != -1) {
            dp[index][lastTaskIndex] = maxPoint;
        }
        return maxPoint;
    }

}