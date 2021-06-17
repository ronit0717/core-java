/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//Solution 1: TC = O(2*N) = O(N), SC = O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        //compute length
        int len = 0;
        ListNode curr = head;
        ListNode tail = null; //will point to the original tail
        while (curr != null) {
            len++;
            tail = curr;
            curr = curr.next;
        }
        
        k = k % len;
        if (k == 0) {
            return head;
        }
        
        //now tail will be pointing to original head
        tail.next = head;
        
        int count = 1;
        curr = head;
        while (count < (len - k)) {
            curr = curr.next;
            count++;
        }
        head = curr.next; //new head
        curr.next = null; //the current node will be the new tail
        
        return head;
    }
}

//Solution 2: Brute force TC = O(k*N), SC = O(1)
//For k iterations, shift the last node to first position