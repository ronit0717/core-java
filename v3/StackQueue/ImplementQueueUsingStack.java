/* Solution 2 : Push in O(1), Peek and Pop in amortized (almost) O(1)
Use two stack ip and op

For push, always push elements in ip stack

For peek and pop:
1. If op is empty, pop all elements from ip and push it in op, if op is not empty skip this step
2. then do op.pop() or op.peek()

For printing first print all op elements in reverse, then print all ip element in normal order
*/

import java.util.Stack;
import java.lang.StringBuilder;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Implement Queue Using Stack");
        
        //DRIVER
        MyQueue q = new MyQueue();
        
        System.out.println("Is Empty: "+ q.isEmpty());
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println("Is Empty: "+ q.isEmpty());
        System.out.println("Size: "+ q.size());
        q.printQueue();
        q.push(5);
        q.push(6);
        q.printQueue();
        System.out.println("Poll: "+ q.poll());
        q.printQueue();
        System.out.println("Peek: "+ q.peek());
        System.out.println("Poll: "+ q.poll());
        System.out.println("Size: "+ q.size());
        q.push(7);
        q.push(8);
        q.printQueue();
        
        System.out.println("Poll: "+ q.poll());
        System.out.println("Poll: "+ q.poll());
        System.out.println("Poll: "+ q.poll());
        System.out.println("Poll: "+ q.poll());
        System.out.println("Size: "+ q.size());
        q.push(9);
        q.printQueue();
        System.out.println("Peek: "+ q.peek());
     }
     
     static class MyQueue {
         Stack<Integer> ip; //input stack
         Stack<Integer> op; //output stack
         
         MyQueue() {
             ip = new Stack<>();
             op = new Stack<>();
         }
         
         /*
            Add the element in input stack 
         */
         void push(int val) {
             ip.push(val);
         }
         
         /* If output is empty, take all elements from input and put it in output
            Do output.pop()
         */
         int poll() {
             if (op.isEmpty()) {
                 while(!ip.isEmpty()) {
                     op.push(ip.pop());
                 }
             }
             return op.pop();
         }
         
         /* If output is empty, take all elements from input and put it in output
            Do output.peek()
         */
         int peek() {
             if (op.isEmpty()) {
                 while(!ip.isEmpty()) {
                     op.push(ip.pop());
                 }
             }
             return op.peek();
         }
         
         boolean isEmpty() {
             if (!ip.isEmpty() || !op.isEmpty()) {
                 return false;
             }
             return true;
         }
         
         int size() {
             return ip.size() + op.size();
         }
         
         /*
         For printing first print all op elements in reverse
         Then print all ip element in normal order
         */
         void printQueue() {
             StringBuilder sb = new StringBuilder();
             if (!op.isEmpty()) {
                for (Integer i : op ) {
                     sb.append(" ").append(i);
                 }
                 sb.reverse();
             }
             if (!ip.isEmpty()) {
                for (Integer i : ip ) {
                     sb.append(i).append(" ");
                 }
             }
             
             System.out.println("Queue: " + sb.toString());
         }
     }
}

/*
Solution 1: 
Push Algo :
    1. Empty contents of st1 into st2
    2. Add val in st1
    3. Empty contents of st2 into st1
*/

import java.util.Stack;
import java.lang.StringBuilder;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Implement Queue Using Stack");
        
        //DRIVER
        MyQueue q = new MyQueue();
        
        System.out.println("Is Empty: "+ q.isEmpty());
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println("Is Empty: "+ q.isEmpty());
        System.out.println("Size: "+ q.size());
        q.printQueue();
        q.push(5);
        q.push(6);
        q.printQueue();
        System.out.println("Poll: "+ q.poll());
        q.printQueue();
        System.out.println("Peek: "+ q.peek());
        System.out.println("Poll: "+ q.poll());
        System.out.println("Size: "+ q.size());
        q.push(7);
        q.push(8);
        q.printQueue();
        
        System.out.println("Poll: "+ q.poll());
        System.out.println("Poll: "+ q.poll());
        System.out.println("Poll: "+ q.poll());
        System.out.println("Poll: "+ q.poll());
        System.out.println("Size: "+ q.size());
        q.push(9);
        q.printQueue();
        System.out.println("Peek: "+ q.peek());
     }
     
     static class MyQueue {
         Stack<Integer> st1;
         Stack<Integer> st2;
         
         MyQueue() {
             st1 = new Stack<>();
             st2 = new Stack<>();
         }
         
         /*
        1. Empty contents of st1 into st2
        2. Add val in st1
        3. Empty contents of st2 into st1
         */
         void push(int val) {
             while(!st1.isEmpty()) {
                 st2.push(st1.pop());
             }
             st1.push(val);
             
             while (!st2.isEmpty()) {
                 st1.push(st2.pop());
             }
         }
         
         int poll() {
             return st1.pop();
         }
         
         int peek() {
             return st1.peek();
         }
         
         boolean isEmpty() {
             return st1.isEmpty();
         }
         
         int size() {
             return st1.size();
         }
         
         void printQueue() {
             StringBuilder sb = new StringBuilder();
             for (Integer i : st1) {
                 sb.append(" ");
                 sb.append(i);
             }
             sb.reverse();
             System.out.println("Queue: " + sb.toString());
         }
     }
}