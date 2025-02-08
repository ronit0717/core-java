class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            cnt[i] = 1;
        }
        int lis = 1;
        int lisCount = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int newVal = dp[i] + dp[j];
                    if (newVal > maxVal) {
                        maxVal = newVal;
                        cnt[i] = cnt[j];
                    } else if (newVal == maxVal) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            dp[i] = maxVal;
            if (maxVal > lis) {
                lis = maxVal;
                lisCount = cnt[i];
            } else if (maxVal == lis) {
                lisCount += cnt[i];
            }
        }
        return lisCount;
    }
}