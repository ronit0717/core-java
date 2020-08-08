//LinkedList Implementation of Stack

import java.io.*;
import java.util.LinkedList;

public class Stack3{
    
    private static LinkedList<Integer> stack;

    public static void main(String[] args) {
        stack = new LinkedList<Integer>();
        stackPush(1);
        stackPush(2);
        stackPush(3);
        stackPush(4);
        stackPush(5);
        printStack();

        stackPush(6);
        stackPush(7);
        stackPush(8);
        stackPush(9);
        printStack();

        stackPop();
        stackPop();
        printStack();



    }

    private static void stackPush(int i){
        stack.addFirst(i);
    }

    private static void stackPop(){
        System.out.println("Popped Element :"+stack.get(0));
        stack.removeFirst();
    }

    private static void printStack(){
        for(int i=0; i<stack.size(); i++){
            if(i!= 0){
                System.out.print("->");
            }
            System.out.print(stack.get(i));
        }
        System.out.print("\n");
    }
    
}