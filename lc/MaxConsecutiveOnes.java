/* TC = O(N), SC = O(1)
Use a variable max (which stores the max consecutive count), and a variable count which stores the
current count of 1's
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 0;
            }
        }
        return max;
    }
}