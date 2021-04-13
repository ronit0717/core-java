import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        String target = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String[] cand = {"e", "ee", "eee", "eeee", "eeeee", "eeeeeee"};
        HashMap<String, Boolean> mem = new HashMap<>();
        boolean status = canConstruct(target, cand, mem);
        System.out.println(status);
     }
     
     private static boolean canConstruct(String target, String[] cand, HashMap<String, Boolean> mem) {
         if ("".equals(target)) {
             return true;
         }
         if (mem.containsKey(target)) {
             return mem.get(target);
         }
         for (int i = 0; i < cand.length; i++) {
             if (target.indexOf(cand[i]) == 0) {
                 boolean status = canConstruct(target.substring(cand[i].length()), cand, mem);
                 if (status) {
                     mem.put(target, status);
                     return status;
                 }
             }
         }
         mem.put(target, false);
         return false;
     }
}