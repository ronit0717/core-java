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
