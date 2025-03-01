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
//Solution 2: Morris Traversal (SC=O(1), TC~O(N))
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ansList = new LinkedList<>();
        TreeNode node = root;
        while(node != null) {
            if (node.left == null) {
                ansList.add(node.val); //preorder
                node = node.right;
                continue;
            }
            //Find targetNode: right most node in the left subtree
            TreeNode targetNode = node.left;
            while(targetNode.right != null && targetNode.right != node) {
                targetNode = targetNode.right;
            }
            if (targetNode.right == node) {
                //connection already present, left subtree already traversed
                targetNode.right = null;
                node = node.right;
            } else if (targetNode.right == null) {
                //Need to make connection and traverse the left subtree
                targetNode.right = node;
                ansList.add(node.val); //preorder
                node = node.left;
            }
        }
        return ansList;
    }
}


//Solution 1
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