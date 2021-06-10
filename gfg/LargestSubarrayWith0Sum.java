//https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
/* TC = O(N)
Algo: Iterate and store the sum to to the left of curr in a hashmap
If the number repeats, it means the sum of the numbers in between the two gaps would be 0
*/

/* Solution 1 Single Pass solution*/
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0L;
        map.put(0L, -1);
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}

/* Solution 2  Two Pass Solution */
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Long, Integer[]> map = new HashMap<>();
        long sum = 0L;
        map.put(0L, new Integer[]{-1, -1});
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            Integer[] list = null;
            if (map.containsKey(sum)) {
                list = map.get(sum);
                list[1] = i;
            } else {
                list = new Integer[2];
                list[0] = i;
                list[1] = i;
            }
            map.put(sum, list);
        }
        if (sum == 0L) {
            return n;
        }
        int maxLen = 0;
        for (Map.Entry<Long, Integer[]> set : map.entrySet()) {
            Integer[] list = set.getValue();
            int len = list[1] - list[0];
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}