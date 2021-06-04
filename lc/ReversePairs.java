//Solution 1: Reverse count using merge sort approach, TC = O(NLogN), SC = O(N)
class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        int[] merge = new int[len];
        return mergeSortUtil(nums, 0, len - 1, merge);
    }
    
    private int mergeSortUtil(int[] nums, int start, int end, int[] merge) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = mergeSortUtil(nums, start, mid, merge);
        count += mergeSortUtil(nums, mid + 1, end, merge);
        count += countCondition(nums, start, mid, end);
        
        merge(nums, start, mid, end, merge);
        return count;
    }
    
    /* Algo 
    Set count = 0
    For loop the left array, for each i
        Increase j, while arr[i] > 2 * arr[j]
    count += number of elements to the left of j in right array
    */
    private int countCondition(int[] nums, int start, int mid, int end) {
        int count = 0;
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while(j <= end && ((long)nums[i] > (2L * (long)nums[j]))) {
                j++;
            }
            count += (j - mid - 1);
        }
        return count;
    }
    
    private void merge(int[] nums, int start, int mid, int end, int[] merge) {
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if ( i > mid) {
                merge[k] = nums[j++];
            } else if (j > end) {
                merge[k] = nums[i++];
            } else {
                if (nums[i] < nums[j]) {
                    merge[k] = nums[i++];
                } else {
                    merge[k] = nums[j++];
                }
            }
        }
        
        for (int k = start; k <= end; k++) {
            nums[k] = merge[k];
        }
    }
}