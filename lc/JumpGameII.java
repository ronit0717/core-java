//Alternate solution using dynamic programming TC = O(N^2)

//TC = O(N), SC=O(1) -> Most optimised Greedy Solution
class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int j = 0;
        int jump = 0;
        while(j < nums.length - 1) {
            int max = j;
            for (int k = i; k <= j; k++) {
                int iMax = k + nums[k];
                max = Math.max(max, iMax);
            }
            i = j + 1;
            j = max;
            jump++;
        }
        return jump;
    }
}