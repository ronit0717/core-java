/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

//Solution 2: Recursive Approach
class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        evaluate(root, path, paths);
        return paths;
    }
    
    private static void evaluate(Node node, 
                                ArrayList<Integer> path, 
                                ArrayList<ArrayList<Integer>> paths) {
        if (node == null) {
            return;
        }
        path.add(node.data);
        
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            evaluate(node.left, path, paths);
            evaluate(node.right, path, paths);
        }
        
        path.remove(path.size() - 1); //remove last
    }
}


//Solution 1: Iterative Approach (similar to post order traversal)
class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        Stack<Node> st = new Stack<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Node node = root;
        while(node != null) {
            st.push(node);
            node = node.left;
        }
        Node prev = null;
        while(!st.isEmpty()) {
            node = st.peek();
            if (node.left == null && node.right == null) {
                //leaf node
                paths.add(buildPath(st));
                prev = st.pop();
            } else if (node.right != null && prev != node.right) {
                node = node.right;
                while(node != null) {
                    st.push(node);
                    node = node.left;
                }
            } else {
                prev = st.pop();
            }
        }
        return paths;
    }
    
    private static ArrayList<Integer> buildPath(Stack<Node> st) {
        ArrayList<Integer> path = new ArrayList<>(st.size());
        Stack<Node> stClone = (Stack<Node>)st.clone();
        while(!stClone.isEmpty()) {
            path.add(stClone.pop().data);
        }
        Collections.reverse(path);
        return path;
    }
}