/*
Heap
0 based indexing
	parent of a node i => (i - 1) / 2
	left node of node i => 2 * i + 1
	right node of node i => 2 * i + 2

Min Heap / Max Heap

1. Adding new element (Up Heap) 
	-> add new node in leaf considering complete binary tree. 
	-> Then compare with parent and keep swapping upwards)
2. Removing any element
	-> Remove the element, and swap it with the last element of the heap (leaf)
	-> Now compare the element swapped with its children and keep swapping, till condition of heap is met

Note: Number of leaf nodes in a complete binary tree is N/2
*/
import java.util.ArrayList;

class Main {
    
    static class Heap {
        ArrayList<Integer> list;
        
        public Heap() {
            this.list = new ArrayList<>();
        }
        
        private void add(int val) {
            list.add(val);
            upHeap(list.size() - 1);
        }
        
        private int peek() {
            if (list.size() == 0) {
                System.out.println("Empty Heap");
                return -1;
            }
            return list.get(0);
        }
        
        private int pop() {
            if (list.size() == 0) {
                System.out.println("Empty Heap");
                return -1;
            }
            int val = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.removeLast();
            downHeap(0);
            return val;
        }
        
        private void upHeap(int index) {
            if (index == 0) {
                return;
            }
            int parentIndex = getParentIndex(index);
            if (list.get(parentIndex) >= list.get(index)) {
                return;
            }
            int temp = list.get(parentIndex);
            list.set(parentIndex, list.get(index));
            list.set(index, temp);
            upHeap(parentIndex);
        }
        
        private void downHeap(int index) {
            if (index >= list.size()) {
                return;
            }
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);
            int val = list.get(index);
            int leftVal = leftIndex >= list.size() ? Integer.MIN_VALUE : list.get(leftIndex);
            int rightVal = rightIndex >= list.size() ? Integer.MIN_VALUE : list.get(rightIndex);
            if (leftVal >= rightVal && leftVal > val) {
                list.set(index, leftVal);
                list.set(leftIndex, val);
                downHeap(leftIndex);
            } else if (rightVal > leftVal && rightVal > val) {
                list.set(index, rightVal);
                list.set(rightIndex, val);
                downHeap(rightIndex);
            }
        }
        
        private int getParentIndex(int i) {
            return (i - 1) / 2;
        }
        
        private int getLeftChildIndex(int i) {
            return (2 * i) + 1;
        }
        
        private int getRightChildIndex(int i) {
            return (2 * i) + 2;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Heap heap = new Heap();
        heap.add(10);
        heap.add(20);
        System.out.println(heap.peek());
        heap.add(30);
        System.out.println(heap.peek());
        heap.add(5);
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
    }
}