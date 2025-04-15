class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> st = new Stack<>();
        st.push(num.charAt(0));
        int count = 0;
        for (int i = 1; i < num.length(); i++) {
            if (count == k) {
                st.push(num.charAt(i));
                continue;
            }
            while(!st.isEmpty() && st.peek() > num.charAt(i) & count < k) {
                count++;
                st.pop();
            }
            st.push(num.charAt(i));
        }

        while (count < k) {
            count++;
            st.pop(); //remove from end
        }

        int size = st.size();
        char[] charArr = new char[size];
        for (int i = size - 1; i >= 0; i--) {
            charArr[i] = st.pop();
        }
        String newStr = "";
        boolean prefixZero = true;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '0' && prefixZero) {
                continue;
            }
            if (charArr[i] != '0') {
                prefixZero = false;
            }
            newStr += charArr[i];
        }
        return prefixZero ? "0" : newStr;
    }
}