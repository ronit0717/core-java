import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class DuplicateRemove {
    public ListNode deleteDuplicates(ListNode A) {
        HashSet<Integer> hs = new HashSet<Integer>();
        ListNode result = new ListNode(A.val);
        ListNode resultHead = result;
        hs.add(A.val);
        A = A.next;
        

        while(A != null){
            if(!(hs.contains(A.val))){
                result.next = new ListNode(A.val);
                result = result.next;
                hs.add(A.val);
            }
            A = A.next;
        }

        return resultHead;
    }
}
