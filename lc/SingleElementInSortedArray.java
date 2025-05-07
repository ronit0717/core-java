class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int start = 0;
        int end = n - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            if ((mid == 0 && nums[mid + 1] != nums[mid]) 
                || (mid == (n - 1) && nums[mid] != nums[mid - 1])
                || (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
            ) {
                return nums[mid];
            }
            if (mid != (n - 1) && nums[mid] == nums[mid + 1]) {
                mid = mid + 1;
            }
            int leftLength = mid + 1;
            int rightLength = n - mid - 1;
            if (leftLength % 2 == 1) {
                //number lies in left
                end = mid - 2; //removed the duplicates
            } else {
                //number lies in right
                start = mid + 1;
            }
        }
        return -1;
    } 
}