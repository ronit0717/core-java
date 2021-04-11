class Solution {
    public int maxSubArray(int[] nums) {
        int[] maxSum = { Integer.MIN_VALUE };
        HashMap<String, Integer> mem = new HashMap<>();
        getSum(nums, 0, (nums.length -1), mem, maxSum);
        return maxSum[0];
    }

    private int totalSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private int getSum(int[] nums, int startIndex, int endIndex, HashMap<String, Integer> mem, int[] maxSum int totalSum) {
        String key = new StringBuilder().append(startIndex).append(endIndex).toString();
        int sum = 0;
        if (mem.containsKey(key)) {
            return mem.get(key);
        } else if (startIndex == endIndex) {
            sum = nums[startIndex];
        } else {
            for (int i = startIndex; i < endIndex; i++) {
                sum = getSum(nums, startIndex, i, mem, maxSum)
                      + getSum(nums, (i + 1), endIndex, mem, maxSum);
            }
        }
        if (sum > maxSum[0]) {
            maxSum[0] = sum;
        }
        mem.put(key, sum);
        return sum;
    }
}