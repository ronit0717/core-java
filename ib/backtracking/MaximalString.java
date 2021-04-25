public class Solution {
  private static String max = null;
  public String solve(String A, int B) {
    char[] c = new char[A.length()];

    //populate c
    for (int i = 0; i < A.length(); i++) {
      c[i] = A.charAt(i);
    }
    max = getStr(c);
    shuffle(0, c, B);
    return max;
  }

  private static void shuffle(int count, char[] c, int B) {
    String result;
    if (count == B) {
      String str = getStr(c);
      if (max == null || max.compareTo(str) < 0) {
        max = str;
      }
      return;
    }
    for (int i = count; i < c.length - 1; i++) {
      for (int j = i+1; j < c.length; j++) {
        if (c[i] == c[j]) {
            continue;
        }
        char[] cClone = c.clone();
        cClone[i] = c[j];
        cClone[j] = c[i];
        if (isShuffle(c, cClone)) {
            shuffle(count + 1, cClone, B);   
        }
      }
    }
  }
  
  private static boolean isShuffle(char[] c1, char[] c2) {
      String s1 = getStr(c1);
      String s2 = getStr(c2);
      if (s1.compareTo(s2) < 0) {
          return true;
      }
      return false;
  }

  private static String getStr(char[] c) {
    //create new string from c
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < c.length; i++) {
      sb.append(c[i]);
    }
    return sb.toString();
  }
}