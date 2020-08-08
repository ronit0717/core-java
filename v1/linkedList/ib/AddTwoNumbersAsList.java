//Question Link: https://www.interviewbit.com/problems/add-two-numbers-as-lists/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        int a = 0;
        int b = 0;
        int sum = 0;
        int num;
        ListNode head = null;
        ListNode curr = null;

        while(A !=null || B != null || carry!= 0){
            a = 0;
            b = 0;
            if(A != null){
                a = A.val;
                A = A.next;
            }  

            if(B!= null){
                b = B.val;
                B = B.next;
            }

            sum = a + b + carry;

            if(sum >= 10){
                num = sum%10;
                carry = sum/10;
            }else{
                num = sum;
                carry = 0;
            }

            if(curr == null){
                head = new ListNode(num);
                curr = head;
            }else{
                curr.next = new ListNode(num);
                curr = curr.next;
            }
        }

        return head;
    }
}
