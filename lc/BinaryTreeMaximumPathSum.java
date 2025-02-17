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
    public int maxPathSum(TreeNode root) {
        int[] maxPathSum = {Integer.MIN_VALUE};
        evaluateNode(root, maxPathSum);
        return maxPathSum[0];
    }

    private int evaluateNode(TreeNode node, int[] maxPathSum) {
        if (node == null) {
            return 0;
        }
        int leftPathSum = evaluateNode(node.left, maxPathSum);
        int rightPathSum = evaluateNode(node.right, maxPathSum);
        int currentPathSum = node.val + leftPathSum + rightPathSum; //path sum including current node
        maxPathSum[0] = Math.max(currentPathSum, maxPathSum[0]);
        int segmentPathSum = node.val + Math.max(leftPathSum, rightPathSum);
        return segmentPathSum > 0 ? segmentPathSum : 0; //if negative, this node segment to be ignored
    }
}