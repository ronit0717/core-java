/** Solution 2 : Similar approach*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        List<String> candidates = new LinkedList<>();       
        evaluate(s, 0, candidates, ans);
        return ans;
    }

    private void evaluate(String s, int index, List<String> candidates, List<List<String>> ans) {
        if (index >= s.length()) {
            ans.add(new LinkedList<>(candidates));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String subStr = s.substring(index, i);
            if(!isPalindrome(subStr)) {
                continue;
            }
            candidates.add(subStr);
            evaluate(s, i, candidates, ans);
            candidates.removeLast();
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (end >= start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}


/** Solution 1 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        partUtil(0, null, s, res);
        return res;
    }
    
    private void partUtil(int index, List<String> cand, String s, List<List<String>> res) {
        if (index == s.length()) {
            if (cand != null) {
                res.add(cand);   
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (palindromeCheck(s, index, i)) {
                List<String> newCand = cand == null ? new LinkedList<>() : new LinkedList<>(cand);
                newCand.add(s.substring(index, i+1));
                partUtil(i + 1, newCand, s, res);
            }
        }
    }
        
        
    private boolean palindromeCheck(String s, int start, int end) {
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