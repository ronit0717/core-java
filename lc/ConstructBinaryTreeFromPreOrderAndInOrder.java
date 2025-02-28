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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            positionMap.put(inorder[i], i);
        }
        return treeUtil(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, positionMap);
    }

    private TreeNode treeUtil(int[] preOrder, int[] inOrder, int poStart, int poEnd, 
                              int ioStart, int ioEnd, Map<Integer, Integer> positionMap) {
        //base condition
        if(poStart > poEnd || ioStart > ioEnd) {
            return null;
        }
        int val = preOrder[poStart];
        TreeNode node = new TreeNode(val);
        int index = positionMap.get(val);
        int leftLength = index - ioStart;
        TreeNode leftNode = treeUtil(preOrder, inOrder, poStart + 1, poStart + leftLength, ioStart, index - 1, positionMap);
        TreeNode rightNode = treeUtil(preOrder, inOrder, poStart + leftLength + 1, poEnd, index + 1, ioEnd, positionMap);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}