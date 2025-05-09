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

Similar question: Kth element in two sorted arrays
https://github.com/ronit0717/core-java/blob/master/gfg/KthElementOfTwoSortedArrays.java
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return medianUtil(nums1, nums2);
        } else {
            return medianUtil(nums2, nums1);
        }
    }

    private double medianUtil(int[] nums1, int[] nums2) {
        int min = 0;
        int max = nums1.length;
        int totalLen = nums1.length + nums2.length;
        int leftLen = (totalLen + 1) / 2;
        int leftMax = 0;
        int rightMin = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            int leftLen1 = mid;
            int leftLen2 = leftLen - leftLen1;
            int left1 = (leftLen1 == 0) ? Integer.MIN_VALUE : nums1[leftLen1 - 1];
            int left2 = (leftLen2 == 0) ? Integer.MIN_VALUE : nums2[leftLen2 - 1];
            int right1 = (leftLen1 == nums1.length) ? Integer.MAX_VALUE : nums1[leftLen1];
            int right2 = (leftLen2 == nums2.length) ? Integer.MAX_VALUE : nums2[leftLen2];
            if (left1 <= right2 && left2 <= right1) {
                leftMax = Math.max(left1, left2);
                rightMin = Math.min(right1, right2);
                break;
            } else if (left1 > right2) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return (totalLen % 2 == 1) ? leftMax : (leftMax + rightMin) / 2d;
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

/* Solution 1.2: By comparing the two arrays using two pointers, TC = O((M + N)/2), SC = O(1)
find the required index
if m + n -> odd => index = (m + n)/2
if m + n -> even => indexes = (m + n)/2 and (m + n)/2 - 1 => average
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int index1 = (len1 + len2 - 1) / 2;
        int index2 = index1 + 1;
        int num1 = 0;
        int num2 = 0;
        int k = 0;
        int i = 0;
        int j = 0;
        int num = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                num = nums1[i];
                i++;
            } else {
                num = nums2[j];
                j++;
            }
            if (k == index1) {
                num1 = num;
            } else if (k == index2) {
                num2 = num;
                return getMedian(len, num1, num2);
            }
            k++;
        }
        while(i < len1) {
            num = nums1[i];
            i++;
            if (k == index1) {
                num1 = num;
            } else if (k == index2) {
                num2 = num;
                return getMedian(len, num1, num2);
            }
            k++;
        }
        while(j < len2) {
            num = nums2[j];
            j++;
            if (k == index1) {
                num1 = num;
            } else if (k == index2) {
                num2 = num;
                return getMedian(len, num1, num2);
            }
            k++;
        }
        return getMedian(len, num1, num2);
    }

    private double getMedian(int len, int num1, int num2) {
        if (len % 2 == 0) {
            return (num1  + num2) / 2d;
        }
        return num1;
    }
}

/* Solution 1.1: Using an extra array. TC = O(N + M), SC = O(N + M)*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1 + len2];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < len1) {
            nums[k] = nums1[i];
            i++;
            k++;
        }
        while(j < len2) {
            nums[k] = nums2[j];
            j++;
            k++;
        }
        int len = len1 + len2;
        int mid = (len1 + len2) / 2;
        if (len % 2 == 0) {
            return (nums[mid] + nums[mid - 1]) / 2d; 
        } else {
            return nums[mid];
        }
    }
}