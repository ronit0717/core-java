//Solution 3: Same time complexity as solution 2. More clean code
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = 0;
        boolean done = false;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    done = true;
                    break;
                }
            }
            if (done) {
                break;
            }
            len++;
        }
        if (len == 0) {
            return "";
        }
        return strs[0].substring(0, len);
    }
}

//Solution 2: TC = O(M*N), where M is length of prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        boolean done = false;
        while(true) {
            if (index >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= index || strs[i].charAt(index) != c) {
                    done = true;
                    break;
                }
            }
            if (done) {
                break;
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
} 

//Solution 1: TC = O(NLogN + O(N*M)) -> M is length of smallest string
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