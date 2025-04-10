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
        if (value < min) { //then we push the modified value and update min
            st.push(2*value - min);
            min = value;
        } else {
            st.push(value);
        }
    }
    
    public void pop() {
        long val = st.pop();
        if (val < min) { //this condition always true for modified value, and change min
            min = 2*min - val;   
        }
    }
    
    public int top() {
        if (st.peek() < min) { //this condition always true for modified value
            return min.intValue();
        }
        return st.peek().intValue();
    }
    
    public int getMin() {
        return min.intValue();   
    }
}

/*
Solution 1: To store a stack with a node, node has two elements : value and min

Example: Push 4, Push 5, Push 2
Stack -> (4,4), (5,4), (2,2)
Stack node's min stores the current min

SC = O(2N) as we store value and min
TC = O(1)
*/

class MinStack {

    private Stack<Integer[]> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min;
        if (st.isEmpty()) {
            min = val;
        } else {
            min = Math.min(st.peek()[1], val);
        }
        st.push(new Integer[]{val, min});
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
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