class Solution {
    public String addStrings(String num1, String num2) {
 		int i = num1.length() - 1;
 		int j = num2.length() - 1;
 		StringBuilder sb = new StringBuilder();
 		int carry = 0;
 		while(i != -1 || j != -1 || carry != 0) {
 			int p = 0;
 			int q = 0;
 			if (i != -1) {
 				p = num1.charAt(i) - '0';
 				i--;
 			}
 			if (j != -1) {
 				q = num2.charAt(j) - '0';
 				j--;
 			}
 			int sum = p + q + carry;
 			if (sum >= 10) {
 				sum = sum - 10;
 				carry = 1;
 			} else {
 				carry = 0;
 			}
 			sb.append(sum);
 		}
 		return sb.reverse().toString();
    }
}