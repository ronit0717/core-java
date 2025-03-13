//Solution 2: Using Hashmap (TC = O(N), SC=O(N)) considering constant time for hashmap operation
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                result[0] = map.get(val);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}

//Solution 1: Brute Force ->> Maintain two pointers i and j and check for the condition (TC ~ O(N^2))