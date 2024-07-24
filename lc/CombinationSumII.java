/* Solution 1: TC = O(2^N) => number of subsequences = N-C-1 + N-C-2 + .... + N-C-N, SC = O(2^N)
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new LinkedList();
        List<Integer> selectedCandidates = new LinkedList();
        execute(0, target, candidates, selectedCandidates, answer);
        return answer;
    }

    private void execute(int index, 
                         int target, 
                         int[] candidates, 
                         List<Integer> selectedCandidates, 
                         List<List<Integer>> answer) {
        
        if (target == 0) {
            answer.add(new LinkedList<>(selectedCandidates));
            return;
        }
        int prev = -1;
        for (int i = index; i < candidates.length; i++) {
            int curr = candidates[i];
            if (prev == curr) {
                continue;
            }
            if (curr > target) {
                break;
            }
            selectedCandidates.add(curr);
            execute(i + 1, target - curr, candidates, selectedCandidates, answer);
            selectedCandidates.removeLast();
            prev = curr;
        }
    }

}