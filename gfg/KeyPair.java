//Problem link: https://www.geeksforgeeks.org/problems/key-pair5616/1

//Two sum extension. Uses greedy approach post sorting the array
//TC = O(N), SC = O(1)
class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}