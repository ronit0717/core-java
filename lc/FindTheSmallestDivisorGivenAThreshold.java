//Solution 2 (Optimised with sorting)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int min = 1;
        int max = nums[nums.length - 1];
        int ans = max;
        while(min <= max) {
            int mid = (min + max) / 2;
            if (isPossible(nums, mid, threshold)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int divisor, int threshold) {
        double count = 0;
        double d = (double)divisor;
        for (int i = nums.length -1; i >= 0; i--) {
            count += Math.ceil(nums[i] / d);
            if (count > threshold) {
                return false;
            }
        }
        return true;
    }
}

//Solution 1
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int ans = max;
        while(min <= max) {
            int mid = (min + max) / 2;
            if (isPossible(nums, mid, threshold)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int divisor, int threshold) {
        double count = 0;
        double d = (double)divisor;
        for (int num : nums) {
            count += Math.ceil(num / d);
            if (count > threshold) {
                return false;
            }
        }
        return true;
    }
}