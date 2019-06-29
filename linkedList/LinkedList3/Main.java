public class Main{

    public static void main(String[] args){
        LinkedList list = new LinkedList(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(5);
        list.insertNode(6);
        list.insertNode(7);
        list.insertNode(8);
        list.insertNode(7, 9);

        list.printList();
    }

}