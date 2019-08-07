/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }

1 2 3 4
1 2 3


 * }
 */
public class Palindrome {
    private static ListNode reverseLinkedList(ListNode node){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = node;

        while(curr!= null){
          next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
        }

        return prev;
    }

    
    public int lPalin(ListNode A) {
        if(A.next == null){
            return 1;
        }
        
        ListNode fast = A;
        ListNode slow = A;
        ListNode first = A;
        ListNode second = null;
        ListNode prevSlow = null;
        while(true){
          prevSlow = slow;
          slow = slow.next;
          fast = fast.next.next;

          if(fast == null){
            //even case
            prevSlow.next = null;
            second = reverseLinkedList(slow);

            break;
          }else if(fast.next == null){
            //odd case
            second = reverseLinkedList(slow);
            break;
          }
        }

        int result = 1;
        while(first != null){
          if(first.val != second.val){
            return 0;
          }
          first = first.next;
          second = second.next;
        }

        return result;

        
    }
}
