class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int pos0 = 0;
        int pos2 = nums.length - 1;
        while (pos2 >= 0 && nums[pos2] == 2) {
            pos2--;
        }
        while (i <= pos2) {
            if (nums[i] == 0) {
                if (i > pos0) {
                    nums[i] = nums[pos0];
                    nums[pos0] = 0;
                }
                pos0++;
            } else if (nums[i] == 2) {
                nums[i] = nums[pos2];
                nums[pos2] = 2;
                pos2--;
                while (pos2 >=0 && nums[pos2] == 2) {
                    pos2--;
                }
                if (nums[i] != 2) {
                    continue;
                }
            }
            i++;
        }
    }
}