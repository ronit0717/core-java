//Link: https://www.interviewbit.com/problems/reverse-link-list-ii/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode startNode =  null;
        ListNode endNode = null;
        ListNode leftEnd = null;
        ListNode rightStart = null;
        
        ListNode curr = A;
        ListNode prev = null;
        ListNode next = null;

        int point = 1;

        while(curr != null){
            
            if(point < B){
                leftEnd = curr;
            }else if(point >= B && point <= C){
                if(point == 1 && curr.next ==null){
                    return curr;
                }

                if(point == B){
                    endNode = curr;
                }
                
                if(point == C){
                    startNode = curr;
                }

                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                point++;
                continue;

            }else{
                if(rightStart != null){
                    rightStart = curr;
                }
            }
            
            prev = curr;
            curr = curr.next;
            point++;
        }

        if(leftEnd != null){
            leftEnd.next = startNode;
        }
        
        endNode.next = rightStart;

        if(B == 1){
            return startNode;
        }else{
            return A;
        }
    }
}

