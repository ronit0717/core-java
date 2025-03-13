//TC = O(N), SC = O(N) auxillary stack space
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        int[] result = evaluate(root);
        return result[0];
    }
    
    //Return array of {size, min, max} of the tree
    static int[] evaluate(Node node) {
        if (node == null) {
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = evaluate(node.left);
        int[] right = evaluate(node.right);
        int size, min, max;
        if (left[2] < node.data && node.data < right[1]) {
            //node is greater than max of left subtree 
            // and node is smaller than the min of the right subtree
            //This is a valid BST
            size = 1 + left[0] + right[0];
            min = getMin(node.data, left[1]);
            max = getMax(node.data, right[2]);
        } else {
            //Not a valid BST
            size = Math.max(left[0], right[0]);
            min = Integer.MIN_VALUE;
            max = Integer.MAX_VALUE;
        }
        return new int[]{size, min, max};
    }
    
    static int getMin(int nodeData, int leftMin) {
        return Math.min(nodeData, leftMin);
    }
    
    static int getMax(int nodeData, int rightMax) {
        return Math.max(nodeData, rightMax);
    }
    
}