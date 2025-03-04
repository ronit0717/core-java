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

//TC = O(Height of Tree), SC = O(1)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) { //Root is the target node to be deleted
            TreeNode leftLargest = getLargestNode(root.left);
            if (leftLargest == null) {
                return root.right;
            }
            leftLargest.right = root.right;
            return root.left;
        }
        TreeNode parent = getTargetParent(root, key);
        if (parent == null) { //target node to be deleted not found
            return root;
        }
        if (parent.left != null && parent.left.val == key) {
            TreeNode largestLeft = getLargestNode(parent.left.left);
            if (largestLeft == null) {
                parent.left = parent.left.right;
            } else {
                largestLeft.right = parent.left.right;
                parent.left = parent.left.left;
            }
        } else if (parent.right != null && parent.right.val == key) {
            TreeNode largestLeft = getLargestNode(parent.right.left);
            if (largestLeft == null) {
                parent.right = parent.right.right;
            } else {
                largestLeft.right = parent.right.right;
                parent.right = parent.right.left;
            }
        }
        return root;
    }

    private TreeNode getLargestNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode getTargetParent(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode node = root;
        while(true) {
            if (node == null) {
                return null; //node not found
            }
            if (node.val == key) {
                return parent;
            } else {
                parent = node;
                node = node.val < key ? node.right : node.left;
            }
        }
    }
}