//Question Link: https://www.interviewbit.com/problems/list-cycle/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;
        boolean cycleFound = false;
        ListNode intersectedNode = null;

        while(!cycleFound){
            if(slow == null || fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycleFound = true;
                intersectedNode = slow;
            }
        }

        while(true){
            if(a == intersectedNode){
                return a;
            }

            a = a.next;
            intersectedNode = intersectedNode.next;
        }

    }
}
