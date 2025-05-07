class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = piles[0];
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int ans = max;
        while (min <= max) {
            int mid = (min + max) / 2;
            long time = computeTime(piles, mid);
            if (time <= h) {
                max = mid - 1;
                ans = mid;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    private long computeTime(int[] piles, int rate) {
        long time = 0;
        for (int pile : piles) {
            time += (pile / rate) + (pile % rate == 0 ? 0L : 1L);
        }
        return time;
    }
}