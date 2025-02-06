/**
 * Solution 5: Alternate (non intutive) solution
 * TC = O(N^2), SC = O(N)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int lis = 1;
        for (int i = 1; i < nums.length; i++) {
            int curr = dp[i];
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    int newVal = dp[i] + dp[j];
                    curr = Math.max(curr, newVal);
                }
            }
            dp[i] = curr;
            lis = Math.max(lis, dp[i]);
        }
        return lis;
    }
}

/**
 * Solution 4: Tabulation with space optimisation
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int p = 0; p < nums.length; p++) {
                prev[p] = dp[p];
            }
            for (int k = i - 1; k >= -1; k--) { //Range of k from -1 to (i - 1)
                int j = k + 1; //Coordinate shift
                int notPick = (i == nums.length - 1) ? 0 : prev[j];
                int pick = Integer.MIN_VALUE;
                if (k == - 1 || nums[i] > nums[k]) {
                    pick = 1 + ((i == nums.length - 1) ? 0 : prev[i + 1]); //coordinate shift applied for value of j
                }
                dp[j] = Math.max(pick, notPick);
            }
        }
        return dp[0];
    }
}

/**
 * Solution 3: Tabulation
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) { //Range of prev from -1 to (i - 1)
                int j = prev + 1; //Coordinate shift
                int notPick = (i == nums.length - 1) ? 0 : dp[i + 1][j];
                int pick = Integer.MIN_VALUE;
                if (prev == - 1 || nums[i] > nums[prev]) {
                    pick = 1 + ((i == nums.length - 1) ? 0 : dp[i + 1][i + 1]); //coordinate shift applied for value of j
                }
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[0][0];
    }
}

/**
 * Solution 2: Tabulation (with +1 index)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = nums.length; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) { //Range of prev from -1 to (i - 1)
                int j = prev + 1; //Coordinate shift
                if (i == nums.length) {
                    continue; //default value 0
                }
                int notPick = dp[i + 1][j];
                int pick = Integer.MIN_VALUE;
                if (prev == - 1 || nums[i] > nums[prev]) {
                    pick = 1 + dp[i + 1][i + 1];
                }
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[0][0];
    }
}


/**
 * Solution 1: Memoisation
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j] = -1;
            }
        }
        return evaluate(0, -1, nums, dp);
    }

    private int evaluate(int i, int j, int[] nums, int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if(dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }
        int notPick = evaluate(i + 1, j, nums, dp);
        int pick = Integer.MIN_VALUE;
        if(j == -1 || nums[i] > nums[j]) {
            pick = 1 + evaluate(i + 1, i, nums, dp);
        }
        int result = Math.max(pick, notPick);
        dp[i][j + 1] = result;
        return result;
    }
    
}