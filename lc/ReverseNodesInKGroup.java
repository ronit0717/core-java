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

//Solution 1: TC = O(N), SC = O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1) {
            return head;
        }
        
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        if (len < k) {
            return head;
        }
        
        curr = head;
        int count = 1;
        ListNode res = null, prevNode1 = null, prevNode2 = null, prev = null, next = null;
        
        while (curr != null) {
            if (count == 1) {
                prevNode1 = prevNode2;
                if (len < k) {
                    prevNode1.next = curr;
                    break;
                }
                prevNode2 = curr;
                prev = null;
            } else {
                res = (count == k && res == null) ? curr : res;
                
                if (count == k && prevNode1 != null) {
                    prevNode1.next = curr;
                }
                count = count % k;
            }
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
            len--;
            count++;
        }
        
        return res;
    }
}