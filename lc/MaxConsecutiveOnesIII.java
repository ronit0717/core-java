//Solution 2: TC = O(N). Window size is maintained even if number of zeroes exceeds k
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count0 = 0;
        int maxLen = 0;
        while(j < nums.length) {
            if(nums[j] == 0) {
                count0++;
            }
            if (count0 > k) {
                if(nums[i] == 0) {
                    count0--;
                }
                i++;
            }
            if (count0 <= k) {
                int len = j - i + 1;
                maxLen = Math.max(len, maxLen);
            }
            j++;
        }
        return maxLen;
    }
}

//Solution 1: TC = O(2N)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count0 = 0;
        int maxLen = 0;
        while(j < nums.length) {
            if(nums[j] == 0) {
                count0++;
            }
            while(count0 > k) {
                if(nums[i] == 0) {
                    count0--;
                }
                i++;
            }
            int len = j - i + 1;
            maxLen = Math.max(maxLen, len);
            j++;
        }
        return maxLen;
    }
}