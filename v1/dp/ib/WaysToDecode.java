import java.util.HashMap;

public class Solution {
    private static HashMap<String, Integer> memo = new HashMap<String, Integer>();

    public int numDecodings(String A) {
        //System.out.println("A --> "+A);
        int count = 0;
        
        if(A.length() <= 2){
            
            if(!(A.equals("10") || A.equals("20"))){
                for(int i=0; i< A.length(); i++){
                    if(A.charAt(i) == '0'){
                        return 0;
                    }   
                }   
            }
            
            int num = Integer.valueOf(A);
            
            if(num > 26){
                return 2;
            }else if(num > 0){
                return 1;
            }
        }else{
            String check;
            int num;
            String sub;
            if(A.charAt(2) == '0'){
                if(!(A.charAt(1) == '1' || A.charAt(1) == '2')){
                    return 0;
                }

                check = A.substring(0,1);
                num = Integer.valueOf(check);
            
                sub  = A.substring(1);    
            }else{
                check = A.substring(0,2);
                num = Integer.valueOf(check);
            
                sub  = A.substring(2);    
            }

            if(!(check.equals("10") || check.equals("20"))){
                for(int i=0; i< check.length(); i++){
                    if(check.charAt(i) == '0'){
                        return 0;
                    }   
                }   
            }
            
            int inCount = 0;
            
            if(memo.containsKey(sub)){
                inCount = memo.get(sub);
            }else{
                inCount = numDecodings(sub);
                memo.put(sub, inCount);
            }

            if(num > 26){
                count = 1 * inCount;
            }else if(num > 0){
                count = 2 * inCount;
            }
        }
        return count;
    }
}