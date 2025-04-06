class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                min += 1;
                max += 1;
            } else if (c == ')') {
                min -= 1;
                max -= 1;
            } else {
                //posible deltas: -1, 0, 1. Hence min can decrease by 1 and max can increase by 1
                min -= 1;
                max += 1;
            }
            min = min < 0 ? 0 : min;
            if (max < 0) {
                return false;
            }
        }
        return min == 0;
    }
}