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
    //TC = O(Height^2) = O((LogN)^2)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getRightHeight(root.right);
        if (leftHeight == rightHeight) {
            int height = 1 + leftHeight;
            return (int)Math.pow(2, height) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    //TC = O(Height) = O(logN)
    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    //TC = O(Height) = O(LogN)
    private int getRightHeight(TreeNode node) {
        int height = 0;
        while(node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}