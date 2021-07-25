/* Solution 3 : Using DP
TC = O(N^2)

Iterate from len = 1 to stringlength
    Iterate start = 0 .. stringlength - 1
        end = start + len - 1;

        if (len == 1) => palindrome satisfied, fill in dp
        else if (len == 2) => palindromeCheck = (charAt(i) == charAt(j))
        else, check = (charAt(i) == charAt(j)) && dp[inner_index], where inner_index = stringLength * (start + 1) + (end - 1)
*/

//Tabulation
class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int stringLength = s.length();
        boolean dp[] = new boolean[stringLength * stringLength];
        String longestPalindrome = null;
        for (int len = 1; len <= stringLength; len++) {
            for (int i = 0; i < stringLength; i++) {
                int j = i + len - 1;
                if (j >= stringLength) {
                    continue;
                }
                
                int index = i * stringLength + j;
                boolean check = false;
                
                if (len == 1) {
                    check = true;
                } else if (len == 2) {
                    check = (s.charAt(i) == s.charAt(j));
                } else {
                    int lastIndex = (i + 1) * stringLength + (j - 1);
                    check = (s.charAt(i) == s.charAt(j) && dp[lastIndex]);
                }
                
                dp[index] = check;
                
                if (check && len > maxLen) {
                    maxLen = len;
                    longestPalindrome = s.substring(i, j + 1);
                }
            }
        }
        return longestPalindrome;
    }
}

//Memoization
public String longestPalindrome(String s) {
    HashMap<Integer, Boolean> dp = new HashMap<>();
    int maxLen = 0;
    int stringLength = s.length();
    String longestPalindrome = null;
    for (int len = 1; len <= stringLength; len++) {
        for (int i = 0; i < stringLength; i++) {
            int j = i + len - 1;
            if (j >= stringLength) {
                continue;
            }
            
            int index = i * stringLength + j;
            boolean check = false;
            
            if (len == 1) {
                check = true;
            } else if (len == 2) {
                check = (s.charAt(i) == s.charAt(j));
            } else {
                int lastIndex = (i + 1) * stringLength + (j - 1);
                check = (s.charAt(i) == s.charAt(j) && dp.get(lastIndex));
            }
            
            dp.put(index, check);
            
            if (check && len > maxLen) {
                maxLen = len;
                longestPalindrome = s.substring(i, j + 1);
            }
        }
    }
    return longestPalindrome;
}

/*
For each character, move outwards and check if palindrome condition is being satisfied
TC = O(N) * O(N/2) = O(N^2)
*/
class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String result = null;
        for (int i = 0; i < s.length(); i++) {
            String palSubstring = palCheck(i, s, true);
            if (palSubstring.length() > maxLen) {
                result = palSubstring;
                maxLen = palSubstring.length();
            }
            
            if (i == s.length() - 1) {
                continue;
            }
            
            palSubstring = palCheck(i, s, false);
            if (palSubstring.length() > maxLen) {
                result = palSubstring;
                maxLen = palSubstring.length();
            }
        }
        return result;
    }
    
    private String palCheck(int i, String s, boolean oddCase) {
        int start = i;
        int end = oddCase ? i : i + 1;
        
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}

/*
Solution 1: BRUTE

use a nested for loop
i -> 0 .. N - 1
j -> 1 .. N
All possible substring check if palindrome 

TC = O(N^2) for nested for loop * O(N) to check palindrom = O(N^3)

*/