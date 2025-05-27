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
        String[][] dp = new String[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = "" + s.charAt(i);
                } else if (i > j) {
                    continue;
                } else {
                    boolean check = checkPalindrome(s, i, j);
                    if (check) {
                        dp[i][j] = s.substring(i, j + 1);
                    } else {
                        String ans1 = dp[i + 1][j];
                        String ans2 = dp[i][j - 1];
                        dp[i][j] = ans1.length() >= ans2.length() ? ans1 : ans2;
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    private boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

//Memoization
class Solution {

    public String longestPalindrome(String s) {
        String[][] dp = new String[s.length()][s.length()];
        return longestPalindromeUtil(s, 0, s.length() - 1, dp);
    }

    private String longestPalindromeUtil(String s, int start, int end, String[][] dp) {
        if (start > end || end < 0 || start >= s.length()) {
            return null;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        boolean check = checkPalindrome(s, start, end);
        String ans = null;
        if (check) {
            ans = s.substring(start, end + 1);
            dp[start][end] = ans;
            return ans;
        }
        String ans1 = longestPalindromeUtil(s, start + 1, end, dp);
        String ans2 = longestPalindromeUtil(s, start, end - 1, dp);
        ans = ans1.length() >= ans2.length() ? ans1 : ans2;

        dp[start][end] = ans;
        return ans;
    }

    private boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

/*
For each character, move outwards (in both direction) and check if palindrome condition is being satisfied
Note: Check for odd case, and even case
TC = O(N) * O(N/2) = O(N^2)
*/
class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String maxPalindrome = null;
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k < 2; k++) { //k = 0 -> odd case, k = 1 -> even case
                int start = i;
                int end = i + k;
                if (end == s.length() || s.charAt(start) != s.charAt(end)) {
                    continue;
                }
                int[] palRange = getPalindromeRange(start, end, s);
                int len = palRange[1] - palRange[0] + 1;
                if (len > maxLen) {
                    maxLen = len;
                    maxPalindrome = s.substring(palRange[0], palRange[1] + 1);
                }
            }
        }
        return maxPalindrome;
    }

    private int[] getPalindromeRange(int i, int j, String s) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return new int[]{i + 1, j - 1};
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