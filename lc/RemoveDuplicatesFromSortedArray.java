class Solution {
    public int removeDuplicates(int[] nums) {
		if (nums.length == 1) {
			return 1;
		}
		int curr = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[curr] != nums[i]) {
				nums[curr + 1] = nums[i];
				curr++;
			}
		}
		return curr++;
    }
}

/*
0, >1, 1, 1, 1, 2, 2, 3, 3, 4

if nums.length = 1, return 1
int curr = 0;
for (1 .. n) {
	if (nums[curr] != nums[i]) {
		nums[curr + 1] = nums[i];
		curr++;
	}
}
return curr++;
*/