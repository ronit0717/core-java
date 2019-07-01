//Implementing Queue Using LinkedList TODO
import java.io.*;

public class Queue2 {

    static int[] stack;
    static int endPoint = 0;

    private static void increaseSize(){
        int newSize = 2*stack.length;
        int newArray[] = new int[newSize];

        for(int i=0; i<stack.length; i++){
            newArray[i] = stack[i];
        }

        stack = newArray;
    }

    public static void main(String args[]){
        stack = new int[10]; //initialised with size 10

        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        push(7);

        printStack();

        pop();

        stackSize();

        push(8);
        push(9);
        push(10);
        push(11);
        push(12);

        printStack();



    }

    //Stack Operations
    private static void push(int n){
        if(endPoint == stack.length){
            increaseSize();
        }

        stack[endPoint] = n;
        endPoint++;
    }

    private static void pop(){
        stack[endPoint - 1] = 0;
        endPoint--;
    }

    private static void printStack(){
        if(endPoint == 0){
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Printing Stack : ");
        for(int i=0; i<endPoint; i++){
            if(i == 0){
                System.out.print(stack[i]);
            }else{
                System.out.print(" "+stack[i]);
            }
        }
        System.out.print("\n");
    }

    private static void stackSize(){
        System.out.println("Stack Size :"+endPoint);
    }

}