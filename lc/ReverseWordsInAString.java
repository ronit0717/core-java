/*
Solution 3: Reverse the string. Then find the word and reverse the word
*/
class Solution {

    private static final char space = ' ';

    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        reverse(0, charArr.length - 1, charArr);
        StringBuilder sb = new StringBuilder();
        boolean addSpace = false;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == space) {
                continue;
            }
            int j = i + 1;
            while(j < charArr.length && charArr[j] != space) {
                j++;
            }
            if (addSpace) {
                sb.append(space);
            } else {
                addSpace = true;
            }
            for (int k = j - 1; k >= i; k--) {
                sb.append(charArr[k]);
            } 
            i = j;
        }   
        return sb.toString();
    }

    private void reverse(int start, int end, char[] charArr) {
        while(start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
    }
}

/*
Solution 2: Find the ith index, first non space character
            Then find the next jth index, the first space character after i
            substring(i, j) prepend in string builder
*/

class Solution {
    public String reverseWords(String s) {
        int end = s.length();
        int i = 0;
        char space = ' ';
        StringBuilder sb = new StringBuilder();
        
        while (i < end) {
            if (s.charAt(i) == space) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < end && s.charAt(j) != space) {
                j++;
            }
            
            if (sb.length() != 0) {
                sb.insert(0, " ");
                sb.insert(0, s.substring(i, j));
            } else {
                sb.append(s.substring(i, j));
            }
            i = j + 1;
        }
        return sb.toString();
    }
}

/*
Solution 1: Find the last index of space, in range 0 to max
*/
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int end = s.length();
        String space = " ";
            
        while (end > 0) {
            int start = 0;
            int spaceIndex = s.indexOf(space, start);
            
            while(spaceIndex != -1 && spaceIndex < end) {
                start = spaceIndex + 1;
                spaceIndex = s.indexOf(space, start);
            }
            
            sb.append(s.substring(start, end)).append(" ");
            end = start - 1;
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            end++;
        }
        return sb.toString().trim();
    }
}