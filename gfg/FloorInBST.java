//Problem Link: https://www.geeksforgeeks.org/problems/floor-in-bst/1
class Solution {
    public static int floor(Node root, int x) {
        // Code here
        int floor = -1;
        Node node = root;
        while (node != null) {
            if (node.data == x) {
                floor = x;
                break;
            } else if (node.data < x) {
                floor = node.data;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return floor;
    }
}