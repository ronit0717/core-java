import java.util.ArrayList;

class Solution {
    
    private static Stack<Integer> mainStack = new Stack<Integer>();
    private static Stack<Integer> minStack = new Stack<Integer>();
    private int minVal = Integer.MAX_VALUE;

    public void push(int x) {
        mainStack.push(x);

        if(x <= minVal){
            minVal = x;
            minStack.push(x);
        }
    }

    public void pop() {
        if(!mainStack.empty()){
            int x = mainStack.pop();

            if(!minStack.empty()){
                int xMin = minStack.peek();
                if(xMin == x){
                    minStack.pop();
                }
            }
        }
    }

    public int top() {
        if(!mainStack.empty()){
            return mainStack.peek();
        }else{
            return -1;
        }
    }

    public int getMin() {
        if(!minStack.empty()){
            return minStack.peek();
        }else{
            return -1;
        }
    }
}
