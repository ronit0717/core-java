class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); //sort in increasing order
        int[] dp = new int[nums.length];
        int[] prevIndexArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            prevIndexArr[i] = i;
        }
        int maxLis = 1;
        int lisIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 1;
            int prevIndex = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    int val = dp[i] + dp[j];
                    if (val > maxVal) {
                        maxVal = val;
                        prevIndex = j;
                    }
                }
            }
            dp[i] = maxVal;
            prevIndexArr[i] = prevIndex;
            if (maxVal > maxLis) {
                maxLis = maxVal;
                lisIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>(maxLis);
        int k = lisIndex;
        for (int i = 0; i < maxLis; i++) {
            ans.add(nums[k]);
            k = prevIndexArr[k];
        }
        Collections.reverse(ans);
        return ans;
    }
}