import java.io.*;

public class Main{
    public static void main(String  args[]){
        System.out.println("Executing Tree Main");

        Tree tree = new Tree();

        System.out.println("Print1:");
        tree.printTreeLevelOrder();

        tree.insertNode(1);
        tree.insertNode(2);
        tree.insertNode(3);

        System.out.println("Print2:");
        tree.printTreeLevelOrder();

        tree.insertNode(4);
        tree.insertNode(5);

        System.out.println("Print3:");
        tree.printTreeLevelOrder();

        tree.insertNode(6);
        System.out.println("Print4:");
        tree.printTreeLevelOrder();
    }
}