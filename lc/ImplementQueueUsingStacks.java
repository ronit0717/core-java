//Solution 2 (Pop/Peek is slower)
class MyQueue {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }

    private void exchange() {
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }
    }
    
    public int pop() {
        if(!st2.isEmpty()) {
            return st2.pop();
        }
        exchange();
        return st2.pop();
    }
    
    public int peek() {
        if(!st2.isEmpty()) {
            return st2.peek();
        }
        exchange();
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

//Solution 1 (Push is slower)
class MyQueue {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        st1.push(x);
        while(!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        return st1.pop();
    }
    
    public int peek() {
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */