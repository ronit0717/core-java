/*
TC = O(N) for iteration + O(N) for removal = O(2N) = O(N)
SC = O(k) is the max deque size

Algo: DQ will always store indexes of elements in decreasing order (largest value in front)

1. Iterate the array
    1.1 If the peek (largest element in front) is out of range, remove it
    1.2 Remove all the elements smaller or equal than current element from back
    1.3 Add index of current element at the end
    1.4 In result array, update the element for index at front (largest element)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                int removeIndex = i - k;
                if (dq.peekFirst() == removeIndex) {
                    dq.pollFirst();
                }
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= (k - 1)) {
                ans[pointer] = nums[dq.peekFirst()];
                pointer++;
            }
        }
        return ans;
    }
}