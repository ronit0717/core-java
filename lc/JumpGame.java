class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            int m = i + nums[i];
            max = Math.max(m, max);
        }
        return true;
    }
}