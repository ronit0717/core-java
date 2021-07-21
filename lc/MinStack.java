/*
Solution 2: Storing altered value in stack
SC = O(N), TC = O(1)

Logic:

Push operation
--------------
If min < val
then we push the value => 2 * val - min, and min = val

Top operation
-------------
If top < min, then return min, else return top

Pop operation
-------------
pop from stack
and min = 2 * min - val



Intuition for push operation:
if val < min
=> val - min < 0
=> val + (val - min) < val + 0
=> 2*val - min < val

Now 2*val - min = top, and val = min
hence top < min
*/

class MinStack {

    /** initialize your data structure here. */
    Long min;
    Stack<Long> st;
    public MinStack() {
        min = 0L;
        st = new Stack<>();
    }
    
    public void push(int val) {
        long value = (long)val;
        if (st.isEmpty()) {
            st.push(value);
            min = value;
            return;
        }   
        if (value < min) { //then we push the modified value
            st.push(2*value - min);
            min = value;
        } else {
            st.push(value);
        }
    }
    
    public void pop() {
        long val = st.pop();
        if (val < min) { //then update the min
            min = 2*min - val;   
        }
    }
    
    public int top() {
        if (st.peek() < min) {
            return min.intValue();
        }
        return st.peek().intValue();
    }
    
    public int getMin() {
        return min.intValue();   
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/*
Solution 1: To store a stack with a node, node has two elements : value and min

Example: Push 4, Push 5, Push 2
Stack -> (4,4), (5,4), (2,2)
Stack node's min stores the current min

SC = O(2N) as we store value and min
TC = O(1)
*/

class MinStack {

    /** initialize your data structure here. */
    class Node {
        int value;
        int min;
        
        Node(int val, int min) {
            this.value = val;
            this.min = min;
        }
    }
    
    Stack<Node> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min = st.isEmpty() ? val : Math.min(st.peek().min, val);
        Node n = new Node(val, min);
        st.push(n);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        Node n = st.peek();
        return n.value;
    }
    
    public int getMin() {
        Node n = st.peek();
        return n.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */