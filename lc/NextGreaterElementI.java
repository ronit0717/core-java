//Solution 2: Iterate from left to right (Slower solution, but stores nge for all the nums)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nge = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            int ngeVal = st.isEmpty() ? -1 : st.peek();
            nge.put(nums2[i], ngeVal);
            st.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nge.get(nums1[i]);
        }
        return ans;
    }
}

//Solution 1: Traverse array from left to right
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> nge = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!st.isEmpty() && st.peek() < nums2[i]) {
                nge.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nge.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}