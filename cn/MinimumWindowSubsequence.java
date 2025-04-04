public class Solution {
    
    public static String minWindow(String S, String T) {
        // Write your code here

        int tIndex = 0;
        int i = 0;
        int j = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;
        while(j < S.length()) {
            if (S.charAt(j) == T.charAt(tIndex)) {
                tIndex++;
            }
            if (tIndex == T.length()) { //all characters of T covered
                int k = j;
                int newTIndex = tIndex - 1;
                //find the subsequence in reverse
                while(newTIndex >= 0) {
                    if(S.charAt(k) == T.charAt(newTIndex)) {
                        newTIndex--;
                    }
                    k--;
                }
                int len = j - k;
                if (len < minLen) {
                    startIndex = k + 1;
                    minLen = len;
                }
                //reset
                i = k + 2; //1 ahead of current startindex
                j = k + 1; //same as startIndex, because at the end of the iteration we will again increment j
                tIndex = 0;
            }
            j++;
        }
        if (startIndex == -1) {
            return "";
        }
        int endIndex = startIndex + minLen;
        return S.substring(startIndex, endIndex);
    }
}