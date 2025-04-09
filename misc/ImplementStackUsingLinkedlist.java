class Node {
    public int val;
    public Node next;
    
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Stack {
    private Node node;
    private int size;
    
    public Stack() {
        this.node = null;
        this.size = 0;
    }
    
    public int peek() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        return node.val;
    }
    
    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = this.node;
        this.node = newNode;
        size++;
    }
    
    public int pop() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        int val = node.val;
        node = node.next;
        size--;
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
        Stack st = new Stack();
        checkEmpty(st);
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.size());
        checkEmpty(st);
        System.out.println(st.size());
        st.pop();
        System.out.println(st.pop());
        System.out.println(st.size());
        System.out.println(st.pop());
        st.pop();
    }
    
    private static void checkEmpty(Stack st) {
        if (st.isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("Not Empty");
        }
    }
}