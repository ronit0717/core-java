/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Object[]> q = new LinkedList<>();
        Object[] qNode = {root, 0};
        q.add(qNode);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                qNode = q.poll();
                Node node = (Node)qNode[0];
                int axis = (int)qNode[1];
                if (!map.containsKey(axis)) {
                    map.put(axis, node.data);
                }
                if (node.left != null) {
                    Object[] leftQNode = {node.left, axis - 1};
                    q.add(leftQNode);
                }
                if (node.right != null) {
                    Object[] rightQNode = {node.right, axis + 1};
                    q.add(rightQNode);
                }
            }
        }
        //prepare list
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}