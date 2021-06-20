// Link: https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/

/* Solution: 
Sort the coin array in descending order, and try to give out as much as possible coins of 
higher denomination
*/

import java.util.Arrays;

public class HelloWorld{

     public static void main(String []args){
        Integer[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int sum = 2221;
        
        int count = 0;
        Arrays.sort(coins, (a, b) -> (b - a));
        int index = 0;
        int diff = sum;
        
        while (diff > 0) {
            if (diff < coins[index]) {
                index++;
                continue;
            }
            int q = diff / coins[index];
            diff -= coins[index] * q;
            count += q;
        }
        System.out.println(count);
     }
}