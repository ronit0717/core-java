/* TC = O(N) + O(N) + O(N) = O(N)
Algo:
1. Add all the numbers in hashset
2. Iterate the numbers, if (currNum - 1) not in hashSet this can be the minimum 
number in the consecutive sequence, increase the number by 1 and check the max length of 
consecutive sequence
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            set.add(i);
        }
        int maxCount = 0;
        for (Integer i : nums) {
            int count = 1;
            if (!set.contains(i - 1)) {
                int next = i + 1;
                while (set.contains(next)) {
                    count++;
                    next++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}