//https://www.geeksforgeeks.org/count-number-subarrays-given-xor/

/* TC = O(N)
Concept x ^ y = z  => x ^ x ^ y = z * x => then y = z ^ x

As we loop we maintain the current xor from leftmost index to current index
If current xor == required xor, then increment count
Else If current xor ^ required xor is present in map, this means that all those subarrays
will also give me the required xor

nums  :	4	2	2	6	4
xor   :	4	6	4	2	6
xor^m :	2	0	2	4	0

All the substring that will give xor = 6
{4,2}
{4,2,2,6,4}
{2,2,6}
{6}
*/

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int count = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            int target = xor ^ k;
            count += prefixMap.getOrDefault(target, 0);
            int prefixCount = prefixMap.getOrDefault(xor, 0);
            prefixCount++;
            prefixMap.put(xor, prefixCount);
        }
        return count;
    }
}