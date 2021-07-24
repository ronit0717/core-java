//Similar Question: https://github.com/ronit0717/core-java/blob/master/lc/ConstructBinaryTreeFromProorderAndInorderTraversal.java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeUtil(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeUtil(int[] io, int[] po, int poIndex, int ioStart, int ioEnd) {
        if (ioStart > ioEnd) {
            return null;
        }
        
        int pivot = -1;
        for (int i = ioStart; i <= ioEnd; i++) {
            if (io[i] == po[poIndex]) {
                pivot = i;
                break;
            }
        }
        
        TreeNode right = buildTreeUtil(io, po, poIndex - 1, pivot + 1, ioEnd);
        TreeNode left  = buildTreeUtil(io, po, poIndex - (ioEnd - pivot) - 1, ioStart, pivot - 1);
        
        return new TreeNode(po[poIndex], left, right);
    }
}