import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        String inp = "115";
        
        List<String> res = getPermutation(inp);
        System.out.println(res);
        
     }
     
     private static List<String> getPermutation(String input) {
        List<String> res = new LinkedList<>();
        if (input.length() == 1) {
            res.add(input);
            return res;
        }
        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            List<String> next = getPermutation(input.substring(0, i) + input.substring(i+1, input.length()));
            for (String n : next) {
                String set = c + n;
                if (hash.contains(set)) {
                    continue;
                }
                res.add(set);
                hash.add(set);
            }
        }
        return res; 
    }
}