class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashMap<Integer, List<List<Integer>>> mem = new HashMap<>();
        return combSum(candidates, target, mem);
    }

    private List<List<Integer>> combSum(int[] candidates, 
                                        int target,
                                        HashMap<Integer, List<List<Integer>>> mem) {
        if (mem.containsKey(target)) {
            return cloneResult(mem.get(target));
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == target) {
                List<Integer> set = new LinkedList<Integer>();
                set.add(candidates[i]);
                checkAdd(result, set);
            } else if (candidates[i] < target) {
                List<List<Integer>> innerResult = combSum(candidates, (target - candidates[i]), mem);
                if (innerResult.isEmpty()) {
                    continue;
                }
                for (List<Integer> set : innerResult) {
                    set.add(candidates[i]);
                    checkAdd(result, set);
                }
            }
        }
        mem.put(target, cloneResult(result));
        return result;
    }

    private List<List<Integer>> cloneResult(List<List<Integer>> list) {
        List<List<Integer>> result = new LinkedList<>();
        for (List<Integer> set : list) {
            List<Integer> newSet = new LinkedList<>();
            for (Integer i : set) {
                newSet.add(i);
            }
            result.add(newSet);
        }
        return result;
    }

    private void checkAdd(List<List<Integer>> result, List<Integer> candidateSet) {
        HashMap<Integer, Integer> candidateMap = getFrequencyOfSet(candidateSet);
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

/*
If hashMap being used as mem, ensure a copy is returned, else the mem gets altered
*/