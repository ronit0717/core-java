class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> prefixSumCountMap = new HashMap<>();
        int count = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
            long comp = sum - k;
            count += prefixSumCountMap.getOrDefault(comp, 0);
            int newCount = prefixSumCountMap.getOrDefault(sum, 0);
            newCount++;
            prefixSumCountMap.put(sum, newCount);
        }
        return count;
    }
}