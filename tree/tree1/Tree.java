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

    private StringBuilder sbForDFS;

    public void printTree(String type){
        this.sbForDFS = new StringBuilder("");
        
        if(this.head == null){
            System.out.println("Tree is empty");
            return;
        }

        StringBuilder sbForDFS = new StringBuilder();

        if(type.equals("DFS-POSTORDER")){
            printTreeDFS1(this.head);
        }else if(type.equals("DFS-INORDER")){
            printTreeDFS2(this.head);
        }else if(type.equals("DFS-PREORDER")){
            printTreeDFS3(this.head);
        }

        System.out.println(this.sbForDFS);
    }

    public void printTreeDFS1(Node node){
        if(node.left != null){
            printTreeDFS1(node.left);
        }

        if(node.right != null){
            printTreeDFS1(node.right);
        }

        this.sbForDFS.append(node.value+" ");
    }

    public void printTreeDFS2(Node node){
        if(node.left != null){
            printTreeDFS2(node.left);
        }

        this.sbForDFS.append(node.value+" ");

        if(node.right != null){
            printTreeDFS2(node.right);
        }
    }

    public void printTreeDFS3(Node node){
        this.sbForDFS.append(node.value+" ");
        
        if(node.left != null){
            printTreeDFS3(node.left);
        }

        if(node.right != null){
            printTreeDFS3(node.right);
        }
    }
}