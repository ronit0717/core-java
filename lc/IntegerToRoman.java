//https://leetcode.com/problems/integer-to-roman/
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        int[] nums = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] romans = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        
        while (num > 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (num < nums[i]) {
                    continue;
                }
                int quotient = num / nums[i];
                num = num % nums[i];
                
                for (int j = 0; j < quotient; j++) {
                    sb.append(romans[i]);
                }
            }
        }
        return sb.toString();
    }
}