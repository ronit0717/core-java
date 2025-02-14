//Solution 1: Using Two Stacks
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node);
            if (node.left != null) {
                st1.push(node.left);
            }
            if (node.right != null) {
                st1.push(node.right);
            }
        }
        while (!st2.isEmpty()) {
            list.add(st2.pop().val);
        }
        return list;
    }
}