import java.util.*;

public class CountConstructDP {

     public static void main(String []args){
        String target =
        //"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef"
        //"abcdef"
        //"purple"
        //"skateboard"
        "enterapotentpot"
        ;
        String[] cand = 
        //{"e", "ee", "eee", "eeee", "eeeee", "eeeeeee"}
        //{"ab", "abc", "cd", "def", "abcd"}
        //{"purp", "p", "ur", "le", "purpl"}
        //{"bo", "rd", "ate", "t", "ska", "sk", "boar"}
        {"a", "p", "ent", "enter", "ot", "o", "t"}
        ;
        HashMap<String, Integer> mem = new HashMap<>();
        int count = countConstruct(target, cand, mem);
        System.out.println(count);
     }
     
     private static int countConstruct(String target, String[] cand, HashMap<String, Integer> mem) {
         if ("".equals(target)) {
             return 1;
         }
         if (mem.containsKey(target)) {
             return mem.get(target);
         }
         int count = 0;
         for (int i = 0; i < cand.length; i++) {
             if (target.indexOf(cand[i]) == 0) {
                 count += countConstruct(target.substring(cand[i].length()), cand, mem);
             }
         }
         mem.put(target, count);
         return count;
     }
}