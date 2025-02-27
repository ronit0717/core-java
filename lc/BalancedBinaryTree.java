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
//Solution 2: TC = O(N), SC = O(N) Auxilary stack space
class Solution {
    public boolean isBalanced(TreeNode root) {
        int height = getBalancedHeight(root);
        return height == -1 ? false : true;
    }
    
    //return height if balanced, return -1 if not balanced
    private int getBalancedHeight(TreeNode root) {
        int height = 0;
        if (root == null) {
            return height;
        }
        int leftHeight = getBalancedHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getBalancedHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        int diff = Math.abs(rightHeight - leftHeight);
        if (diff > 1) {
            return -1;
        }
        return 1 + Math.max(rightHeight, leftHeight);
    }
}

/**
 * Solution 1: TC = O(N^2), SC = O(N)
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return true;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}