/*

Given an integer array, check if it represents min-heap or not.

Input : [2, 3, 4, 5, 10, 15]
Output: true
Explanation: The input represents a min-heap.

		   2
		 /   \
		/	  \
	   3	   4
	  / \	  /
	 /   \   /
	5	 10 15

Input : [2, 10, 4, 5, 3, 15]
Output: false
Explanation: The input is not a min-heap, as it violate the heap property.

		   2
		 /   \
		/	  \
	   10	   4
	  / \	  /
	 /   \   /
	5	  3 15

*/

//Solution 1: Recursive Solution
class Solution
{
	public static boolean checkMinHeap(int[] nums)
	{
		// Write your code here...
		if (nums == null || nums.length == 0) {
			return true;
		}
		return  check(nums, 0);
		
	}
	
	private static boolean check(int[] nums, int index) {
		int n = nums.length;
		if (index > n / 2) {
			return true; //leaf node
		}
		
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		int leftVal = (leftIndex >= n) ? Integer.MAX_VALUE : nums[leftIndex];
		int rightVal = (rightIndex >= n) ? Integer.MAX_VALUE : nums[rightIndex];
		if (leftVal < nums[index] || rightVal < nums[index]) {
			return false;
		}
		return check(nums, leftIndex) && check(nums, rightIndex);
	}
}

//Solution 2: Iterative solution
class Solution
{
	public static boolean checkMinHeap(int[] nums)
	{
		// Write your code here...
		int n = nums.length;
		if (n == 0) {
			return true;
		}
		for (int i = 0; i <= n/2; i++) {
			int leftIndex = 2 * i + 1;
			int rightIndex = 2 * i + 2;
			int leftVal = (leftIndex >= n) ? Integer.MAX_VALUE : nums[leftIndex];
			int rightVal = (rightIndex >= n) ? Integer.MAX_VALUE : nums[rightIndex];
			int val = nums[i];
			if (leftVal < val || rightVal < val) {
				return false;
			}
		}
		return true;
		
	}
}
