/* Solution 1
For a given root 2 cases are possible

1. Current root is in path of the maximum path
2. Current root is the root of the maximum path

We need to select the max between the case 1 and case 2
Compare it with the result and store the maxumum of result of max of case 1 and case 2
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
    public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        
        maxSumUtil(root, result);
        
        return result[0];
    }
    
    private int maxSumUtil(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = maxSumUtil(node.left, result);
        int rightSum = maxSumUtil(node.right, result);
        
        //case 1: current node is in path of maximum path
        int sum1 = Math.max(node.val, node.val + Math.max(leftSum, rightSum));
        
        //case 2: current node is the root of maximum path
        int sum2 = node.val + leftSum + rightSum;
        
        int maxSum = Math.max(sum1, sum2); //max of case1 and case2
        
        result[0] = Math.max(maxSum, result[0]);
        
        return sum1; //return the sum which is in path of the maximum path
    }
    
    
}