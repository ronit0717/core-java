/*
TC = O(N) for iteration + O(N) for removal = O(2N) = O(N)
SC = O(k) is the max deque size

Algo: DQ will always store indexes of elements in decreasing order

1. Iterate the array
    1.1 If the peek (largest element in front) is out of range, remove it
    1.2 Remove all the elements smaller than current element from back
    1.3 Add index of current element at the end
    1.4 In result array, update the element for index at front (largest element)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //remove out of range elements
            if (!dq.isEmpty() && dq.peek() == (i - k)) {
                dq.poll();
            }
            //remove smaller elements from qd
            while(!dq.isEmpty()) {
                if (nums[dq.peekLast()] < nums[i]) {
                    dq.pollLast();
                } else {
                    break;
                }
            }
            dq.offer(i);
            
            //result update
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peek()];
            }
        }
        return res;
    }
}