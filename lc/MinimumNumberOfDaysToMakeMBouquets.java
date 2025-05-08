class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long total = (long)m * k;
        if (total > bloomDay.length) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int flower : bloomDay) {
            min = Math.min(min, flower);
            max = Math.max(max, flower);
        }
        int ans = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        int currCount = 0;
        for (int flower : bloomDay) {
            if (flower <= day) {
                currCount++;
            } else {
                count += (currCount / k);
                if (count >= m) {
                    return true;
                }
                currCount = 0;
            }
        }
        count += currCount / k;
        return count >= m;
    }
}