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
//Solution 1: Using upper bound approach
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] p = {0};
        return bstUtil(p, preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstUtil(int[] p, int[] preorder, int bound) {
        if (p[0] >= preorder.length) {
            return null;
        }
        int val = preorder[p[0]];
        if(val >= bound) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        p[0] = ++p[0]; //move pointer
        node.left = bstUtil(p, preorder, val);
        node.right = bstUtil(p, preorder, bound);
        return node;
    }
}

/*Solution 0:
  * 1. Sort the array to form a inorder
  * 2. Use inorder and preorder to construct the BST (https://takeuforward.org/data-structure/construct-a-binary-tree-from-inorder-and-preorder-traversal/)  