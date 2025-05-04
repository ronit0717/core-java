//Solution 2: TC = O(N^2), SC = O(1)
/*
Approach similar to 4 sum
Sort the numbers
for all i from 0 to n-2, two pointers start and end, such that condition is met
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ansList = new LinkedList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ansList.add(list);
                    j = incrementJ(nums, j);
                    k = decrementK(nums, k);
                } else if (sum > 0) {
                    k = decrementK(nums, k);
                } else {
                    j = incrementJ(nums, j);
                }
            }
        }
        return ansList;
    }

    private int incrementJ(int[] nums, int j) {
        j++;
        while(j < nums.length && nums[j] == nums[j - 1]) {
            j++;
        } 
        return j;
    } 

    private int decrementK(int[] nums, int k) {
        k--;
        while(k >= 0 && nums[k] == nums[k + 1]) {
            k--;
        }
        return k;
    }
}

//Solution 1: Using HashMap, TC = O(N^2), SC = O(N)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ansSet = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int complement = -1 * sum;
                if (set.contains(complement)) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(complement);
                    Collections.sort(list);
                    ansSet.add(list);
                }
                set.add(nums[j]);
            }
        }

        List<List<Integer>> ansList = new ArrayList<>(ansSet.size());
        for (List<Integer> list : ansSet) {
            ansList.add(list);
        }
        return ansList;
    }
}

//Solution 0: Brute force with 3 nested loops