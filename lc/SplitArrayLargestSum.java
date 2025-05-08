class Solution {
    public int splitArray(int[] nums, int k) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.max(min, num);
        }
        max = sum;

        int ans = -1;
        while(min <= max) {
            int mid = (min + max) / 2;
            int count = getCount(mid, nums);
            if (count > k) {
                min = mid + 1;
            } else {
                ans = mid;
                max = mid - 1; // to get better (lesser) ans
            }
        }
        return ans;
    }

    private int getCount(int maxVal, int[] nums) {
        int curr = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] + curr) > maxVal) {
                count++;
                curr = nums[i];
            } else {
                curr += nums[i];
            }
        }
        return count;
    }
}