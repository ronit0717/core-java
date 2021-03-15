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
        ResultObject result = new ResultObject();
        reverse(head, result);
        return result.result;
    }
    
    class ResultObject {
        ListNode result;
    }
    
    ListNode reverse(ListNode curr, ResultObject result) {
        if (curr == null) {
            return curr;
        }
        ListNode next = reverse(curr.next, result);
        if (next != null) {
            next.next = curr;
        } else {
            //result = curr;
            result.result = curr;
            
        }
        curr.next = null;
        return curr;
    }
}