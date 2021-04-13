class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            int count = 0;
            char c = magazine.charAt(i);
            if (freq.containsKey(c)) {
                count = freq.get(c);
            }
            count++;
            freq.put(c, count);
        }
        HashMap<Character, Integer> ransomFreq = new HashMap<Character, Integer>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!freq.containsKey(c)) {
                return false;
            }
            int count = 0;
            if (ransomFreq.containsKey(c)) {
                count = ransomFreq.get(c);
            }
            count++;
            ransomFreq.put(c, count);
        }
        for(Map.Entry<Character, Integer> set : ransomFreq.entrySet()) {
            if (set.getValue() > freq.get(set.getKey())) {
                return false;
            }
        }
        return true;
    }
}