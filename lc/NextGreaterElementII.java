//Solution 2 (Cleaner code)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            if (i < n) {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i % n]);
        }
        return nge;
    }
}

/*
Solution:

Steps:
1. Double the array, to make it circular
2. Iterate in reverse
    2.1 Compare the current element with elements in stack
    2.2 If the stack number is less than or equal to current element remove it
        Else, this is the next greater element
    2.3 If we dont find any next greater element assign -1 to next greater element array


Similar Question: Next Smaller Element
https://github.com/ronit0717/core-java/blob/master/gfg/NextSmallerElement.java

TC = O(2n + 2n)
Its not n^2 as we remove the elements as well, so a total of 2n times it can go in total across all
iterations
*/


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        
        //Double loop of nums array
        for (int i = (2*n - 1); i >= 0; i--) {
            int curr = nums[i % n];
            boolean done = false;
            while (!st.isEmpty()) {
                if (curr < st.peek()) {
                    res[i % n] = st.peek();
                    done = true;
                    break;
                } else {
                    st.pop();
                }
            }
            if (!done) {
                res[i % n] = -1;
            }
            st.push(curr);
        }
        return res;
    }
}