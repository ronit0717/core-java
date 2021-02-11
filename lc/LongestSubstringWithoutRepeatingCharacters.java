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

//abba