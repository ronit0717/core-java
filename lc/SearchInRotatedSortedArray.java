/*
TC = O(LogN), SC = O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            
            if (target == nums[mid]) {
                return mid;
            }
            
            if (nums[end] > nums[mid]) { //right half is sorted
                if (target <= nums[end] && target > nums[mid]) { //target is in right segment
                    start = mid + 1;
                } else { //target is in left segment
                    end = mid - 1;
                }
            } else { //left half is sorted
                if (nums[start] <= target && target < nums[mid]) { //target is in left segment
                    end = mid - 1;
                } else { //target is in right segment
                    start = mid + 1;
                }
            }
        }
        
        return -1;
    }
}