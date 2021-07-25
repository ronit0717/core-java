class Solution {
    public int myAtoi(String s) {
        long val = 0;
        boolean negative = false;
        boolean signEncountered = false;
        
        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == ' ') {
                if (signEncountered) {
                    break;
                }
                continue;
            } else if (s.charAt(i) == '+') {
                if (signEncountered) {
                    break;
                }  
                signEncountered = true;
                continue;
            } else if (s.charAt(i) == '-') {
                if (signEncountered) {
                    break;
                }  
                signEncountered = true;
                negative = true;
                continue;
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            
            signEncountered = true; //number encountered before sign encountered
            
            int num = s.charAt(i) - '0';
            if (negative) {
                val = (val * 10) - num;
                if (val < (long)Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                val = (val * 10) + num;
                if (val > (long)Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return (int)val;
    }
}