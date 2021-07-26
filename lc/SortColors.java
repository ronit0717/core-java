//Solution 2 : Cleaner Code
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        
        for (int i = 0; i <= two; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[zero];
                nums[zero] = 0;
                zero++;
            } else if (nums[i] == 2) {
                nums[i] = nums[two];
                nums[two] = 2;
                two--;
                i--; //to revaluate
            }
        }
    }
}


//Solution 1
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