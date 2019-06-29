import java.io.*;

public class LinkedList {

    Node head;

    public LinkedList(int val){
        Node node = new Node(val);
        this.head = node;
    }

    public void insertNode(int val){
        Node node = new Node(val);
        if(head == null){
            this.head = node;
        }else{
            Node currentNode = this.head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }

            currentNode.next = node;
        }
    }

    public void printList(){
        Node currentNode = this.head;
        System.out.println("Printing LinkedList");

        if(currentNode == null){
            System.out.println("LinkedList is Empty");
        }else{
            while(currentNode != null){
                System.out.println(currentNode.value);
                currentNode = currentNode.next;
            }
        }
        System.out.println("-----------------");
    }

}