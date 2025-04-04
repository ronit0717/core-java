class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }

    private int count(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        while(j < nums.length) {
            int cand = nums[j];
            int candCount = freqMap.getOrDefault(cand, 0);
            candCount++;
            freqMap.put(cand, candCount);
            int size = freqMap.size();
            while(size > k) {
                cand = nums[i];
                candCount = freqMap.get(cand);
                candCount--;
                if (candCount == 0) {
                    freqMap.remove(cand);
                    size--;
                } else {
                    freqMap.put(cand, candCount);
                }
                i++;
            }
            if (size <= k) {
                int len = j - i + 1;
                count += len;
            }
            j++;
        }
        return count;
    }
}