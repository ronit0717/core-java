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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode curr = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val = getSum(l1, l2, carry);
            if (val >= 10) {
                carry = 1;
                val = val - 10;
            } else {
                carry = 0;
            }
            if (result == null) {
                result = new ListNode(val);
                curr = result;
            } else {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
            if (l1 != null) {
                l1 = l1.next;                
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }
    
    private int getSum(ListNode l1, ListNode l2, int carry) {
        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null)  {
            sum += l2.val;
        }
        return sum;
    }
}