//Solution 2: Iterative Solution
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
import java.util.Stack;

public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> preOrder = new LinkedList<>();
        List<Integer> inOrder = new LinkedList<>();
        List<Integer> postOrder = new LinkedList<>();
        
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        while(node != null) {
            preOrder.add(node.data);
            st.push(node);
            node = node.left; //go left deep
        }

        TreeNode prev = null;
        while(!st.isEmpty()) {
            node = st.peek();
            if (node.right == null) { //leaf node
                postOrder.add(node.data);
                inOrder.add(node.data);
                prev = st.pop();
            } else if (node.right == null || prev == node.right) { //no right or left and right already visited
                postOrder.add(node.data);
                prev = st.pop();
            } else { //need to traverse right
                inOrder.add(node.data);
                node = node.right;
                while (node != null) {
                    preOrder.add(node.data);
                    st.push(node);
                    node = node.left; //go left deep
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>(3);
        ans.add(inOrder);
        ans.add(preOrder);
        ans.add(postOrder);
        return ans;
    }
}

//Solution 1: Recursive Solution
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