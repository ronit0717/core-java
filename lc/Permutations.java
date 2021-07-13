/*
Solution 2: Using Swap method, swap and unswap!!
TC = O(n!) * O(n) for array clone = O(n * n!)
SC = O(1)
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        permuteUtil(0, nums, res);
        return res;
    }
    
    private void permuteUtil(int index, int[] nums, List<List<Integer>> res) {
        if (index == nums.length) {
            populateRes(res, nums);
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            swapUtil(index, i, nums);
            permuteUtil(index + 1, nums, res);
            swapUtil(index, i, nums);
        }
        
    }
    
    private void swapUtil(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
        
    private void populateRes(List<List<Integer>> res, int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        res.add(list);
    }
}

/*
Solution 1: Using recursion, TC = O(n!) * O(n) For removal = O(n * n!)
Approach: First fill the first position, what is left recursively fill other positions

Also an array can be used to store if a particular element is taken. Here we have used a list
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> numsList = getNumsList(nums);
        permuteUtil(numsList, new LinkedList<>(), res);
        return res;
    }
    
    private void permuteUtil(List<Integer> nums, List<Integer> cand, List<List<Integer>> res) {
        if (nums.size() == 0) {
            res.add(cand);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newCand = new LinkedList<>(cand);
            List<Integer> newNums = new LinkedList<>(nums);
            newCand.add(newNums.remove(i));
            permuteUtil(newNums, newCand, res);
        }
    }
    
    private List<Integer> getNumsList(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }
}

/*
In this approach, the numbers were all distinct.
In case there are duplicates, so there can be duplicate permutations as well, which may need to be avoided
Use solution of this problem for that, see solution 1 of following problem (Next permutation)
https://github.com/ronit0717/core-java/blob/master/lc/NextPermutation.java
*/