/* Solution 4, Striver's solution using binary search
This approach uses following concept

In the left half of break point, the first instance of any number is at the even index
Whereas in the right hald of break point, the first instance of any number is at the odd index

Rest its similar to Solution 3
*/

/* Solution 3, using binary search TC = O(logN) */
/*
Do binary search, if the element in the mid is the singular element, return it
Else, if the number of element less than equal to mid in the left half is even and the immediate left element
is same as mid, this definitely means the singular element is to my left
Similarly if the number of elements less than equal to mid to the left is odd, and the immediate left
element is not same as mid, then also definitely, the singular element is to the left of mid
And vice versa for right side
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int min = 0;
        int max = nums.length - 1;
        int mid = -1;
        while (min <= max) {
            mid = (min + max) / 2;
            if ( (mid != 0 && mid != (nums.length - 1) && nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) 
                || (mid == 0 && nums[mid + 1] != nums[mid]) 
                || (mid == (nums.length - 1) && nums[mid - 1] != nums[mid])
               ) {
                return nums[mid];
            }
            if (mid == 0) {
                min = mid + 2;
            } else if (mid == (nums.length - 1)) {
                max = mid - 2;
            } else if ( (mid % 2 == 0) && (nums[mid - 1] == nums[mid]) ) {
                max = mid - 2; //our answer lies in the left fragment
            } else if ( (mid % 2 != 0) && (nums[mid + 1] == nums[mid]) ) {
                max = mid - 1; //our answer lies in the left fragment
            } else if ( (mid % 2 == 0) && (nums[mid + 1] == nums[mid]) ) {
                min = mid + 2; //our answer lies in the right fragment
            } else {
                min = mid + 1; //our answer lies in the right fragment
            }
        }
        return mid;
    }
}


/* Solution 2, using xor TC = O(N) */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }   
        return xor;
    }
}

/* Solution 1, TC = O(N)
keep a prev and curr pointer
if prev == curr pointer, then make prev = curr + 1, and curr = curr + 2
if prev != curr
	if (curr == curr + 1) return prev
	else return curr
*/