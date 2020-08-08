import java.io.*;

public class Main{
    public static void main(String  args[]){
        System.out.println("Executing Tree Main");

        Tree tree = new Tree();
        tree.insertNode(1);
        tree.insertNode(2);
        tree.insertNode(3);
        tree.insertNode(4);
        tree.insertNode(5);
        tree.insertNode(6);

        System.out.println("LEVEL ORDER TREE:");
        tree.printTreeLevelOrder();

        System.out.println("\nPOST ORDER DFS:");
        tree.printTree("DFS-POSTORDER");

        System.out.println("\nIN ORDER DFS:");
        tree.printTree("DFS-INORDER");

        System.out.println("\nPRE ORDER DFS:");
        tree.printTree("DFS-PREORDER");
    }
}