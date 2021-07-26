//Solution 1  //Linkedlist cycle approach : Basic intuition is that for duplicate number, two numbers are pointing to the same duplicate number
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            if(slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            if(slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

//Solution 2
class Solution {
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i] - 1] == 1) {
                return nums[i];
            }
            count[nums[i] - 1]++;
        }
        return 0;
    }
}

//Solution 3
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }
}

//Solution 4
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }    
        }
        return 0;
    }
}
