class Node {
    public int val;
    public Node next;
    
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Queue {
    private Node head;
    private Node tail;
    private int size;
    
    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void add(int val) {
        Node node = new Node(val);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
        size++;
    }
    
    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        return head.val;
    }
    
    public int poll() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = head.val;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return this.size;
    }
}

class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
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