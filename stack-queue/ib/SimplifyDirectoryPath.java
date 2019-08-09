//Link: https://www.interviewbit.com/problems/simplify-directory-path/

public class Solution {
    public String simplifyPath(String A) {
        String[] split = A.split("/");
        Stack<String> st = new Stack<String>();
        for(int i=0; i<split.length; i++){
            if(split[i].trim().equals("..")){
                if(!st.empty()){
                    st.pop();
                }
            }else if(split[i].trim().equals("") || split[i].trim().equals(".")){
                continue;
            }else{
                st.push(split[i]);
            }
            
        }

        StringBuilder sb = new StringBuilder("");
        while(!st.empty()){
            sb.insert(0, "/"+st.pop());
        }

        String ret = sb.toString();
        if(ret.equals("")){
            return "/";
        }else{
            return ret;
        }
        

        

    }
}
