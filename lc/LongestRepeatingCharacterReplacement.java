//Solution 2: TC = O(N)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int maxFreq = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            freq[c - 'A']++;
            int len = j - i + 1;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
            int replaceCharCount = len - maxFreq;
            if (replaceCharCount <= k) {
                maxLen = Math.max(maxLen, len);
            } else {
                char removeChar = s.charAt(i);
                freq[removeChar - 'A']--;
                i++;
            }
            j++;
        }
        return maxLen;
    }
}

//Solution 1: TC = O(2N * 26)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0;
        int j = 0;
        int maxLen = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            freq[c - 'A']++;
            int len = j - i + 1;
            int maxFreq = getMaxFreq(freq);
            int replaceCharCount = len - maxFreq;
            while(replaceCharCount > k) {
                char removedChar = s.charAt(i);
                i++;
                freq[removedChar - 'A']--;
                maxFreq = getMaxFreq(freq);
                len = j - i + 1;
                replaceCharCount = len - maxFreq;
            }
            
            maxLen = Math.max(maxLen, len);
            j++;
        }
        return maxLen;
    }

    private int getMaxFreq(int[] freq) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, freq[i]);
        }
        return max;
    }
}