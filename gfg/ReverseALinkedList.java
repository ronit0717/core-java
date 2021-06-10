class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

/* Iterative Approach */
class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        // code here
        Node prev = null;
        Node newHead = null;
        while (newHead == null) {
            Node next = head.next;
            head.next = prev;
            if (next == null) {
                newHead = head;
            }
            prev = head;
            head = next;
        }
        return newHead;
    }
}


/* Recursive Approach */
class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        // code here
        if (head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        head.next = null;
        return reverseUtil(head, next);
    }
    
    private Node reverseUtil(Node prev, Node curr) {
        Node next = curr.next;
        curr.next = prev;
        if (next == null) {
            return curr;    //this will be the new head
        }
        return reverseUtil(curr, next);
    }
}