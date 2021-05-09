public class Solution {
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> heightMap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            heightMap.put(A.get(i), B.get(i));
        }
        Collections.sort(A);
        Integer[] res = new Integer[A.size()];
        for (int i = 0; i < A.size(); i++) {
            int maxEmpty = heightMap.get(A.get(i));
            int count = -1;
            for (int j = 0; j < A.size(); j++) {
                if (res[j] == null) {
                    count++;
                    if (count == maxEmpty) {
                        res[j] = A.get(i);
                        break;
                    }
                }
            }
            
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < res.length; i++) {
            output.add(res[i]);
        }
        return output;
    }
}
