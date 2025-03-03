//Problem Link: https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }
}
