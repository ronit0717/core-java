/* Solution 3: Using partition algorithm of quick sort
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
        int ans = -1;
        while(true) {
            int index = quickSort(nums, start, end);
            if (index == (k - 1)) {
                ans = nums[index];
                break;
            } else if (index >= k) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return ans;
    }

    //returns the partition index
    private int quickSort(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while(left <= right) {
            if (nums[left] < pivot && nums[right] > pivot) {
                //swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
                continue;
            }
            if (nums[left] >= pivot) {
                left++;
            }
            if (nums[right] <= pivot) {
                right--;
            }
        }
        //swap pivot element with element in right index
        nums[start] = nums[right];
        nums[right] = pivot;
        return right;
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


//Solution 2.2 (Max Heap)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 1; i < k; i++) {
            pq.poll();
        }
        return pq.peek();
    }
}

//Solution 2.3 (Min Heap) => TC = O(KLogK) + O((N-K)(LogK)) = O(NLogK)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
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