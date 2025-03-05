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
//Solution 2: Morris Traversal (SC = O(1), TC ~ O(N))
 Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ansList = new LinkedList<>();
        TreeNode node = root;
        while(node != null) {
            if (node.left == null) {
                ansList.add(node.val); //inorder
                node = node.right;
                continue;
            }
            //1. In left subtree find the right most node (lstrmn)
            TreeNode lstrmn = node.left;
            while(lstrmn.right != null && lstrmn.right != node) {
                lstrmn = lstrmn.right;
            }
            if (lstrmn.right == null) {
                //Create link
                lstrmn.right = node;
                node = node.left; //Need to traverse the left subtree 
            } else if (lstrmn.right == node) { //link already present
                //Implies left subtree already traversed
                lstrmn.right = null; //cut link
                ansList.add(node.val); //inorder
                node = node.right; //Need to traverse the right subtree
            }
        }
        return ansList;
    }
}

//Solution 1
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