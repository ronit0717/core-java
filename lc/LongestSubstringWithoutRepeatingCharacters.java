class Solution {
    public int lengthOfLongestSubstring(String s) {
    	HashMap<Character, Integer> mySet = new HashMap<Character, Integer>();
    	int result = 0;
    	int lenCount = 0;
    	int i = 0;
        while(i < s.length()) {
        	char myChar = s.charAt(i);
        	if (mySet.containsKey(myChar)) {
        		if (lenCount > result) {
        			result = lenCount;
        		}
        		lenCount = 0;
        		i = mySet.get(myChar) + 1;
        		myChar = s.charAt(i);
        		mySet.clear();
        	}
        	lenCount++;
        	mySet.put(myChar, i);
        	i++;
        }
        if (lenCount > result) {
        	result = lenCount;
        }
        return result;
    }
}