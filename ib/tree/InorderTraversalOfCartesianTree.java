/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public TreeNode buildTree(ArrayList<Integer> A) {
        int rootIndex = maxUtil(A, 0, A.size() - 1);
        TreeNode root = new TreeNode(A.get(rootIndex));
        buildTreeUtil(root, rootIndex, A, 0, A.size() - 1);
        return root;
    }
    
    private void buildTreeUtil(TreeNode root, 
                                int rootIndex, 
                                ArrayList<Integer> A, 
                                int start, 
                                int end) {
        TreeNode left = null;
        TreeNode right = null;
        int rightRootIndex = -1;
        int leftRootIndex = -1;
        if (rootIndex < end) {
            rightRootIndex = maxUtil(A, rootIndex+1, end);
            right = new TreeNode(A.get(rightRootIndex));
            root.right = right;
        }
        if (rootIndex > start) {
            leftRootIndex = maxUtil(A, start, rootIndex-1);
            left = new TreeNode(A.get(leftRootIndex));
            root.left = left;
        }
        if (left != null) {
            buildTreeUtil(left, leftRootIndex, A, start, rootIndex-1);
        }
        if (right != null) {
            buildTreeUtil(right, rightRootIndex, A, rootIndex+1, end);
        }
    }
    
    private int maxUtil(ArrayList<Integer> A, int start, int end) {
        int max = A.get(start);
        int maxIndex = start;
        if (end == start) {
            return maxIndex;
        } 
        for (int i = start + 1; i <= end; i++) {
            if (A.get(i) > max) {
                max = A.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

/*

1. Find the root node ==> max of the arrayList in range [0, end]
2. root.right ==> max of the arrayList in range [rootIndex+1, end]
3. root.left ==> max of the arrayList in the range [0, rootIndex-1]


*/