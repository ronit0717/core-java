import java.util.ArrayList;

//Link: https://www.interviewbit.com/problems/evaluate-expression/

public class Solution {
    private static Stack<String> st;
    public int evalRPN(ArrayList<String> A) {
        st = new Stack<String>();

        for(int i=0; i< A.size(); i++){
            st.push(A.get(i));
        }

        if(!st.empty()){
            int result = evaluate();
            return result;
        }

        return 0;
    }

    private static int evaluate(){
        String val;
        int valNum1;
        int valNum2;
        int result;
        if(!st.empty()){
            val = st.pop();
            if(val.equals("*")){
                valNum1 = evaluate();
                valNum2 = evaluate();
                result = valNum2 * valNum1;
            }else if(val.equals("+")){
                valNum1 = evaluate();
                valNum2 = evaluate();
                result = valNum2 + valNum1;
            }else if(val.equals("-")){
                valNum1 = evaluate();
                valNum2 = evaluate();
                result = valNum2 - valNum1;
            }else if(val.equals("/")){
                valNum1 = evaluate();
                valNum2 = evaluate();
                result = valNum2 / valNum1;
            }else{
                valNum1 = Integer.valueOf(val);
                return valNum1;
            }

            return result;
        }
        return 0;
    }
    
}
