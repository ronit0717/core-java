class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithLessThanOrEqualsSum(nums, goal) 
         - numSubarraysWithLessThanOrEqualsSum(nums, goal - 1);
    }

    private int numSubarraysWithLessThanOrEqualsSum(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        while(j < nums.length) {
            sum += nums[j];
            while(sum > goal) {
                sum -= nums[i];
                i++;
            }
            if (sum <= goal) {
                int len = j - i + 1;
                count += len;
            }
            j++;
        }
        return count;
    }
}