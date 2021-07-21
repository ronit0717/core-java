/* Solution 3: Using partition algorithm of quikr sort
Worst case = O(n^2), but average case fastest = O(NLogN)

Intuition: In partition algorithm, for each iteration the pivot element reaches
its correct position. And all the elements in left of the pivot element are smaller, and
all element in right are larger
So we need to find which element reaches the position (N - k)

So we need not completely sort the array, and get our answer.
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        boolean done = false;
        while (!done) {
            int pivot = start;
            for (int i = start; i <= end; i++) {
                if (nums[i] <= nums[end]) {
                    //swap
                    int temp = nums[pivot];
                    nums[pivot] = nums[i];
                    nums[i] = temp;
                    pivot++;
                }
            }
            pivot--; //note that pivot gets increase one extra time, hence reducing it
            if (pivot == (nums.length - k)) {
                return nums[pivot];
            } else if (pivot < (nums.length - k)) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
            
        }
        return -1;
    }
}

/* Solution 2: Using Min Heap
TC = O(NLogK), SC = O(K)
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.remove(); //removes the smallest element
            }
        }
        return pq.remove();
    }
}

/* Solution 1: using sorting
TC = O(NLogN), SC = O(1)
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}