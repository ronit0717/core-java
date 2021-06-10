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
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            if (fast.next == null) {
                return slow;
            } else if (fast.next.next == null) {
                return slow.next;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
    }
}

//Slower solution
/*
First measure the length, traversing once
Then again iterate to the length/2 to reach middle node
*/