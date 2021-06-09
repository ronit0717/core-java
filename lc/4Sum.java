/* Solution 2: TC = O(N^3), SC = O(1)
Algo:
1. Sort the array
2. Select two pointers i and j and use nested loop, Increment the pointers in such a way to avoid duplicates (all duplicates will be adjacent)
3. Now that i and j is know, the right side of j, use two pointers start and end
4. While, start < end, find val = target - nums[i] - nums[j] - nums[start] - nums[end]
    4.1. If val == 0 => add to result rest, increment start, decrement end such that no duplicates
    4.2. Else If val > 0 => increment start, such that no duplicates
    4.3. Else => Descrement end, such that no duplicates

*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        
        int prevI = -1;
        int prevJ = -1;
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && prevI == nums[i]) { //this will avoid duplicate set
                continue;
            }
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != (i + 1) && prevJ == nums[j]) { //this will avoid duplicate set
                    continue;
                }
                
                int start = j + 1;
                int end = nums.length - 1;
                
                while (start < end) {
                    int val = target - nums[i] - nums[j] - nums[start] - nums[end];
                    if (val == 0) {
                        addSet(res, nums[i], nums[j], nums[start], nums[end]);
                        start = getNextStart(nums, start);
                        end = getNextEnd(nums, end, j);
                    } else if (val > 0) {
                        start = getNextStart(nums, start);
                    } else {
                        end = getNextEnd(nums, end, j);
                    }
                }
                
                prevJ = nums[j];
            }
            
            prevI = nums[i];
        }
        return res;
    }
    
    private int getNextStart(int[] nums, int currStart) {
        int newStart = currStart + 1;
        while (newStart < nums.length && nums[newStart] == nums[currStart]) {
            newStart++;
        }
        return newStart;
    }
    
    private int getNextEnd(int[] nums, int currEnd, int j) {
        int newEnd = currEnd - 1;
        while (newEnd >= j && nums[newEnd] == nums[currEnd]) {
            newEnd--;
        }
        return newEnd;
    }
    
    private void addSet(List<List<Integer>> res, int i, int j, int k, int l) {
        List<Integer> list = new LinkedList<>();
        list.add(i);
        list.add(j);
        list.add(k);
        list.add(l);
        res.add(list);
    }
}

/*******************************************************************************************************************************************************************/

/* Solution 1, TC = N^3(LogN), SC = O(1)
Algo:
1. Sort the array
2. Select three pointers i, j and k and use nested loop, Increment the pointers in such a way to avoid duplicates (all duplicates will be adjacent)
3. Once we have i, j and k, we know the fourth number should be => val = target - nums[i] - nums[j] - nums[k]
4. Search the val in the right of k with binary search approach
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int prevI = -1;
        int prevJ = -1;
        int prevK = -1;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && prevI == nums[i]) { //this will avoid duplicate set
                continue;
            }
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != (i + 1) && prevJ == nums[j]) { //this will avoid duplicate set
                    continue;
                }
                
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k != (j + 1) && prevK == nums[k]) { //this will avoid duplicate set
                        continue;
                    }
                    int val = target - nums[i] - nums[j] - nums[k];
                    //binary search val
                    int start = k + 1;
                    int end = nums.length - 1;
                    while (start <= end) {
                        int mid = (start + end)/2;
                        if (val == nums[mid]) {
                            addSet(res, nums[i], nums[j], nums[k], nums[mid]);
                            break;
                        } else if (val > nums[mid]) {
                            start = mid+1;
                        } else {
                            end = mid-1;
                        }
                    }
                    
                    prevK = nums[k];
                }
                
                prevJ = nums[j];
            }
            
            prevI = nums[i];
        }
        return res;
    }
    
    private void addSet(List<List<Integer>> res, int i, int j, int k, int l) {
        List<Integer> list = new LinkedList<>();
        list.add(i);
        list.add(j);
        list.add(k);
        list.add(l);
        res.add(list);
    }
}