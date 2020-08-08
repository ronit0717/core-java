//Problem Link: https://www.interviewbit.com/problems/partition-list/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode curr = A;
        ListNode pointer = null;
        ListNode prev = null;
        ListNode head = A;
        
        while(curr!= null){
            if(curr.val < B){
                if(pointer == null && curr == head){
                    pointer = curr;
                    
                    prev = curr;
                    curr = curr.next;
                }else if(pointer == null && curr != head){
                    //pointer is head
                    prev.next = curr.next;
                    curr.next = head;
                    head = curr;
                    pointer = curr;
                    
                    prev = curr;
                    curr = curr.next;
                }else{
                    //bring node in next of pointer
                    ListNode next = curr.next;
                    ListNode pointerNext = pointer.next;
                    
                    if(pointerNext != curr){
                        pointer.next = curr;
                        curr.next = pointerNext;
                        prev.next = next;    
                        pointer = pointer.next;
                        curr = next;
                    }else{
                        prev = curr;
                        pointer = curr;
                        curr = next;
                    }
                }
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        
        return head;
    }
}
