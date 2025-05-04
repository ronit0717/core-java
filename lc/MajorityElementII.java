//Solution 1: Moore's majority element algorithm TC = O(N), SC = O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int large = 1000000001;
        int num1 = large;
        int num2 = large;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (num1 == nums[i]) {
                count1++;
            } else if (num2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
                //the following reset is actually not required
                if (count1 == 0) {
                    num1 = large;
                }
                if (count2 == 0) {
                    num2 = large;
                }
            }
        }

        //check
        List<Integer> ans = new ArrayList<>(2); //there can be max 2 majority elements
        int actualCount1 = 0;
        int actualCount2 = 0;
        for (int i = 0; i < n; i++) {
            if (num1 != large && nums[i] == num1) {
                actualCount1++;
            } else if (num2 != large && nums[i] == num2) {
                actualCount2++;
            }
        }
        if (actualCount1 > (n / 3)) {
            ans.add(num1);
        }
        if (actualCount2 > (n / 3)) {
            ans.add(num2);
        }
        return ans;
    }
}

//Solution 2: Using hashmap TC = O(N), SC = O(N)