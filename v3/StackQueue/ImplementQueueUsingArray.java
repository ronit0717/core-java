public class HelloWorld{

     public static void main(String []args){
        System.out.println("Implement Queue Using Array");
        
        //DRIVER
        Queue q = new Queue(5);
        
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
     
     static class Queue {
         private int count; //counts the number of elements filled in queue
         private int front; //points to front of the Queue
         private int rear;
         private int capacity; //capacity of queue = length of the array
         private int[] q; //this array acts as the Queue
         
         Queue(int cap) {
             count = 0;
             front = 0;
             rear = 0;
             capacity = cap;
             q = new int[cap];
         }
         
         void push(int val) {
             if (count == capacity) {
                 System.out.println("Capacity Full, push not allowed");
                 return;
             }
             q[rear++ % capacity] = val;
             count++;
         }
         
         int peek() {
            if (count == 0) {
                System.out.println("Empty Queue, Peek not allowed");
                return -1;
            }
            return q[front % capacity];
         }
         
         int poll() { //remove from front
             if (count == 0) {
                System.out.println("Empty Queue, Poll not allowed");
                return -1;
            }
            count--;
            return q[front++ % capacity];
         }
         
         boolean isEmpty() {
            return count == 0;   
         }
         
         int size() {
             return count;
         }
         
         void printQueue() {
             System.out.print("Queue: ");
             for (int i = 0; i < count; i++) {
                 System.out.print(q[(i + front) % capacity] + " ");
             }
             System.out.print("\n");
         }
     }
}