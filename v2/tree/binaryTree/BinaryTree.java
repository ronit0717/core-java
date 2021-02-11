// non-recursive java program for inorder traversal 
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    
    Node root;
    
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.left.left.left = new Node(7);

        tree.inOrderIterative();
        tree.preOrderIterative();
        tree.postOrderIterative();
        tree.levelOrder();
    }

    void levelOrder() {
        print("\nPrint level order");
        Queue<Node> qNode = new LinkedList<>();
        qNode.add(this.root);
        qNode.add(null);
        int loopCount = 0;
        Node prev = null;
        while(!qNode.isEmpty() && !isFused(loopCount)) {
            loopCount++;
            Node curr = qNode.poll();
            if (curr == null){
                if(prev == null) {
                    break;
                }
                System.out.print("\n");
                qNode.add(null);
            } else {
                System.out.print(curr.data+" ");
            }
            if (curr!= null && curr.left != null) {
                qNode.add(curr.left);
            }
            if (curr!=null && curr.right != null) {
                qNode.add(curr.right);
            }
            prev = curr;
        }
    }

    void inOrderIterative() {
        print("\nIn order iterative");
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(this.root);
        Node prev = null;
        int loopCount = 0;
        while(!nodeStack.isEmpty() && !isFused(loopCount)) {
            loopCount++;
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
                if (curr.right != null && curr.right == prev) {
                    nodeStack.pop();
                } else if (curr.right != null && curr.right != prev) {
                    print(curr.data);
                    nodeStack.push(curr.right);
                } else {
                    print(curr.data);
                    nodeStack.pop();
                }
            }
            prev = curr;
        }
    }

    void preOrderIterative() {
        print("\nPre order iterative");
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(this.root);
        Node prev = null;
        while(!nodeStack.isEmpty()) {
            Node curr = nodeStack.pop();
            print(curr.data);
            if (curr.right != null) {
                nodeStack.push(curr.right);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
            }
        }
    }

    void postOrderIterative() {
        print("\nPost order iterative");
        Node prev = null;
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(this.root);
        while(!nodeStack.isEmpty()) {
            Node curr = nodeStack.peek();
            if ( (curr.left != null && curr.left != prev && 
                    curr.right != null && curr.right != prev) 
                || (curr.left == null && curr.right != null && curr.right != prev) 
                || (curr.right == null && curr.left != null && curr.left != prev) 
            ) {
                //means not going back
                if (curr.right != null) {
                    nodeStack.push(curr.right);
                }
                if (curr.left != null) {
                    nodeStack.push(curr.left);
                }
            } else {
                print(curr.data);
                nodeStack.pop();
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
