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
        list.insertFirst(10);

        list.printList();

        list.removeNode();
        list.removeNode(4);

        list.printList();

        list.removeNode(-1);
        list.removeNode(7);
        list.removeNode(7);
        list.removeNode(0);
        list.printList();

        if(list.containsNode(4)){
            System.out.println("Yes List contains the node");
        }else{
            System.out.println("No List does not contain the node");
        }

        System.out.println("Length of the LinkedList-->"+list.getListLength());

        list.removeHead();
        list.printList();

        int val = list.getNode(2);
        System.out.println("Element is-->"+val);

        val = list.getNode(6);
        System.out.println("Element is-->"+val);

        list.setNode(2, 10);
        list.printList();

    }

}