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
//Solution 3: Morris Traversal (TC = O(N), SC = O(1))
class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while(node != null) {
            if (node.left == null) {
                node = node.right;
                continue;
            }
            TreeNode target = node.left;
            while(target.right != null) {
                target = target.right;
            }
            target.right = node.right;
            node.right = node.left;
            node.left = null;
            node = node.right;
        }
    }
}

//Solution 2: Iterative approach using stack (TC = O(n), SC = O(LogN) for the stack)
class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) {
            return;
        }
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
            node.right = st.isEmpty() ? null : st.peek();
            node.left = null;
        }
    }
}

//Solution 1: Recursive Approach (TC = O(N), SC = O(LogN) for auxillary stack stace)
class Solution {
    public void flatten(TreeNode root) {
        TreeNode prev = null;
        flatUtil(root, prev);
    }

    private TreeNode flatUtil(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }
        prev = flatUtil(root.right, prev);
        prev = flatUtil(root.left, prev);
        root.right = prev;
        root.left = null;
        return root;
    }
}