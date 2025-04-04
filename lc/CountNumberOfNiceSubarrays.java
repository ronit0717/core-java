class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }

    private int count(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        while(j < nums.length) {
            sum += nums[j] % 2; //convert the odd number to 1, even to 0
            while(sum > k) {
                sum -= nums[i] % 2;
                i++;
            }
            if (sum <= k) {
                int len = j - i + 1;
                count += len;
            }
            j++;
        }
        return count;
    }
}