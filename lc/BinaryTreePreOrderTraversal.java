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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop(); //pop
            list.add(node.val); //print
            if (node.right != null) { //push right
                stack.push(node.right);
            }
            if (node.left != null) { //push left
                stack.push(node.left);
            }
        }
        return list;
    }
}