class Solution{
    public static void createTree(Node root0, ArrayList<Integer> v ){
        // Code here
        ArrayList<Node> nodeList = new ArrayList<>(v.size());
        nodeList.add(root0);
        for (int n = 1; n < v.size(); n++) {
            Node node = new Node(v.get(n));
            nodeList.add(node);
        }
        
        int leftPointer = 1;
        int rightPointer = 2;
        for (int n = 0; n < v.size(); n++) {
            Node current = nodeList.get(n);
            if (leftPointer < v.size()) {
                current.left = nodeList.get(leftPointer);    
            }
            if (rightPointer < v.size()) {
                current.right = nodeList.get(rightPointer);    
            }
            leftPointer += 2;
            rightPointer += 2;
        }
    }
}