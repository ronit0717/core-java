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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (node != null) { //go left deep
            st.push(node);
            node = node.left;
        }
        while (!st.isEmpty()) {
            node = st.pop();
            list.add(node.val);
            node = node.right;
            while (node != null) { //go left deep
                st.push(node);
                node = node.left;
            }
        }
        return list;
    }
}