/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        for (Node n : root.children) {
            depth = Math.max(depth, maxDepth(n));
        }
        return depth + 1;
    }
}