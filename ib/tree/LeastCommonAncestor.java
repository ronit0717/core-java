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
    
    private static void lcaUtil(Stack<TreeNode> bSt, 
                                Stack<TreeNode> cSt, 
                                boolean[] found, 
                                TreeNode curr, 
                                int B, 
                                int C) {
        
        if (!found[0]) {
            bSt.push(curr);
            if (curr.val == B) {
                found[0] = true;
            }
        }
        
        if (!found[1]) {
            cSt.push(curr);
            if (curr.val == C) {
                found[1] = true;
            }
        }
                                       
    }
    
    private static void popUtil(Stack<TreeNode> bSt, Stack<TreeNode> cSt, boolean[] found) {
        if (!found[0]) {
            bSt.pop();
        }
        
        if (!found[1]) {
            cSt.pop();
        }
    }
    
    public int lca(TreeNode A, int B, int C) {
        boolean[] found = new boolean[2];
        found[0] = false;
        found[1] = false;
        
        Stack<TreeNode> bSt = new Stack<>();
        Stack<TreeNode> cSt = new Stack<>();
        Stack<TreeNode> st = new Stack<>();
        
        st.push(A);
        lcaUtil(bSt, cSt, found, A, B, C);
        
        while (A.left != null) {
            A = A.left;
            st.push(A);
            lcaUtil(bSt, cSt, found, A, B, C);
        }
        
        TreeNode prev = null;
        
        while (!st.isEmpty()) {
            
            TreeNode curr = st.peek();
            if (curr.right != null && prev != curr.right) {
                curr = curr.right;
                st.push(curr);
                lcaUtil(bSt, cSt, found, curr, B, C);
                
                while (curr.left != null) {
                    curr = curr.left;
                    st.push(curr);
                    lcaUtil(bSt, cSt, found, curr, B, C);
                }
                continue;
            }
            
            prev = st.pop();
            popUtil(bSt, cSt, found);
            
        }
        
        if (!found[0] || !found[1]) {
            return -1;
        }
        
        Stack lSt = null;
        Stack sSt = null;
        if (bSt.size() > cSt.size()) {
            lSt = bSt;
            sSt = cSt;
        } else {
            lSt = cSt;
            sSt = bSt;
        }
        
        while (!lSt.isEmpty()) {
            TreeNode curr = (TreeNode)lSt.pop();
            if (sSt.contains(curr)) {
                return curr.val;
            }
        }
        return -1;
        
    }
}
