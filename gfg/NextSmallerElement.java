//https://www.geeksforgeeks.org/next-smaller-element/

/*
1. Iterate in reverse
    1.1 Compare the current element with top elements in stack
    1.2 If the stack number is greater than or equal to current element remove it
        Else, this is the next smaller element
    1.3 If we dont find any next smaller element assign -1 to next smaller element array
*/

//Similar Question: Next greater elemennt => https://github.com/ronit0717/core-java/blob/master/lc/NextGreaterElementII.java

/*
TC = O(2n), as we remove the elements, so max it will go n times depth in total
*/

import java.util.Stack;

public class HelloWorld{

     public static void main(String []args){
        //int[] nums = { 4, 8, 5, 2, 25 }; 
        int[] nums = { 13, 7, 6, 12 };
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean done = false;
            while (!st.isEmpty()) {
                if (st.peek() < nums[i]) {
                    res[i] = st.peek();
                    done = true;
                    break;
                } else {
                    st.pop();
                }
            }
            if (!done) {
                res[i] = -1;
            }
            st.push(nums[i]);
        }
        
        print(res);
     }
     
     private static void print(int[] nums) {
         for (int i = 0; i < nums.length; i++) {
             System.out.print(nums[i] + " ");
         }
         System.out.println();
     }
}