class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a, b) -> (b.length() - a.length()));   //sort all strings in reverse of length
                    
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { //current prefix not working
                prefix = prefix.substring(0, prefix.length() - 1); //remove last character of prefix and retry
                if (prefix.length() == 0) {
                    return prefix;
                }
            }
        }
        return prefix;
    }
}