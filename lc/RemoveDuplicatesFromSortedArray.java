/* Solution 1: Using two pointer, one pointer pointed to the last unique element
TC  = O(N), SC = O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pos] != nums[i]) {
                nums[++pos] = nums[i];
            }
        }
        return ++pos;
    }
}

/* Solution 2: Brute, using a hashset
Iterate the array
If stack.peek() != nums[i], push to the stack

Now the stack will have all unique element, populate the array accordingly, and return stack.length
*/