//Array contains numbers >= 0

//Solution 2: TC = O(2N), SC=O(1) Sliding Window Two Pointer approach
//Note: This solution will not work if there are negative numbers
public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int i = 0;
        int j = 0;
        long sum = 0L;
        int maxLen = 0;
        while(j < a.length) {
            sum += a[j];
            while (sum > k) {
                sum -= a[i];
                i++;
            }
            if (sum == k) {
                int len = j - i + 1;
                maxLen = Math.max(len, maxLen); 
            }
            j++;
        }
        return maxLen;
    }
}

//Solution 1: TC ~ O(N). For ordered map with high collision can be O(NLogN). SC=O(N)
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        Map<Long, Integer> prefixSum = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        prefixSum.put(0L, -1);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            long comp = sum - k;
            if (prefixSum.containsKey(comp)) {
                int j = prefixSum.get(comp);
                int len = i - j;
                maxLen = Math.max(len, maxLen);
            }
            if (!prefixSum.containsKey(sum)) { //since we want the longest
                prefixSum.put(sum, i);
            }
        }
        return maxLen;
    }
}