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