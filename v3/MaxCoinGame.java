/*

Question: 
Max coin sum collected
there are two players player 1(you), and player 2 given an array of coins you can to pick a coin from start or end of the array. Given you get to go first what's the maximum sum you can collect.

eg:  10, 5, 30, 20, 50, 5

output : 90

you choose : 10, 30, 50
player 2 chooses : 5, 20, 5

*/

import java.util.HashMap;
import java.lang.Math;

public class HelloWorld{

     public static void main(String []args){
        int[] a = {10, 5, 30, 20, 50, 5};
        HashMap<String, Integer> mem = new HashMap<>();
        int sum = maxSum(a, 0, a.length-1, mem);
        System.out.println(sum);
     }
     
     private static int maxSum(int[] a, int start, int end, HashMap<String, Integer> mem) {
         String key = new StringBuilder().append(start).append(end).toString();
         if (mem.containsKey(key)) {
             return mem.get(key);
         }
         int sum;
         if (start == end) {
             sum = a[start];
         } else if (start + 1 == end) {
             sum = Math.max(a[start], a[end]);
         } else {
            int op1 = a[start] + Math.max(maxSum(a, start+1, end-1, mem), maxSum(a, start+2, end, mem));
            int op2 = a[end] + Math.max(maxSum(a, start+1, end-1, mem), maxSum(a, start, end-2, mem));
            sum = Math.max(op1, op2);   
         }
         mem.put(key, sum);
         return sum;
     }
     
}