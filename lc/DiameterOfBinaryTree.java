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
//Solution 2: TC = O(N), SC=O(N)
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] diameter = new int[1];
        getHeight(root, diameter);
        return diameter[0];
    }

    private int getHeight(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left, diameter);
        int rightHeight = getHeight(node.right, diameter);
        int localDiameter = leftHeight + rightHeight;
        diameter[0] = Math.max(localDiameter, diameter[0]);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

//Solution 1: TC = O(N^2), SC=O(N)
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int diameter = leftHeight + rightHeight;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}