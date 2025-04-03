class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        long sum = 0L;
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, -1);
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum +=  arr[i];
            long comp = sum - k;
            if (prefixSum.containsKey(comp)) {
                int j = prefixSum.get(comp);
                int len = i - j;
                maxLen = Math.max(len, maxLen);
            }
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        return maxLen;
    }
}