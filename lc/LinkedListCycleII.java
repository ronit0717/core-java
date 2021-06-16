/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//Tortoise Method (Floyd's cycle-finding algorithm), TC approx O(N), SC = O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null ) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        boolean cycle = false;
        while (fast != null) {
            if (slow == fast) {
                cycle = true;
                break;
            }
            slow = slow.next;
            fast = (fast.next == null) ? null : fast.next.next;
        }
        if (!cycle) {
            return null;
        }
        
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}