public class HelloWorld{

     public static void main(String []args){
        System.out.println("Implement Stack Using Array");
        
        //DRIVER CODE
        MyStack stack = new MyStack(10);
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
         private int pointer;
         private int[] stack;
         
         MyStack(int size) {
            pointer = -1;
            stack = new int[size];
         }
         
         void push(int val) {
             stack[++pointer] = val;
         }
         
         int peek() {
             return stack[pointer];
         }
         
         int pop() {
             return stack[pointer--];
         }
         
         int size() {
             return pointer + 1;
         }
         
         boolean isEmpty() {
             return pointer == -1;
         }
         
         void printStack() {
             System.out.print("Stack: ");
             for (int i = 0; i <= pointer; i++) {
                 System.out.print(stack[i] + " ");
             }
             System.out.println();
         }
     }
     
     
}