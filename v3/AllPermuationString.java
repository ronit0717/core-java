import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        String inp = "abc";
        
        List<String> res = getPermutation(inp);
        System.out.println(res);
        
     }
     
     private static List<String> getPermutation(String input) {
        List<String> res = new LinkedList<>();
        if (input.length() == 1) {
            res.add(input);
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            List<String> next = getPermutation(input.substring(0, i) + input.substring(i+1, input.length()));
            for (String n : next) {
                String set = c + n;
                res.add(set);
            }
        }
        return res; 
    }
}