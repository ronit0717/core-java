//Solution 2: Go Left Deep Approach
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
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            list.add(node.val);
            st.push(node); //print
            node = node.left; //go left deep
        }
        while (!st.isEmpty()) {
            node = st.pop();
            node = node.right;
            while (node != null) {
                list.add(node.val);
                st.push(node); //print
                node = node.left; //go left deep
            }
        }
        return list;
    }
}

//Solution 1
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