/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* Solution 2: TC = O(1), SC = O(1)
Make the current node val = next node val
Just remove the immediate next node from the list
*/
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


/* Solution 1: TC = O(N), SC= O(1)
Iterate and Make curr node val = next node val, till the very end
Remove the tail node
*/
class Solution {
    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}


/* If node to be deleted is the last node, just make the node to be deleted as null */