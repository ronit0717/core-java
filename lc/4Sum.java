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
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ansList = new LinkedList<>();
        for (int i = 0; i < n - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j != (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }

                int p = j + 1;
                int q = n - 1;
                while(p < q) {
                    long sum = nums[i] + nums[j];
                    sum += nums[p];
                    sum += nums[q];
                    if (sum == target) {
                        ansList.add(buildList(nums[i], nums[j], nums[p], nums[q]));
                        p = incrementP(nums, p);
                        q = decrementQ(nums, q);
                    } else if (sum > target) {
                        q = decrementQ(nums, q);
                    } else {
                        p = incrementP(nums, p);
                    }
                }
            }
        }
        return ansList;
    }

    private int incrementP(int[] nums, int p) {
        p++;
        while(p < nums.length && nums[p] == nums[p - 1]) {
            p++;
        }
        return p;
    }

    private int decrementQ(int[] nums, int q) {
        q--;
        while(q >= 0 && nums[q] == nums[q + 1]) {
            q--;
        }
        return q;
    }

    private List<Integer> buildList(int a, int b, int c, int d) {
        List<Integer> list = new ArrayList<>(4);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        return list;
    }
}

//Solution 1 (TC = O(N^3) * LogM for the set)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ansSet = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long complement = target - sum;
                    if (set.contains(complement)) {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add((int)complement);
                        list.add(nums[k]);
                        Collections.sort(list);
                        ansSet.add(list);
                    }
                    set.add((long)nums[k]);                }
            }
        }
        List<List<Integer>> ansList = new ArrayList<>(ansSet.size());
        for (List<Integer> list : ansSet) {
            ansList.add(list);
        }
        return ansList;
    }
}

//Solution 0: Brute Force => 4 nested loops