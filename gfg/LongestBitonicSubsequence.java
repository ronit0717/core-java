class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        if (n == 1) {
            return 0; // Should be a mountain with a peak
        }
        
        int dp[] = new int[n]; //front dp
        int dp2[] = new int[n]; //back dp
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            dp2[i] = 1;
        }
        //populate dp1
        for (int i = 1; i < n; i++) {
            int maxVal = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int val = dp[i] + dp[j];
                    maxVal = Math.max(maxVal, val);
                }
            }
            dp[i] = maxVal;
        }
        
        //populate dp2
        for (int i = n - 2; i >= 0; i--) {
            int maxVal = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    int val = dp2[i] + dp2[j];
                    maxVal = Math.max(maxVal, val);
                }
            }
            dp2[i] = maxVal;
        }
        
        
        int mbsl = 0; //max bintonic subsequence length
        for (int i = 0; i < n; i++) {
            if (dp[i] != 1 && dp2[i] != 1) { //to ensure its a mountain with a peak
                int len = dp[i] + dp2[i] - 1;
                mbsl = Math.max(mbsl, len);
            }
            
        }
      
        return mbsl;
    }
}