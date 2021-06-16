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

//Solution 1: Reversing list to the right of mid, TC = O(N + N/2) = O(N), SC = O(1)
//Original list gets altered here
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        } else if (head.next.next == null && head.val == head.next.val) {
            return true;
        } else if (head.next.next == null && head.val != head.next.val) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        //reach mid point
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = (fast.next == null) ? null : fast.next.next;  
        }
        
        ListNode mid = prev;
        //reverse nodes in right of mid
        prev = mid.next;
        slow = prev.next;
        prev.next = null;
        ListNode next = null;
        
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        mid.next = prev;
        
        //compare from start and mid
        slow = head;
        fast = mid.next;

        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}

 //Solution 0: Using stack, TC = O(N), SC = O(N/2)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        } else if (head.next.next == null && head.val == head.next.val) {
            return true;
        } else if (head.next.next == null && head.val != head.next.val) {
            return false;
        }
        
        Stack<Integer> st = new Stack<>();
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null) {
            if (fast.next != null) {
                st.push(slow.val);
                fast = fast.next.next;
            } else {
                fast = null;
            }
            slow = slow.next;
        }
        
        while (slow != null) {
            if (slow.val != st.pop()) {
                return false;
            }
            slow = slow.next;
        }
        
        return true;
        
    }
}