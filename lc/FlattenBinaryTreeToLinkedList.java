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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        //flatten each child
        flatten(root.left);
        flatten(root.right);
        
        //swap
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        
        //treverse right till end
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        
        node.right = temp;
    }
}