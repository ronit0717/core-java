//Link: https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/

/*
Solution 1: Striver's Binary solution using partitions
Idea: to make partition such that the L1 <= R1 and L2 <= R1
where 
L1 => element to the immediate left  of partition of array 1
L2 => element to the immediate left  of partition of array 2
R1 => element to the immediate right of partition of array 1
R1 => element to the immediate right of partition of array 2

TC = O(Log(min of length of nums1, nums2)) = O(MIN(nums1.length, nums2.length))
SC = O(1)

Similar questions: Median of two sorted arrays
https://github.com/ronit0717/core-java/blob/master/lc/MedianOfTwoSortedArrays.java
*/

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        if (a.length < b.length) {
            return util(a, b, k);
        }
        return util(b, a, k);
    }
    
    private int util(int a[], int b[], int k) {
        int min = 0;
        int max = a.length;
        while (min <= max) {
            int mid = (min + max) / 2;
            int leftLen1 = mid;
            int leftLen2 = k - leftLen1;
            if (leftLen2 < 0) {
                max = mid - 1;
                continue;
            } else if (leftLen2 > b.length) {
                min = mid + 1;
                continue;
            }
            int left1 = (leftLen1 == 0) ? Integer.MIN_VALUE : a[leftLen1 - 1];
            int left2 = (leftLen2 == 0) ? Integer.MIN_VALUE : b[leftLen2 - 1];
            int right1 = (leftLen1 == a.length) ? Integer.MAX_VALUE : a[leftLen1];
            int right2 = (leftLen2 == b.length) ? Integer.MAX_VALUE : b[leftLen2];
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return 0; //never executed
    }
}