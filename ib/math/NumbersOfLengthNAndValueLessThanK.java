public class Solution {
    public int solve(ArrayList < Integer > A, int B, int C) {
        if (B == 0) {
            return 0;
        }
        int cStrLen = Integer.toString(C).length();
        if (B < cStrLen) {
            if (B == 1) {
                return A.size();
            }
            int prod = 1;
            for (int i = 0; i < B; i++) {
                if (i == 0 && A.get(i) == 0) {
                    prod *= (A.size() - 1);
                    continue;
                }
                prod *= A.size();
            }
            return prod;
        } else if (B > cStrLen) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            if (B != 1 && A.get(i) == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder().append(A.get(i));
            sum += checkSum(sb, A, B, C, 1);
        }
        return sum;
    }

    private static int checkSum(StringBuilder sb,
        ArrayList < Integer > A,
        int B,
        int C,
        int count) {
        int sum = 0;
        int check = Integer.valueOf(sb.toString());
        if (count >= B) {
            if (check < C) {
                return 1;
            } else {
                return 0;
            }
        }
        if (check > C) {
            return 0;
        } else {
            for (int i = 0; i < A.size(); i++) {
                StringBuilder sbNew = new StringBuilder(sb.toString()).append(A.get(i));
                int newSum = checkSum(sbNew, A, B, C, count + 1);
                if (newSum > 0) {
                    sum += newSum;
                } else {
                    break;
                }
            }
        }
        return sum;
    }
}