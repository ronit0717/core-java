class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        } else if (nums[0] > nums[1]) {
            return 0;
        } else if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int start = 1;
        int end = n - 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                //increasing slope, peak is at right
                start = mid + 1;
            } else {
                //decreasing slope, or a drough
                end = mid - 1;
            }
        }
        return -1;
    }
}