//Problem Link: https://www.naukri.com/code360/problems/boundary-traversal_790725

/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        list.add(root.data);
        
        //left side
        getLeftBoundary(root, list);

        //leaf
        getLeafBoundary(root, list);

        //right node
        getRightBoundary(root, list);
        return list;
    }

    //TC: O(Height)
    private static void getLeftBoundary(TreeNode root, List<Integer> list) {
        TreeNode node = root.left;
        if (node == null) {
            return;
        }
        while (node != null) {
            if (node.left == null && node.right == null) {
                break;
            }
            list.add(node.data);
            node = node.left == null ? node.right : node.left;
        }
    }

    //TC: O(Number of Nodes)
    private static void getLeafBoundary(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            return; //root is leaf
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            st.push(node);
            node = node.left;
        }
        while(!st.isEmpty()) {
            node = st.pop();
            if (node.left == null && node.right == null) {
                list.add(node.data);
            }
            node = node.right;
            while (node != null) {
                st.push(node);
                node = node.left;
            }
        }
        
    }

    //TC: O(Height)
    private static void getRightBoundary(TreeNode root, List<Integer> list) {
        TreeNode node = root.right;
        if (node == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        while (node != null) {
            if (node.left == null && node.right == null) {
                break;
            }
            st.push(node);
            node = node.right == null ? node.left : node.right;
        }
        while(!st.isEmpty()) {
            list.add(st.pop().data);
        }
    }
}