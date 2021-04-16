public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> result = null;
        ArrayList<Integer> set = null;
        
        long maxSum = Long.MIN_VALUE;
        long currSum = 0L;
        
        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) < 0) && (set != null) ) {
                if (currSum > maxSum) {
                    maxSum = currSum;
                    result = new ArrayList<>(set);
                } else if (currSum == maxSum) {
                    if (result.size() < set.size()) {
                        result = new ArrayList<>(set);
                    }
                }
                set = null;
            } else if (A.get(i) >= 0) {
                if (set == null) {
                    set = new ArrayList<>();
                    set.add(A.get(i));
                    currSum = (long)A.get(i);
                } else {
                    currSum += (long)A.get(i);
                    set.add(A.get(i));   
                }
            }
        }
        
        if (result == null && set == null) {
            return new ArrayList<>();
        }
        
        if (set != null) {
            if (currSum > maxSum) {
                result = set;
            } else if (currSum == maxSum) {
                if (result.size() < set.size()) {
                    result = new ArrayList<>(set);
                }
            }    
        }
        
        
        return result;
    }
}
