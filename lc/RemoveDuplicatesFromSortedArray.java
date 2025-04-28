/* Solution 1: Using two pointer, one pointer pointed to the last unique element
TC  = O(N), SC = O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length) {
            if (nums[j] > nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}

/* Solution 2: Brute, using a hashset
Iterate the array
If stack.peek() != nums[i], push to the stack

Now the stack will have all unique element, populate the array accordingly, and return stack.length
*/