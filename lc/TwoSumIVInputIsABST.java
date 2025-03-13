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

//TC = O(N), SC=(O(2H))
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> ascStack = initAscStack(root);
        Stack<TreeNode> descStack = initDescStack(root);
        while(!ascStack.isEmpty() && !descStack.isEmpty() 
                && ascStack.peek().val < descStack.peek().val) {
            TreeNode left = ascStack.peek();
            TreeNode right = descStack.peek();
            int sum = left.val + right.val;
            if (sum == k) {
                return true;
            } else if (sum < k) {
                getNext(ascStack);
            } else {
                getBefore(descStack);
            }
        }
        return false;
    }

    private Stack<TreeNode> initAscStack(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(node != null) {
            st.push(node);
            node = node.left;
        }
        return st;
    }

    private Stack<TreeNode> initDescStack(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(node != null) {
            st.push(node);
            node = node.right;
        }
        return st;
    }

    private void getNext(Stack<TreeNode> st) {
        TreeNode target = st.pop();
        TreeNode node = target.right;
        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }

    private void getBefore(Stack<TreeNode> st) {
        TreeNode target = st.pop();
        TreeNode node = target.left;
        while(node != null) {
            st.push(node);
            node = node.right;
        }
    }
}

//Solution 0: Write inorder (which will be sorted), and apply logic of Two Sum (https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/)
//TC = O(N), SC = O(N) to store the inorder