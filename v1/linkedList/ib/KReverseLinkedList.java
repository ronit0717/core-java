/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    private static ListNode lastSetTail;
    private static ListNode result;
    private static boolean allTraversed;
    private static boolean headDetermined;
    
    public ListNode reverseList(ListNode A, int B) {
        allTraversed = false;
        headDetermined = false;
        lastSetTail = null;
        result = null;
        if(A.next == null || B == 1){
            return A;
        }

        ListNode pointer = A;

        while(!allTraversed && pointer!= null){
            pointer = subReverse(pointer, B);
        }

        return result;

    }

    private static ListNode subReverse(ListNode start, int size){
        ListNode prev = null;
        ListNode curr = start;
        ListNode next;

        int counter = 0;
        while(counter < size){
            if(curr == null){
                allTraversed = true;
                break;
            }
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            counter++;
        }

        if(!headDetermined){
            result = prev;
            headDetermined = true;
        }else{
            lastSetTail.next = prev;
        }

        lastSetTail = start;

        return curr;
    }
}
