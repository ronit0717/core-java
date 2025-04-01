class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c) && map.get(c) >= i) {
                i = 1 + map.get(c);
            }
            map.put(c, j);
            int len = j - i + 1;
            maxLen = Math.max(len, maxLen);
            j++;
        }
        return maxLen;
    }
}