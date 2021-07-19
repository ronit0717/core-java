/*
Solution 2: Using one queue
Steps:
 1. Push the val is q
 2. Iterate for size-1 time, and remove from bottom and add at top
*/
import java.util.LinkedList;
import java.util.Queue;
import java.lang.StringBuilder;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Implement Stack Using Two Queues");
        
        MyStack stack = new MyStack();
        System.out.println("Is Empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        System.out.println("Size: " + stack.size());
        stack.printStack();
        
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        
        stack.pop();
        stack.push(6);
        System.out.println("Size: " + stack.size());
        stack.printStack();
        System.out.println("Is Empty: " + stack.isEmpty());
        
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        
        System.out.println("Is Empty: " + stack.isEmpty());
        stack.push(7);
        stack.push(8);
        stack.printStack();
        
     }
     
     static class MyStack {
         Queue<Integer> q1;
         
         MyStack() {
             q1 = new LinkedList<Integer>();
         }
         
         /*
         1. Push the val is q
         2. Iterate for size-1 time, and remove from bottom and add at top
         */
         void push(int val) {
            q1.add(val);
            for (int i = 0; i < q1.size() - 1; i++) {
                q1.add(q1.poll());
            }
         }
         
         int pop() {
             return q1.poll();
         }
         
         int peek() {
             return q1.peek();
         }
         
         boolean isEmpty() {
             return q1.isEmpty();
         }
         
         int size() {
             return q1.size();
         }
         
         void printStack() {
             StringBuilder sb = new StringBuilder();
             for (Integer i : q1) {
                 sb.append(" ");
                 sb.append(i);
             }
             sb.reverse();
             System.out.println("Stack: " + sb.toString());
         }
     }
}

/*
Solution 1: Using two Queues, q1 (the main queue), and q2 (the helper queue)
1. Push the 'val' in q2 
2. Empty q1 and fill in q2
3. Swap q1 and q2
*/

import java.util.LinkedList;
import java.util.Queue;
import java.lang.StringBuilder;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Implement Stack Using Two Queues");
        
        //DRIVER CODE
        MyStack stack = new MyStack();
        System.out.println("Is Empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        System.out.println("Size: " + stack.size());
        stack.printStack();
        
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        
        stack.pop();
        stack.push(6);
        System.out.println("Size: " + stack.size());
        stack.printStack();
        System.out.println("Is Empty: " + stack.isEmpty());
        
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        
        System.out.println("Is Empty: " + stack.isEmpty());
        stack.push(7);
        stack.push(8);
        stack.printStack();
        
     }
     
     static class MyStack {
         Queue<Integer> q1;
         Queue<Integer> q2;
         
         MyStack() {
             q1 = new LinkedList<Integer>();
             q2 = new LinkedList<Integer>();
         }
         
         /* Algorithm to Push
         1. Push the 'val' in q2
         1. Empty q1 and fill in q2
         3. Swap q1 and q2
         */
         void push(int val) {
             q2.add(val);
             while (!q1.isEmpty()) {
                 q2.add(q1.poll());
             }

             //swap
             Queue temp = q2;
             q2 = q1;
             q1 = temp;
         }
         
         int pop() {
             return q1.poll();
         }
         
         int peek() {
             return q1.peek();
         }
         
         boolean isEmpty() {
             return q1.isEmpty();
         }
         
         int size() {
             return q1.size();
         }
         
         void printStack() {
             StringBuilder sb = new StringBuilder();
             for (Integer i : q1) {
                 sb.append(" ");
                 sb.append(i);
             }
             sb.reverse();
             System.out.println("Stack: " + sb.toString());
         }
     }
}