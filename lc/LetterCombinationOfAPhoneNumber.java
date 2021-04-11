class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        letterComb(digits, 0, "", result, map);
        return result;
    }
    
    private void letterComb(String digits, 
                            int index, 
                            String candidate, 
                            List<String> result, 
                            HashMap<Character, String> map) {
        if (digits.equals("")) {
            return;
        }
        if (index >= digits.length()) {
            result.add(candidate);
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            letterComb(digits, 
                       index + 1, 
                       new StringBuilder(candidate).append(letters.charAt(i)).toString(), 
                       result, 
                       map);
        }
    }
}