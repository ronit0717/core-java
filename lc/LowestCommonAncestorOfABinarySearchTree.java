/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//TC = O(N), SC=O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        TreeNode left = p.val > q.val ? q : p;
        TreeNode right = p.val > q.val ? p : q;
        while(true) {
            if (left.val == node.val || right.val == node.val) {
                break;
            }
            if (left.val < node.val && right.val > node.val) {
                break;
            }
            if (node.val < left.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }
}