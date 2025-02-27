/*
Approach:
Assign root node as index =  0
Left Node will have index = 2(rootIndex) = 2(0) = 0
Right Node will have index = 2(rootIndex) + 1 = 2(0) +1 = 1

Width each level = (Index of the right most node in each level - Index of the left most node in each level) + 1
*/

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
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<Object[]> q = new LinkedList<>();
        Object[] qNode = {root, 0};
        q.add(qNode);
        while(!q.isEmpty()) {
            int size = q.size();
            int minIndex = 0;
            int maxIndex = 0;
            for (int i = 0; i < size; i++) {
                qNode = q.poll();
                TreeNode node = (TreeNode)qNode[0];
                int index = (int)qNode[1];
                if (i == 0) {
                    minIndex = index;
                }
                if (i == (size - 1)) {
                    maxIndex = index;
                }
                if (node.left != null) {
                    int leftIndex = 2 * index;
                    Object[] leftQNode = {node.left, leftIndex};
                    q.add(leftQNode);
                }
                if (node.right != null) {
                    int rightIndex = 2 * index + 1;
                    Object[] rightQNode = {node.right, rightIndex};
                    q.add(rightQNode);
                }
            }
            int width = maxIndex - minIndex + 1;
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
    }
}