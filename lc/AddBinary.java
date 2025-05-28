class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0) {
            int num1 = a.charAt(i) - '0';
            int num2 = j < 0 ? 0 : b.charAt(j) - '0';
            int result = num1 + num2 + carry;
            if (result == 0) {
                sb.insert(0, '0');
                carry = 0;
            } else if (result == 1) {
                sb.insert(0, '1');
                carry = 0;
            } else if (result == 2) {
                sb.insert(0, '0');
                carry = 1;
            } else if (result == 3) {
                sb.insert(0, '1');
                carry = 1;
            }
            i--;
            j--;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }


}