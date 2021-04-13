import java.util.*;

public class AllConstructDP{

     public static void main(String []args){
        String target =
        //"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef"
        //"abcdef"
        //"purple"
        //"skateboard"
        "enterapotentpot"
        //"pu"
        ;
        String[] cand = 
        //{"e", "ee", "eee", "eeee", "eeeee", "eeeeeee"}
        //{"ab", "abc", "cd", "def", "abcd"}
        //{"purp", "p", "ur", "le", "purpl"}
        //{"bo", "rd", "ate", "t", "ska", "sk", "boar"}
        {"a", "p", "ent", "enter", "ot", "o", "t"}
        //{"p", "u"}
        ;
        HashMap<String, List<List<String>>> mem = new HashMap<>();
        List<List<String>> result = allConstruct(cand, target, mem);
        
    System.out.println("\n\nPrinting final answer");
        print(result);
     }
     
     private static void print(List<List<String>> result) {
         if (result == null) {
             System.out.println("Its null");
             return;
         };
         for (List<String> set : result) {
             System.out.println("[");
             for (String str : set) {
                 System.out.println("\t"+str);
             }
             System.out.print("]\n");
         }
     }
     
     private static List<List<String>> allConstruct(   String[] cand, 
                                                String target,
                                                HashMap<String, List<List<String>>> mem
                                            ) {
        if (mem.containsKey(target)) {
            return mem.get(target);
        }
        if ("".equals(target)) {
            return new LinkedList<>();
        }
        List<List<String>> result = null;
        for (int i = 0; i < cand.length; i++) {
            if (cand[i].length() > target.length() || target.indexOf(cand[i]) != 0) {
                continue;
            }
            List<List<String>> subResult = allConstruct(cand, target.substring(cand[i].length()), mem);
            if (subResult != null) {
                if (result == null) {
                   result = new LinkedList<>();
                }
                addElement(cand[i], subResult, result);
            } 
        }
        mem.put(target, result);
        return result;
    }
    
    private static void addElement(String str, List<List<String>> subResult, List<List<String>> result) {
        if (subResult.size() == 0) {
            List<String> strList = new LinkedList<>();
            strList.add(str);
            result.add(strList);
            return;
        }
        for (List<String> set : subResult) {
            List<String> newSet = new LinkedList<>(set);
            newSet.add(str);
            result.add(newSet);
        } 
    }
     
}