//Solution 2: TC = O(LogN)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}

//Solution 1: TC = O(N)
class Solution {
    public int searchInsert(int[] nums, int target) {
    	int i;
 		for (i = 0; i < nums.length; i++) {
 			if (target <= nums[i]) {
 				break;
 			}
 		}
 		return i;
    }
}