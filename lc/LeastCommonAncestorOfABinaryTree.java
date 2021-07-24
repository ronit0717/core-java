/* Solution 2 : Shorter code */

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if( root == p || root == q || root == null)
        return root;
    TreeNode left = lowestCommonAncestor( root.left,  p,  q);
    TreeNode right = lowestCommonAncestor( root.right,  p,  q);
    if(left == null)
        return right;
    else if (right == null)
        return left;
    else
        return root;
        
}

//Solution 1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] arr = new TreeNode[1];
        lcaUtil(root, p, q, arr);
        return arr[0];
    }
    
    private int lcaUtil(TreeNode root, TreeNode p, TreeNode q, TreeNode[] arr) {
        if (root == null) {
            return 0;
        }
        int leftStatus = lcaUtil(root.left, p, q, arr);
        
        if ( (leftStatus == 1 && root.val == p.val) || (leftStatus == -1 && root.val == q.val) ) {
            arr[0] = root;
            return 0;
        } else if (leftStatus == 0 && arr[0] != null) {
            return 0;
        }
        
        int rightStatus = lcaUtil(root.right, p, q, arr);
        
        if ( (rightStatus == 1 && root.val == p.val) || (rightStatus == -1 && root.val == q.val) ) {
            arr[0] = root;
            return 0;
        } else if (rightStatus == 0 && arr[0] != null) {
            return 0;
        }
        
        if (leftStatus != 0 && rightStatus != 0) {
            arr[0] = root;
            return 0;
        }
        
        if (root.val == p.val) {
            return -1;
        } else if (root.val == q.val) {
            return 1;
        } else if (leftStatus != 0) {
            return leftStatus;
        } else if (rightStatus != 0) {
            return rightStatus;
        }
        return 0;
        
    }
}