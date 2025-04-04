class Solution {
    public String minWindow(String s, String t) {
        int i = 0;
        int j = 0;
        int target = t.length();
        int currLen = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;

        Map<Character, Integer> map = initMap(t);

        while(j < s.length()) {
            char c = s.charAt(j);
            int count = map.getOrDefault(c, 0);
            if (count > 0) {
                currLen++;
            }
            count--;
            map.put(c, count);
            while(currLen == target) {
                int len = j - i + 1;
                if (len < minLen) {
                    startIndex = i;
                    minLen = len;
                }
                //remove from left
                c = s.charAt(i);
                count = map.get(c);
                count++;
                if (count > 0) {
                    currLen--;
                }
                map.put(c, count);
                i++;
            }
            j++;
        }

        if (startIndex == -1) {
            return "";
        }
        int endIndex = startIndex + minLen;
        return s.substring(startIndex, endIndex);
    }

    private Map<Character, Integer> initMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
        }
        return map;
    }
}