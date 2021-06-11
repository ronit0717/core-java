/* TC = O(N), SC = O(1) */

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        ListNode next = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                next = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                next = l1;
                l1 = l1.next;
            } else {
                next = l2;
                l2 = l2.next;
            }
            
            if (head == null) {
                head = next;
                curr = head;
            } else {
                curr.next = next;
                curr = curr.next;
            }
        }
        return head;
    }
}