class Queue {
    private int[] q;
    private int start;
    private int end;
    
    public Queue(int size) {
        q = new int[size];
        start = -1;
        end = 0;
    }
    
    public void add(int val) {
        if (start == q.length - 1) {
            System.out.println("Queue is exhausted");
            return;
        }
        start++;
        q[start] = val;
    }
    
    public int poll() {
        if (end > start) {
            System.out.println("Queue is empty");
            return -1;
        }
        end++;
        return q[end - 1];
    }
    
    public int peek() {
        if (end > start) {
            System.out.println("Queue is empty");
            return -1;
        }
        return q[end];
    }
    
    public int size() {
        return start - end + 1;
    }
    
    public boolean isEmpty() {
        return end > start;
    }
}

class Main {
    public static void main(String[] args) {
        Queue q = new Queue(10);
        checkEmpty(q);
        q.add(10);
        System.out.println(q.size());
        System.out.println(q.peek());
        q.poll();
        q.poll();
        q.add(20);
        q.add(30);
        System.out.println(q.size());
        System.out.println(q.poll());
        System.out.println(q.peek());
        checkEmpty(q);
        System.out.println(q.size());
    }
    
    private static void checkEmpty(Queue q) {
        if (q.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Not Empty");
        }
    }
}