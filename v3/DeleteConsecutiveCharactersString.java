//Delete any consecutive element

import java.util.*;
import java.lang.*;

public class HelloWorld{

     public static void main(String []args){
         String s = "daaba";
        Stack<Character> st = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                count += map.get(c);
            }
            map.put(c, count);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.get(c);
            count--;
            map.put(c, count);
            if (count == 0 && !st.isEmpty() && c == st.peek()) {
                while (!st.isEmpty() && st.peek() == c) {
                    st.pop();
                }
            } else {
                st.push(c);
            }
            System.out.println(st);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            char curr = st.pop();
            boolean repeat = false;
            while (!st.isEmpty() && st.peek() == curr) {
                repeat = true;
                st.pop();
            }
            
            if (!repeat) {
                sb.append(curr);
            }
        }
        
        String res = sb.reverse().toString();
        System.out.println("Result : "+ res); //dba
     }
}