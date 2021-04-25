public class Solution {
  private static HashMap < Character, String > keyMap;
  public ArrayList < String > letterCombinations(String A) {
    keyMap = new HashMap < > ();
    keyMap.put('0', "0");
    keyMap.put('1', "1");
    keyMap.put('2', "abc");
    keyMap.put('3', "def");
    keyMap.put('4', "ghi");
    keyMap.put('5', "jkl");
    keyMap.put('6', "mno");
    keyMap.put('7', "pqrs");
    keyMap.put('8', "tuv");
    keyMap.put('9', "wxyz");

    if (A == null || A.length() == 0) {
      return null;
    }

    ArrayList < String > result = new ArrayList < > ();
    backTrack(A, 0, "", result);
    return result;
  }

  private static void backTrack(String A, int index, String cand, List < String > result) {
    if (index == A.length()) {
      result.add(cand);
      return;
    }
    String keyStr = keyMap.get(A.charAt(index));
    for (int i = 0; i < keyStr.length(); i++) {
      String newCand = new StringBuilder(cand).append(keyStr.charAt(i)).toString();
      backTrack(A, index + 1, newCand, result);
    }

  }
}