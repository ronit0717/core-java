/*
Approach:
Assign root node as level 0
Left Node will have level = 2(rootLevel) = 2(0) = 0
Right Node will have level = 2(rootLevel) + 1 = 2(0) +1 = 1

Width each level = (Level of the right most node in each level - Level of the left most node in each level)
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
        if (root == null) {
            return 0;
        }
        Queue<Object[]> q = new LinkedList<>();
        
        q.add(new Object[]{root, 0});
        q.add(null);
        
        int maxWidth = 0;
        
        int start = 0;
        
        while (!q.isEmpty()) {
            Object[] obj = q.poll();
            
            if (obj == null && q.isEmpty()) {
                break;
            } else if (obj == null) {
                q.add(null);
                start = (int)q.peek()[1];
                continue;
            }
            
            TreeNode curr = (TreeNode)obj[0];
            int currLevel = (int)obj[1];
            
            if (q.peek() == null) { //level ends
                int currLevelWidth = currLevel - start + 1;
                maxWidth = Math.max(maxWidth, currLevelWidth);
            }
            
            if (curr.left != null) {
                q.add(new Object[]{ curr.left,  currLevel*2});
            }
            
            if (curr.right != null) {
                q.add(new Object[]{ curr.right,  currLevel*2 + 1});
            }
            
            
        }
        
        return maxWidth;
    }
    
    
}