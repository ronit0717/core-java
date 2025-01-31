//Print LCS Any One
import java.util.*;

public class Main {
    public static void main(String[] args) {
      String s1 = "abcde";
      String s2 = "bdgek";
      
      int m = s1.length();
      int n = s2.length();
      int dp[][] = new int[m][n];
      for (int i = m - 1; i >= 0 ; i--) {
        for (int j = n - 1; j >= 0; j--) {
          int len = 0;
          if (s1.charAt(i) == s2.charAt(j)) {
            len = 1;
            if (i != (m - 1) && j != (n - 1)) {
              len += dp[i + 1][j + 1];
            }
          } else {
            int len1 = (i == (m - 1)) ? 0 : dp[i + 1][j];
            int len2 = (j == (n - 1)) ? 0 : dp[i][j + 1];
            len = Math.max(len1, len2);
          }
          dp[i][j] = len;
        }
      }
      System.out.println("Printing DP");
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(dp[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println("LCS length = " + dp[0][0]);
      
      System.out.println("\nPrinting LCS");
      int k = 0;
      char[] lcs = new char[dp[0][0]];
      int i = 0;
      int j = 0;
      while (k < dp[0][0]) {
        if (s1.charAt(i) == s2.charAt(j)) {
          lcs[k] = s1.charAt(i);
          i++;
          j++;
          k++;
          continue;
        }
        if (i == m - 1 && j == n - 1) {
          break;
        }
        if (i == m - 1 || dp[i + 1][j] < dp[i][j + 1]) {
          j++;
        } else {
          i++;
        }
      }
      System.out.println(lcs);
  }
}