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

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Object[] qNode = {root, 0};
        Queue<Object[]> q = new LinkedList<>();
        q.add(qNode);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                qNode = q.poll();
                Node node = (Node)qNode[0];
                int axis = (int)qNode[1];
                map.put(axis, node.data);
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
        
        //Populate list
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}