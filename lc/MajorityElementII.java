//Solution 1: Moore's majority element algorithm TC = O(N), SC = O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = -1;
        int element2 = -1;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                element2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> res = new LinkedList<>();

        //Get the actual count as no guarantee that the two elements will satisfy condition
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            }
        }

        if (count1 > (nums.length/3) ) {
            res.add(element1);
        }
        if (count2 > (nums.length/3) ) {
            res.add(element2);
        }

        return res;
    }
}

//Solution 2: Using hashmap TC = O(N), SC = O(N)