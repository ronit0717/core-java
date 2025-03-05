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
//Solution 2: Morris Traversal (TC = O(N), SC=O(1))
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        int count = 0;
        int ans = 0;
        while (node != null) {
            if (node.left == null) {
                count++;
                if (count == k) {
                    ans = node.val;
                    break;
                }
                node = node.right;
                continue;
            }
            TreeNode target = node.left;
            while (target.right != null && target.right != node) {
                target = target.right;
            }
            if (target.right == null) {
               target.right = node; //make connection
               node = node.left; //Traverse Left
            } else if (target.right == node) {
                target.right = null; //remove connection
                count++;
                if (count == k) {
                    ans = node.val;
                    break;
                }
                node = node.right; //Traverse right
            }
        }
        return ans;
    }
}

//Solution 1: Iterative inorder traversal (TC = O(N), SC = O(N))
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        while(node != null) {
            st.push(node);
            node = node.left;
        }
        int count = 0;
        int ans = 0;
        while(!st.isEmpty()) {
            node = st.pop();
            count++;
            if (count == k) {
                ans = node.val;
                break;
            }
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    st.push(node);
                    node = node.left;
                }
            }
        }
        return ans;
    }
}