class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/

    public static int minTime(Node root, int target) {
        // code here
        Map<Node, Node> parentMap = new HashMap();
        Node targetNode = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        parentMap.put(root, null);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.data == target) {
                    targetNode = node;
                }
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    q.add(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    q.add(node.right);
                }
            }
        }
        int time = -1;
        q.add(targetNode);
        Set<Node> visited = new HashSet<>();
        visited.add(targetNode);
        while(!q.isEmpty()) {
            time++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }
                Node parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.add(parent);
                }
            }
        }
        return time;
    }
}