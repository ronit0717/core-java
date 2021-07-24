/*
The preorder array will provide the root
In the inorder array find this root, all elements in the left of inorder will be the left half of the tree, 
all elements in the right of this root will be the right half of the tree
*/
//Similar Question: https://github.com/ronit0717/core-java/blob/master/lc/ConstructBinaryTreeFromInorderAndPostorderTraversal.java
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeUtil(int[] po, int[] io, int poIndex, int ioStart, int ioEnd) {
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
        
        TreeNode left = buildTreeUtil(po, io, poIndex + 1, ioStart, pivot - 1);
        TreeNode right = buildTreeUtil(po, io, poIndex + (pivot - ioStart) + 1, pivot + 1, ioEnd);
        
        return new TreeNode(po[poIndex], left, right);
    }
}