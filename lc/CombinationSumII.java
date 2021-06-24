/* Solution 1: TC = O(2^N) => number of subsequences = N-C-1 + N-C-2 + .... + N-C-N, SC = O(2^N)
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        combUtil(0, target, candidates, null, res);
        return res;
    }
    
    private void combUtil(int index, int target, int[] candidates, List<Integer> cand, List<List<Integer>> res) {
        if (index == candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] == target) {
                List<Integer> newCand = (cand == null) ? new LinkedList<>() : new LinkedList<>(cand);
                newCand.add(candidates[i]);
                res.add(newCand);
                return;
            } else if (candidates[i] < target) {
                List<Integer> newCand = (cand == null) ? new LinkedList<>() : new LinkedList<>(cand);
                newCand.add(candidates[i]);
                combUtil(i + 1, target - candidates[i], candidates, newCand, res);
            } else {
                return; //as its sorted all the elements to the right will definitely greater than the target
            }
        }
    }
}