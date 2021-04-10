class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        combinationSum(candidates, target, null, result);
        return result;
    }

    private void combinationSum(int[] candidates, int target, List<Integer> candidateSet, List<List<Integer>> result) {
    	for (int i = 0; i < candidates.length; i++) {
    		if (candidates[i] <= target) {
    			List<Integer> newCandidateSet = cloneCandidateSet(candidateSet);
    			newCandidateSet.add(candidates[i]);
    			int newTarget = target - candidates[i];
    			if (newTarget != 0) {
    				combinationSum(candidates, newTarget, newCandidateSet, result);
    			} else {
    				checkAdd(result, newCandidateSet);
    			}
    		}
    	}
    }

    private List<Integer> cloneCandidateSet(List<Integer> candidateSet) {
    	List<Integer> clone = new LinkedList<>();
    	if (candidateSet == null) {
    		return clone;
    	}
    	for (Integer i : candidateSet) {
    		clone.add(i);
    	}
    	return clone;
    }

    private void checkAdd(List<List<Integer>> result, List<Integer> candidateSet) {
    	HashMap<Integer, Integer> candidateMap = getFrequencyOfSet(candidateSet);
    	boolean distinct = true;
    	for(List<Integer> set : result) {
    		HashMap<Integer, Integer> setMap = getFrequencyOfSet(set);
    		if (isMatch(setMap, candidateMap)) {
    			return;
    		}
    	}
    	result.add(candidateSet);
    }

    private boolean isMatch(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
    	for (Map.Entry<Integer, Integer> set : map1.entrySet()) {
    		if (!(map2.containsKey(set.getKey()) && map2.get(set.getKey()) == set.getValue())) {
    			return false;
    		}
    	}
    	return true;
    }

    private HashMap<Integer, Integer> getFrequencyOfSet(List<Integer> set) {
    	HashMap<Integer, Integer> candidateMap = new HashMap<>();
    	for (Integer i : set) {
    		int val = 0;
    		if (candidateMap.containsKey(i)) {
    			val = candidateMap.get(i);
    		}
    		val++;
    		candidateMap.put(i, val);
    	}
    	return candidateMap;
    }

}