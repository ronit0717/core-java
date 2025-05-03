/* TC = O(N) + O(N) + O(N) for counting = O(N)
Algo:
1. Add all the numbers in hashset
2. Iterate the numbers, if (currNum - 1) not in hashSet this can be the minimum 
number in the consecutive sequence, increase the number by 1 and check the max length of 
consecutive sequence
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer n : nums) {
            set.add(n);
        }
        int maxCount = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            //curr element is the smallest in the consecutive sequence
            int count = 1;
            while(set.contains(num + 1)) {
                num++;
                count++;
            }
            maxCount = Math.max(count, maxCount);
        }
        
        return maxCount;
    }
}

//Solution 2 (Sorting)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int maxCount = 1;
        int count = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]) {
                continue;
            }
            if ((nums[i] - prev) == 1) {
                count++;
                prev = nums[i];
                maxCount = Math.max(count, maxCount);
            } else {
                count = 1;
                prev = nums[i];
            }
        }
        return maxCount;
    }
}