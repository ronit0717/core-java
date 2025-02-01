class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int lcs = 0;
                if (str1.charAt(i) == str2.charAt(j)) {
                    lcs = 1;
                    if (i != m - 1 && j != n - 1) {
                        lcs += dp[i + 1][j + 1];
                    }
                } else if (i != m - 1 || j != n - 1) {
                    int lcs1 = (i != m - 1) ? dp[i + 1][j] : 0;
                    int lcs2 = (j != n - 1) ? dp[i][j + 1] : 0;
                    lcs = Math.max(lcs1, lcs2);
                }
                dp[i][j] = lcs;
            }
        }
        //Printing Shortest Common Supersequence
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } else {
                if (i == m - 1) { //last row
                    sb.append(str2.charAt(j));
                    j++; //go right
                } else if (j == n - 1) { //last column
                    sb.append(str1.charAt(i));
                    i++; //go down
                } else if (dp[i][j + 1] > dp[i + 1][j]) {
                    sb.append(str2.charAt(j));
                    j++; //go right
                } else {
                    sb.append(str1.charAt(i));
                    i++; //go down
                }
            }
        }
        while (i < m) {
            sb.append(str1.charAt(i));
            i++;
        }
        while (j < n) {
            sb.append(str2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}