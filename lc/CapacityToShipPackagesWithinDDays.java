class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE; //max of the weights, as we need to ensure all weights are shipped
        int max = 0;
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
            min = Math.max(weight, min);
        }
        max = sum;
        int ans = 0;
        while(min <= max) {
            int mid = (min + max) / 2;
            if (isPossible(mid, weights, days)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int cap, int[] weights, int days) {
        int count = 1;
        int weightSum = 0;
        for (int weight : weights) {
            if ((weightSum + weight) > cap) {
                count++;
                if (count > days) {
                    return false;
                }
                weightSum = weight; //reset
            } else {
                weightSum += weight;
            }
        }
        return true;
    }
}