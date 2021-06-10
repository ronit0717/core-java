//Cleaner solution TC = O(N), SC = O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                int len = i - start;
                maxLen = Math.max(len, maxLen);
                start = map.get(c) + 1;
            }
            map.put(c, i);
        }
        int len = s.length() - start;
        maxLen = Math.max(len, maxLen);
        return maxLen;
    }
}

//TC = O(N), SC = O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	HashMap<Character, Integer> mySet = new HashMap<Character, Integer>();
    	int result = 0;
    	int lenCount = 0;
    	int newStartIndex = 0;
        for (int i=0; i < s.length(); i++) {
        	char myChar = s.charAt(i);
        	if (mySet.containsKey(myChar) && mySet.get(myChar) >= newStartIndex) {
        		newStartIndex = mySet.get(myChar) + 1;
        		if (lenCount > result) {
        			result = lenCount;
        		}
        		lenCount = i - mySet.get(myChar) - 1;
        	}
        	lenCount++;
        	mySet.put(myChar, i);
        }
        if (lenCount > result) {
        	result = lenCount;
        }
        return result;
    }
}