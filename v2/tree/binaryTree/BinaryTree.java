// non-recursive java program for inorder traversal 
import java.util.Stack;

class BinaryTree {
    
    Node root;
    
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inOrderIterative();
    }

    void inOrderIterative() {
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(this.root);
        Node prev = null;
        while(!nodeStack.isEmpty()) {
            Node curr = nodeStack.peek();
            if (curr.left != null && curr.left == prev) {
                print(curr.data);
                if (curr.right != null) {
                    nodeStack.push(curr.right);
                } else {
                    nodeStack.pop();
                }
            } else if (curr.left != null && curr.left != prev) {
                if (curr.right != null && curr.right == prev) {
                    nodeStack.pop();
                } else {
                    nodeStack.push(curr.left);
                }
            } else {
                print(curr.data);
                if (curr.right != null) {
                    nodeStack.push(curr.right);
                } else {
                    nodeStack.pop();
                }
            }
            prev = curr;
        }
    }

    void print(Object obj) {
        System.out.println(obj);
    }

    boolean isFused(int loopCount) {
        if (loopCount > 20) {
            print("FALL SAFE FUSE");
            return true;
        }
        return false;
    }
}

/*
 * Class containing left and right child of current node and key value
 */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
