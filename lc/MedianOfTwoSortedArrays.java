/*
Solution 3: Striver's Binary solution using partitions
Idea: to make partition such that the L1 <= R1 and L2 <= R1
where 
L1 => element to the immediate left  of partition of array 1
L2 => element to the immediate left  of partition of array 2
R1 => element to the immediate right of partition of array 1
R1 => element to the immediate right of partition of array 2

TC = O(Log(min of length of nums1, nums2)) = O(MIN(nums1.length, nums2.length))
SC = O(1)
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int totalLength = nums1.length + nums2.length;
        boolean evenCase = (totalLength) % 2 == 0 ? true : false;
        
        int leftSegLength = (evenCase) ? (totalLength / 2) : (totalLength / 2) + 1;//left segment length
        
        int start = 0;
        int end = Math.min(nums1.length, leftSegLength) - 1;
        int mid1 = 0, mid2 = 0;
        
        while (start <= end) {
            mid1 = (start + end) / 2;
            mid2 = leftSegLength - mid1 - 2;
            
            if (mid2 >= nums2.length) { //insufficient length of mid2
                start  = mid1 + 1;
                continue;
            }
            
            //check condition => range on mid1 and mid2 check followed by l1,r2 check and l2,r1 check
            if (mid2 < (nums2.length - 1) && nums1[mid1] > nums2[mid2 + 1]) { //l1 if greater than r2
                end = mid1 - 1;
                continue;
            } 
            
            if (mid1 < (nums1.length - 1) && mid2 >= 0 && mid2 < (nums2.length) && nums2[mid2] > nums1[mid1 + 1]) { //l2 if greater than r1
                start = mid1 + 1;
                continue;
            }
            
            break;
        }
        
        if (end < 0) {
            mid1 = -1; //ie, we are not selecting any element from nums1
        }
        mid2 = leftSegLength - mid1 - 2;
        
        int l1 = (mid1 >= 0 && mid1 < nums1.length) ? nums1[mid1] : Integer.MIN_VALUE;
        int l2 = (mid2 >= 0 && mid2 < nums2.length) ? nums2[mid2] : Integer.MIN_VALUE;
        int r1 = ( (mid1 + 1) >= 0 && (mid1 + 1) < nums1.length) ? nums1[mid1 + 1] : Integer.MAX_VALUE;
        int r2 = ( (mid2 + 1) >= 0 && (mid2 + 1) < nums2.length) ? nums2[mid2 + 1] : Integer.MAX_VALUE;
        
        if (!evenCase) {
            return (double)(Math.max(l1, l2));
        } else {
            return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        }
    }
}

/* Solution 2: Using Binary search, similar to matrix median: 
https://github.com/ronit0717/core-java/blob/master/ib/binarySearch/MatrixMedian.java

TC = O(32 * (log m + log n)) = log m + log n
SC = O(1)
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int totalLength = nums1.length + nums2.length;
        boolean oddCase = totalLength % 2 == 0 ? false : true;
        int medianIndex = totalLength / 2;
        
        if (oddCase) {
            return (double)getElementAtIndex(nums1, nums2, medianIndex);
        } else {
            return (getElementAtIndex(nums1, nums2, medianIndex) + getElementAtIndex(nums1, nums2, medianIndex - 1)) / 2.0;
        }
    }
    
    private int getElementAtIndex(int[] nums1, int[] nums2, int index) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int mid = -1, candidate = -1;
        
        while (min <= max) {
            mid = (min + max) / 2;
            int count = getCountLessThanOrEqualTo(nums1, nums2, mid);
            if (count <= index) { //index is same as number of elements less than or equal to the element in a sorted array               
                min = mid + 1;
            } else {
                candidate = mid;
                max = mid - 1;
            }
        }
        return candidate;
    }
    
    private int getCountLessThanOrEqualTo(int[] nums1, int[] nums2, int num) {
        return getCountLessThanOrEqualTo(nums1, num) + getCountLessThanOrEqualTo(nums2, num);
    }
    
    private int getCountLessThanOrEqualTo(int[] nums, int num) {
        int candidateCount = 0;
        int min = 0;
        int max = nums.length - 1;
        int mid, midVal;
        while (min <= max) {
            mid = (min + max) / 2;
            midVal = nums[mid];
            if (midVal <= num) {
                min = mid + 1;
                candidateCount = min;
            } else {
                max = mid - 1;
            }
        }
        return candidateCount;
    }
}

/* Solution 1: By comparing the two arrays using two pointers, TC = O((M + N)/2), SC = O(1)
find the required index
if m + n -> odd => index = (m + n)/2
if m + n -> even => indexes = (m + n)/2 and (m + n)/2 - 1 => average
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int totalLength = nums1.length + nums2.length;
    	int mid = totalLength / 2;
        boolean evenCase = (totalLength % 2 == 0) ? true : false;
        int i = 0;
        int j = 0;
        int k = 0;
        int sum = 0;
        int val;
        while (k <= mid) {
        	if (nums1.length == 0 || i == nums1.length) {
        		val = nums2[j];
        		j++;
        	} else if (nums2.length == 0 || j == nums2.length) {
        		val = nums1[i];
        		i++;
        	} else {
        		if (nums1[i] < nums2[j]) {
        			val = nums1[i];
        			i++;
        		} else {
        			val = nums2[j];
        			j++;
        		}
        	}
        	if ((k == (mid - 1) && evenCase) || (k == mid)) {
        		sum += val;
        	}
        	k++;
        }
        double result = evenCase ? ((double) sum / 2.0) : sum;
        return result;
    }
}