import java.util.LinkedList; 
import java.util.Queue; 

public class Tree{
    Node head;

    public Tree(Node node){
        this.head = node;
    }

    public Tree(int val){
        Node node = new Node(val);
        new Tree(node);
    }

    public Tree(){
        this.head = null;
    }

    public void insertNode(int val){
        //Inorder insertion of node

        Node node = new Node(val);

        if(head == null){
            head = node;
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(this.head);

        while(!q.isEmpty()){
            Node temp = q.peek();
            q.remove();

            if(temp.left == null){
                temp.left = node;
                break;
            }else{
                q.add(temp.left);
            }

            if(temp.right == null){
                temp.right = node;
                break;
            }else{
                q.add(temp.right);
            }
        }
    }

    public void printTreeLevelOrder(){
        if(this.head == null){
            System.out.println("Tree is empty");
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(this.head);
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            Node temp = q.peek();
            sb.append(temp.value+" ");
            
            q.remove();

            if(temp.left != null){
                q.add(temp.left);
            }

            if(temp.right != null){
                q.add(temp.right);
            }
        }

        System.out.println(sb);
    }
}