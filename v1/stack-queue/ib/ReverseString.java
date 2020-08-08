//Link: https://www.interviewbit.com/problems/reverse-string/

public class Solution {
    public String reverseString(String A) {
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<A.length(); i++){
            st.push(A.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while(!st.empty()){
            char c = st.pop();

            sb.append(c);
        }

        return sb.toString();
    }
}
