class StockSpanner {

    private Stack<Integer[]> st; //previous greater element stack. Store index and value
    int index;
    
    public StockSpanner() {
        this.st = new Stack<>();
        this.index = 0;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek()[1] <= price) {
            st.pop();
        }
        int pgeIndex = st.isEmpty() ? -1 : st.peek()[0];
        st.push(new Integer[]{index, price});
        int spanLength = index - pgeIndex;
        index++;
        return spanLength;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */