class MedianFinder {

    private PriorityQueue<Integer> leftHeap; //max Heap
    private PriorityQueue<Integer> rightHeap; //min Heap

    public MedianFinder() {
        rightHeap = new PriorityQueue<>();
        leftHeap = new PriorityQueue<>((a , b) -> (b - a));
    }
    
    public void addNum(int num) {
        leftHeap.add(num);
        int leftMax = leftHeap.isEmpty() ? Integer.MIN_VALUE : leftHeap.peek();
        int rightMin = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();
        
        //condition check for leftHeap and rightHeap
        if (leftMax > rightMin) {
            rightHeap.add(leftHeap.poll());
        }

        //size check for leftHeap and rightHeap
        int leftSize = leftHeap.size();
        int rightSize = rightHeap.size();
        if (Math.abs(rightSize - leftSize) > 1) {
            if (leftSize > rightSize) {
                rightHeap.add(leftHeap.poll());
            } else {
                leftHeap.add(rightHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        int leftSize = leftHeap.size();
        int rightSize = rightHeap.size();
        if (leftSize == rightSize) {
            return ((double)leftHeap.peek() + rightHeap.peek()) / 2;
        } else if (leftSize > rightSize) {
            return leftHeap.peek();
        } else {
            return rightHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */