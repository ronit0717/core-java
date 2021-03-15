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
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode();
        reverse(head, result);
        return result.next;
    }
    
    ListNode reverse(ListNode curr, ListNode result) {
        if (curr == null) {
            return curr;
        }
        ListNode next = reverse(curr.next, result);
        if (next != null) {
            next.next = curr;
        } else {
            //result = curr;
            result.next = curr;
            
        }
        curr.next = null;
        return curr;
    }   
}