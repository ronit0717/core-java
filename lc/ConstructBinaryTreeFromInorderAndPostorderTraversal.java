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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            positionMap.put(inorder[i], i);
        }
        return util(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1, positionMap);
    }

    private TreeNode util(int[] inOrder, int[] postOrder, int poStart, int poEnd,
                            int ioStart, int ioEnd, Map<Integer, Integer> positionMap) {
        if (poStart > poEnd || ioStart > ioEnd) {
            return null;
        }
        int val = postOrder[poEnd];
        TreeNode node = new TreeNode(val);
        int index = positionMap.get(val);
        int length = index - ioStart; //length of left subtree
        TreeNode leftNode = util(inOrder, postOrder, poStart, poStart + length - 1, ioStart, index - 1, positionMap);
        TreeNode rightNode = util(inOrder, postOrder, poStart + length, poEnd - 1, index + 1, ioEnd, positionMap);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}