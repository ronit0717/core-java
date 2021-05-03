/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int isValidBST(TreeNode A) {
        return isBSTUtil(A, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private int isBSTUtil(TreeNode A, long min, long max) {
        if (A == null) {
            return 1;
        }
        if (A.val < min || A.val > max) {
            return 0;
        }
        int left = isBSTUtil(A.left, min, (long)A.val - 1);
        if (left == 0) {
            return left;
        }
        int right = isBSTUtil(A.right, (long)A.val + 1, max);
        return right;
    }
}


/* Alternative approach

Do a inorder traversal, the output should be sorted in ascending order

*/