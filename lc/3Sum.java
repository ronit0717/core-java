//Solution 2: TC = O(N^2), SC = O(1)
/*
Approach similar to 4 sum
Sort the numbers
for all i from 0 to n-2, two pointers start and end, such that condition is met
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int target = -1 * nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (target == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(list);
                    start++;
                    end--;
                    while (start < nums.length && end >= 0 && nums[start] == nums[start - 1] && nums[end] == nums[end + 1]) {
                        start++;
                        end--;
                    } 
                } else if (target < sum) {
                    end = decrementEnd(nums, end);
                } else {
                    start = incrementStart(nums, start);
                }
            }
        }
        return res;
    }
    
    private int incrementStart(int[] nums, int start) {
        start++;
        while (start < nums.length && nums[start] == nums[start - 1]) {
            start++;
        }
        return start;
    }
    
    private int decrementEnd(int[] nums, int end) {
        end--;
        while (end >= 0 && nums[end] == nums[end + 1]) {
            end--;
        }
        return end;
    }
}

//Solution 1: Using HashMap, TC = O(N^2), SC = O(N)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                int target = -1 * (nums[i] + nums[j]);
                if (map.containsKey(target) && map.get(target) > j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    res.add(list);
                }
            }
        }
        return res;
    }
}

//Solution 0: Brute force with 3 nested loops