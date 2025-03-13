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
//Solution 2: Single pass solution
//TC = O(N), SC = O(Height) Auxillary stack space + O(N) for ArrayList
class Solution {
    private TreeNode prev = null;
    private int index1 = -1;
    private int index2 = -1;
    private int index;

    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        buildInorder(root, inorder);
        swap(inorder);
    }

    private void swap(List<TreeNode> inorder) {
        if (index2 == -1) {
            //adjacent case. Swap index1-1 and index1
            int temp = inorder.get(index1 - 1).val;
            inorder.get(index1 - 1).val = inorder.get(index1).val;
            inorder.get(index1).val = temp;;
        } else {
            //swap index1 - 1 and index2
            int temp = inorder.get(index1 - 1).val;
            inorder.get(index1 - 1).val = inorder.get(index2).val;
            inorder.get(index2).val = temp;
        }
    }

    private void buildInorder(TreeNode node, List<TreeNode> inorder) {
        if (node == null) {
            return;
        }
        buildInorder(node.left, inorder);
        if (prev != null && prev.val > node.val) {
            if (index1 == -1) {
                index1 = index;
            } else {
                index2 = index;
            }
        }
        inorder.add(node);
        index++;
        prev = node;
        buildInorder(node.right, inorder);
    }
}

//Solution 1: Two pass solution
//TC = O(N) + O(N), SC = O(Height) Auxillary stack space + O(N) for ArrayList
class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        buildInorder(root, inorder);
        sortCheckAndSwap(inorder);
    }

    private void sortCheckAndSwap(List<TreeNode> inorder) {
        int index1 = -1;
        int index2 = -1;
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i).val < inorder.get(i - 1).val) {
                if (index1 == -1) {
                    index1 = i;
                } else if (index2 == -1) {
                    index2= i;
                }
            }
        }
        if (index2 == -1) {
            //adjacent case. Swap index1-1 and index1
            int temp = inorder.get(index1 - 1).val;
            inorder.get(index1 - 1).val = inorder.get(index1).val;
            inorder.get(index1).val = temp;;
        } else {
            //swap index1 - 1 and index2
            int temp = inorder.get(index1 - 1).val;
            inorder.get(index1 - 1).val = inorder.get(index2).val;
            inorder.get(index2).val = temp;
        }
    }

    private void buildInorder(TreeNode node, List<TreeNode> inorder) {
        if (node == null) {
            return;
        }
        buildInorder(node.left, inorder);
        inorder.add(node);
        buildInorder(node.right, inorder);
    }
}