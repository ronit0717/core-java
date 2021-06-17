/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

//Solution 2: TC = O(N), SC = O(1)
/* Algo
Step 1: create the clone node and set it to the next of current node
Step 2: Setting random node of clone nodes
Step 3: Resetting the two linkedlists
*/
class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null) {
            return null;
        }
        
        //Step 1: create the clone node and set it to the next of current node
        Node curr = head;
        while (curr != null) {
            Node cloneNode = new Node(curr.val);
            Node next = curr.next;
            curr.next = cloneNode;
            cloneNode.next = next;
            curr = next;
        }
        
        //Step 2: Setting random node of clone nodes
        curr = head;
        while (curr != null) {
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }
        
        Node cloneHead = head.next;
        
        //Step 3: Resetting the two linkedlists
        curr = head;
        while (true) {
            Node next = curr.next;
            if (next == null) {
                break; //last node
            }
            curr.next = curr.next.next;
            curr = next;
        }
        
        return cloneHead;
    }
}

//Solution 1: Using hashmap to map between original to clone. TC = O(N), SC = O(N)
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        
        Node curr = head;
        Node clone = null;
        Node prev = null;
        
        while (curr != null) {
            Node newNode = new Node(curr.val);
            clone = (clone == null) ? newNode : clone;
            if (prev != null) {
                prev.next = newNode;
            }
            map.put(curr, newNode);
            curr = curr.next;
            prev = newNode;
        }
        
        curr = head;
        while (curr != null) {
            Node cloneNode = map.get(curr);
            if (curr.random != null) {
                Node cloneRandom = map.get(curr.random);
                cloneNode.random = cloneRandom;
            }
            curr = curr.next;
        }
        
        return clone;
    }
}