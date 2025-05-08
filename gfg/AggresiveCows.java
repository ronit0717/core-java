class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls); //sort to ensure min dist between two cows is between two adjacent stalls
        int n = stalls.length;
        int min = 1;
        int max = stalls[n - 1] - stalls[0];
        
        int ans = 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (isPossible(mid, stalls, k)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }
    
    private static boolean isPossible(int dist, int[] stalls, int k) {
        int count = 1;
        int last = 0; //first cow is placed at 0th stall (Greedy), to ensure we can maximise the placement of cows
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[last] >= dist) {
                count++;
                last = i;
                if (count == k) {
                    return true;
                }
            }
        }
        return false;
    }
}