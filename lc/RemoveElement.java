class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
        	if (i == j) {
				if (nums[j] == val) {
					return j;
				} else {
					return ++j;
				}
			}
			if (nums[j] == val) {
				j--;
			} else if (nums[i] == val) {
				//swap
				nums[i] = nums[j];
				j--;
			} else {
				i++;
			}
        }
        return 0; //here it will never come
    }
}