public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        int result = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) % 2 != 0) {
                count++;
            }
            if (freqMap.containsKey(count - B)) {
                result += freqMap.get(count - B);
            }
            int freqCount = 1;
            if (freqMap.containsKey(count)) {
                freqCount += freqMap.get(count);
            }
            freqMap.put(count, freqCount);
        }
        return result;
    }
}