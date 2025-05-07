//Solution 2: Recursive Solution
class Solution {
    public int search(int[] nums, int target) {
        return searchUtil(nums, 0, nums.length - 1, target);
    }

    private int searchUtil(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchUtil(nums, mid + 1, end, target);
        } else {
            return searchUtil(nums, start, mid - 1, target);
        }
    }
}

//Solution 1: Iterative Solution
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}