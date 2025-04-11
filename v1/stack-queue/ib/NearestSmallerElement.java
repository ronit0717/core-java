//Solution 2: Cleaner solution
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> nse = new ArrayList<>(A.size());
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            while(!st.isEmpty() && st.peek() >= A.get(i)) {
                st.pop();
            }
            nse.add(st.isEmpty() ? - 1 : st.peek());
            st.push(A.get(i));
        }
        return nse;
    }
}

//Solution 1
import java.util.ArrayList;

//Link: https://www.interviewbit.com/problems/nearest-smaller-element/

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> st_back = new Stack<Integer>();
        
        for(int i=0; i<A.size(); i++){
            int check = A.get(i);
            
            if(!(st.empty())){
                boolean done = false;
                while(!(st.empty())){
                    int num = st.peek();
                    if(num < check){
                        result.add(num);
                        done = true;
                        break;
                    }else{
                        st_back.push(st.pop());
                    }
                }
                
                //refill code
                while(!(st_back.empty())){
                    st.push(st_back.pop());
                }

                if(!done){
                    result.add(-1);
                }
                
            }else{
                result.add(-1);
            }
            st.push(check);
        }

        return result;
    }
}
