//Problem link: https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1

// User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor(Node root, Node x) {
        // add code here.
        int ans = -1;
        Node node = root;
        while(node != null) {
            if (node.data > x.data) {
              ans = ans == -1 ? node.data : Math.min(ans, node.data);
              node = node.left;  
            } else {
              node = node.right;
            }
        }
        return ans;
    }
}