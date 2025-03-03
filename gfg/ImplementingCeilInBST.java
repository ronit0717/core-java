//Problem Link: https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        Node node = root;
        int ceil = -1;
        while (node != null) {
            if (node.data == key) {
                return key;
            }
            if (node.data > key) {
                ceil = node.data;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ceil;
    }
}