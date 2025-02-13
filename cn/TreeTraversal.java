/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> preOrderList = new LinkedList<>();
        List<Integer> inOrderList = new LinkedList<>();
        List<Integer> postOrderList = new LinkedList<>();
        inOrder(root, inOrderList);
        preOrder(root, preOrderList);
        postOrder(root, postOrderList);
        List<List<Integer>> ans = new ArrayList<>(3);
        ans.add(inOrderList);
        ans.add(preOrderList);
        ans.add(postOrderList);
        return ans;
    }

    private static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);
    }

    private static void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.data);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    private static void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.data);
    }
}