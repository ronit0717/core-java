class Stack {
    private int[] st;
    private int top;
    
    public Stack(int size) {
        this.st = new int[size];
        this.top = -1;
    }
    
    public void push(int val) {
        if (top == st.length - 1) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        st[top] = val;
    }
    
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        top--;
        return st[top + 1];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
    
}

class Main {
    public static void main(String[] args) {
        Stack st = new Stack(2);
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