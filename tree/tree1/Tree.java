public class Tree{
    Node head;

    public Tree(Node node){
        this.head = node;
    }

    public Tree(int val){
        Node node = new Node(val);
        Tree(node);
    }
}