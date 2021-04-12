class Solution {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + ((dp[i - 1] > 0) ? dp[i - 1] : 0);
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }
}

/* KADANE's ALGORITMS 
ex1:
nums[] = { 2, -1, 2, 0 }
db[]   = { 2,  1, 3, 3 } => Ans: 3 (max of db[])

ex2:
nums[] = { 2, -1, -1, -1, 3, -1}
db[]   = { 2,  1,  0, -1, 3,  2} => Ans: 3 (max of db[])

ex3:
nums[] = { 3, -1, -1, -1, 3, -1}
db[]   = { 3,  2,  1,  0, 3,  2} => Ans: 3 (max of db[])

ex3:
nums[] = { 3, -1, -1, -1, 3, -1}
db[]   = { 3,  2,  1,  0, 3,  2} => Ans: 3 (max of db[])

ex4:
nums[] = { 4, -1, -1, -1, 3, -1}
db[]   = { 4,  3,  2,  1, 4,  3} => Ans: 4 (max of db[])

ex4:
nums[] = { 4, -1, -1, -1, 5, -1, 2}
db[]   = { 4,  3,  2,  1, 6,  5, 7} => Ans: 7 (max of db[])
*/