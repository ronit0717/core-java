public class Solution {
    public String solve(int A) {
        if (A == 1) {
            return "1";
        }
        return multiply(solve(A-1), Integer.toString(A));
    }
    
    private static String multiply(String A, String B) {
        String result = "0";
        if (A.length() < B.length()) {
            String temp = A;
            A = B;
            B = temp;
        }
        for (int i = B.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < B.length() - 1 - i; j++) {
                sb.append(0);
            }
            int carry = 0;
            for (int j = A.length() - 1; j >= 0; j--) {
                int b = B.charAt(i) - '0';
                int a = A.charAt(j) - '0';
                int m = a * b + carry;
                if (m >= 10) {
                    carry = m / 10;
                    m = m % 10;
                } else {
                    carry = 0;
                }
                sb.append(m);
            }
            if (carry != 0) {
                sb.append(carry);
            }
            result = sum(sb.reverse().toString(), result);
        }
        return result;
    }
    
    private static String sum (String A, String B) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int carry = 0;
        while (i < A.length() || i < B.length() || carry != 0) {
            int a = 0;
            int b = 0;
            if (i < A.length()) {
                a = A.charAt(A.length() - 1 - i) - '0';
            }
            if (i < B.length()) {
                b = B.charAt(B.length() - 1 - i) - '0';
            }
            int result = a + b + carry;
            if (result >= 10) {
                carry = 1;
                result -= 10;
            } else {
                carry = 0;
            }
            sb.append(result);
            i++;
        }
        return sb.reverse().toString();
    }
}
