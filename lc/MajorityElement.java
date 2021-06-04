//Solution 2: Moore's Voting Algorithm TC = O(N), SC = O(1)
/*
1. set count = 0, element = -1
2. Loop all the elements
    2.1 If count = 0 => element = currentElement, count++, continue
    2.2 If element == currElement => count++;
        Else count--;
3. Return element

Intuition:
Since majority element occurence is more than n/2 times, so even after getting cancelled out with 
minority element, we will be left out with majority elements
*/
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
                count++;
                continue;
            }
            if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}



//Solution 1: Use hashmap to store count , TC = O(N), SC = O(N)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (map.containsKey(nums[i])) {
                count += map.get(nums[i]);
            }
            if (count > (nums.length / 2)) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return -1;
    }
}

//Solution 0: brute force TC = O(N^2), SC = O(1)
/*
for a given element at index i , for j = i + 1 to end count number of occurence
*/