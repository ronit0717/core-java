public class Solution {
    public ArrayList < Integer > dNums(ArrayList < Integer > A, int B) {
        if (B > A.size()) {
            return null;
        }
        ArrayList < Integer > result = new ArrayList < > ();
        if (B == 1) {
            for (int i : A) {
                result.add(1);
            }
            return result;
        }
        ArrayList < HashMap < Integer, Integer >> mapList = new ArrayList < > ();
        HashMap < Integer, Integer > currMap = null;
        for (int i = 0; i < A.size(); i++) {
            if (i == 0) {
                currMap = new HashMap<>();    
            }
            int count = 1;
            if (currMap.containsKey(A.get(i))) {
                count += currMap.get(A.get(i));
            }
            currMap.put(A.get(i), count);

            if (i >= (B - 1)) {
                HashMap<Integer, Integer> oldMap = null;
                if (i >= B) {
                    oldMap = mapList.get(i % B);
                }
                int disCount = 0;
                for (Map.Entry < Integer, Integer > set: currMap.entrySet()) {
                    int setCount = set.getValue();
                    if (oldMap != null && oldMap.containsKey(set.getKey())) {
                        setCount -= oldMap.get(set.getKey());
                    }
                    if (setCount > 0) {
                        disCount++;
                    }
                }
                result.add(disCount);
                if (oldMap != null) {
                    oldMap.clear();
                }
            }
            
            if (i >= B) {
                mapList.set((i % B), (HashMap)currMap.clone());    
            } else {
                mapList.add((HashMap)currMap.clone());    
            }
            
        }
        return result;
    }
}