public class Solution {
    public ArrayList < Integer > dNums(ArrayList < Integer > A, int B) {
        if (B > A.size()) {
            return null;
        }
        ArrayList < Integer > result = new ArrayList < > ();
        HashMap<Integer, Integer> memMap = new HashMap<>();
        HashMap < Integer, Integer > currMap = null;
        for (int i = 0; i < A.size(); i++) {
            
            if (i >= B) {
                if (memMap.containsKey(A.get(i - B))) {
                    int existingCount = memMap.get(A.get(i - B));
                    if (existingCount == 1) {
                        memMap.remove(A.get(i - B));
                    } else {
                        memMap.put(A.get(i - B), (existingCount - 1));
                    }
                }
            }
            
            int count = 1;
            if (memMap.containsKey(A.get(i))) {
                count += memMap.get(A.get(i));
            }
            memMap.put(A.get(i), count);

            if (i >= (B - 1)) {
                result.add(memMap.size());
            }
        }
        return result;
    }
}