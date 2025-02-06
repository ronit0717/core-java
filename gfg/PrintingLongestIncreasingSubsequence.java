class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        // Code here
        int[] dp = new int[n];
        int[] prev = new int[n]; //stores index of prev value of the LIS
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = i;
        }
        int lisIndex = 0;
        int lis = 1;
        for (int i = 1; i < n; i++) {
            int curr = dp[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    int newCurr = dp[i] + dp[j];
                    if (newCurr > curr) {
                        prev[i] = j;
                        curr = newCurr;
                    }
                }
            }
            dp[i] = curr;
            if (dp[i] > lis) {
                lisIndex = i;
                lis = dp[i];
            }
        }
        ArrayList<Integer> list = new ArrayList<>(lis);
        int j = lisIndex;
        for (int i = lis - 1; i >= 0; i--) {
            list.add(arr[j]);
            j = prev[j];
        }
       
        Collections.reverse(list);
        return list;
    }
}