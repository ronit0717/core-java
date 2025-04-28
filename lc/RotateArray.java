//Solution 2 (TC = O(2N), SC = O(1))
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int newK = k % len;
        rotateLeft(nums, (len - newK));
    }

    private void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
        reverse(0, n - 1, nums);
    }

    private void reverse(int start, int end, int[] nums) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

// Solution 1 (TC = O(N + k), SC = O(k))
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int newK = k % len;
        rotateLeft(nums, (len - newK));
    }

    private void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return;
        }
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        for (int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[n - k + i] = temp[i];
        }
    }
}