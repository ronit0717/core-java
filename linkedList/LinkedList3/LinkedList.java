import java.io.*;

public class LinkedList {

    Node head;

    public LinkedList(int val){
        Node node = new Node(val);
        this.head = node;
    }

    public int getListLength(){
        int len = 0;
        Node currentNode = head;
        while(currentNode != null){
            len++;
            currentNode = currentNode.next;
        }

        return len;
    }

    public void insertFirst(int val){
        insertNode(0, val);
    }

    //Code to remove Node
    public void removeNode(){
        int len = getListLength();
        len--;
        removeNode(len);

    }

    public void removeHead(){
        removeNode(0);
    }

    public void removeNode(int pos){
        if(pos < 0 || pos>= getListLength()){
            System.out.println("Error --> position out of index");
            return;
        }

        if(pos == 0){
            //head node remove
            head = head.next;
        }else{
            int counter = 1;

            Node currentNode = head;
            while(counter < pos){
                counter++;
                currentNode = currentNode.next;
            } 

            currentNode.next = currentNode.next.next;

        }

    }

    //Code to get Element at nth Position
    public int getNode(int pos){
        if(pos < 0 || pos>= getListLength()){
            System.out.println("Error --> position out of index");
            return -1;
        }else{
            int counter = 0;
            Node currentNode = head;
            while(counter < pos){
                counter++;
                currentNode = currentNode.next;
            }

            return currentNode.value;
        }
    }

    //Code to get Element at nth Position
    public void setNode(int pos, int val){
        if(pos < 0 || pos>= getListLength()){
            System.out.println("Error --> position out of index");
            return;
        }else{
            int counter = 0;
            Node currentNode = head;
            while(counter < pos){
                counter++;
                currentNode = currentNode.next;
            }

            currentNode.value = val;
        }
    }



    //Code to inser Node at nth Position
    public void insertNode(int pos, int val){
        Node node = new Node(val);

        if(pos < 0 || pos>= getListLength()){
            System.out.println("Error --> position out of index");
            return;
        }

        if(pos == 0){
            //head node case
            if(head == null){
                head = node;
            }else{
                node.next = head;
                head = node;
            }
        }else{
            int counter = 1;

            Node currentNode = head;
            while(counter < pos){
                counter++;
                currentNode = currentNode.next;
            } 

            node.next = currentNode.next;
            currentNode.next = node;

        }


    }

    //Code to insert Node at the end
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

    //Code to check if the linkedlist contains a node
    public boolean containsNode(int val){

        Node currentNode = head;
        while(currentNode != null){
            if(currentNode.value == val){
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public void printList(){
        Node currentNode = this.head;
        System.out.println("\n*******************");
        System.out.println("Printing LinkedList");
        System.out.println("-------------------");

        if(currentNode == null){
            System.out.println("LinkedList is Empty");
        }else{
            boolean isHead = true;
            while(currentNode != null){
                if(isHead){
                    System.out.print(currentNode.value);
                    isHead = false;
                }else{
                    System.out.print(" -> "+currentNode.value);
                }
                currentNode = currentNode.next;
            }
        }
        System.out.println("\n*******************");
    }

}