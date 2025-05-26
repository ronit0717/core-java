//Lenght of words should be same, and number of characters in each word should be same
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
            if (freq[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}