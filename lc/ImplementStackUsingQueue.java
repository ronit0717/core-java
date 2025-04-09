class MyStack {

    private Queue<Integer> st;
    
    public MyStack() {
        st = new LinkedList<>();
    }
    
    public void push(int x) {
        int size = st.size();
        st.add(x);
        for (int i = 0; i < size; i++) {
            //remove from front and add back
            int val = st.poll();
            st.add(val);
        }
    }
    
    public int pop() {
        return st.poll();
    }
    
    public int top() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */