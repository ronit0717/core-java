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
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if (m < n) {
            return kthElement(arr2, arr1, m, n, k);
        }
        int start = 0;
        int end = Math.min(n, k) - 1; //it should be the minimum of n and k, else if k < n
                                      //else it may happen that we are taking length greater than k
        int mid1 = 0, mid2 = 0;
        
        while (start <= end) {
            mid1 = (start + end) / 2;
            mid2 = k - mid1 - 2;
            
            if (mid2 >= m) { //insufficient length
                start = mid1 + 1;
                continue;
            }
            
            //check condition => range on mid1 and mid2 check followed by l1,r2 check and l2,r1 check
            if ( (mid2 >= -1 && mid2 < (m - 1) && mid1 < n && mid1 >= 0) && (arr1[mid1] > arr2[mid2 + 1]) ) {
                end = mid1 - 1;
                continue;
            }
            
            if ( (mid1 < (n - 1) && mid1 >= -1 && mid2 >= 0 && mid2 < m)  && (arr2[mid2] > arr1[mid1 + 1]) ) {
                start = mid1 + 1;
                continue;
            }
            
            break; //this partition did not fail any condition, hence this partition will give us the solution
        }
        
        if (end < 0) {
            mid1 = -1; //ie, we are not selecting any element from array1
        }
        
        mid2 = k - mid1 - 2;
        
        int l1 = (mid1 >= 0 && mid1 < n) ? arr1[mid1] : Integer.MIN_VALUE;
        int l2 = (mid2 >= 0 && mid2 < m) ? arr2[mid2] : Integer.MIN_VALUE;
        
        return (long)Math.max(l1, l2);
    }
}