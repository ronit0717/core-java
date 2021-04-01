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


/*
find the required index
if m + n -> odd => index = (m + n)/2
if m + n -> even => indexes = (m + n)/2 and (m + n)/2 - 1 => average

1, 2    3, 4




*/