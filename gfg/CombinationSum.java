class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> selectedCandidates = new LinkedList<>();
        compute(result, 0, candidates, 0, target, selectedCandidates);
        return result;
    }

    private void compute(List<List<Integer>> result, int index, int[] candidates, int currSum, int target, List<Integer> selectedCandidates) {

        if (index >= candidates.length || currSum > target) {
            return;
        }
        if (currSum == target) {
            List<Integer> selectedList = new LinkedList<>(selectedCandidates);
            result.add(selectedList);
            return;
        }
        
        //Select current element
        selectedCandidates.add(candidates[index]);
        compute(result, index, candidates, currSum + candidates[index], target, selectedCandidates);
        
        selectedCandidates.remove(selectedCandidates.size() - 1); //remove last element
        //Not Selected current element
        compute(result, index + 1, candidates, currSum, target, selectedCandidates);
    
    }
}