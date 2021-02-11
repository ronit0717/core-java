class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> compMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (compMap.containsKey(nums[i])) {
                return new int[]{compMap.get(nums[i]), i};
            }
            compMap.put((target - nums[i]), i);
        }
        return null;
    }
}