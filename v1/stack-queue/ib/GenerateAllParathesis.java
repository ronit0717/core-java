//Link: https://www.interviewbit.com/problems/generate-all-parentheses/

public class Solution {
    public int isValid(String A) {
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i< A.length(); i++){
            if((A.charAt(i) == '(') || (A.charAt(i) == '{') || (A.charAt(i) == '[')){
                //Opening bracket
                st.push(A.charAt(i));
            }else{
                if(st.empty()){
                    return 0;
                }

                char c = st.pop();
                if(A.charAt(i) == ')'){
                    if(c != '('){
                        return 0;
                    }
                }else if(A.charAt(i) == '}'){
                    if(c != '{'){
                        return 0;
                    }
                }else if(A.charAt(i) == ']'){
                    if(c != '['){
                        return 0;
                    }
                }
            }
        }

        if(st.empty()){
            return 1;
        }else{
            return 0;
        }
    }
}
