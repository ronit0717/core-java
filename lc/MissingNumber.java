//Solution 2: XOR approach
class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
            xor = xor ^ i;
        }
        xor = xor ^ nums.length;
        return xor;
    }
} 

//Solution 1: Sum approach
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum =  len*(len+1)/2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}