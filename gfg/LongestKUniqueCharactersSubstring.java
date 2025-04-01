//TC = O(N). Wrote the most optimised solution, which maintains the size of the max window
class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        Map<Character, Integer> map = new HashMap<>(); //freq
        int i = 0;
        int j = 0;
        int maxLen = -1;
        while(j < s.length()) {
            char jc = s.charAt(j);
            int count = map.getOrDefault(jc, 0);
            count++;
            map.put(jc, count);
            if (map.size() > k) {
                char ic = s.charAt(i);
                count = map.get(ic);
                count--;
                if (count == 0) {
                    map.remove(ic);
                } else {
                    map.put(ic, count);
                }
                i++;
            }
            if (map.size() == k) {
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
            j++;
        }
        return maxLen;
    }
}