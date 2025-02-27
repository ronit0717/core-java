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

//Solution 2: Using recursive approach
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        evaluate(root, 0, list);
        return list;
    }

    private void evaluate(TreeNode node, int level, List<Integer> list) {
        if(node == null) {
            return;
        }
        if(list.size() <= level) {
            list.add(node.val);
        }
        evaluate(node.right, level + 1, list);
        evaluate(node.left, level + 1, list);
    }
}

//Solution 1: Using level order traversal
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int val = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                val = (i == 0) ? node.val : val;
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
            list.add(val);
        }
        return list;
    }
}