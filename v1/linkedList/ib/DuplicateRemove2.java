/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode result = null;
        ListNode resultHead = null;

        if(A.next == null){
            //only 1 element
            return A;
        }else if(A.next.next == null){
            //2 elements
            if(A.val == A.next.val){
                return resultHead; //null
            }else{
                return A;
            }
        }else{
            //3 or more than 3
            
            //firstElementCheck
            if(A.val != A.next.val){
                result = new ListNode(A.val);
                resultHead = result;
            }

            int prev = A.val;
            A = A.next;

            int curr;
            int next;

            while(true){
                curr = A.val;
                next = A.next.val;

                if(prev!= curr && curr!=next){
                    if(result == null){
                        result = new ListNode(curr);
                        resultHead = result;
                    }else{
                        result.next = new ListNode(curr);
                        result = result.next;
                    }
                }

                if(A.next.next != null){
                    prev = curr;
                    A = A.next;
                }else{
                    if(curr != next){
                        if(result == null){
                            result = new ListNode(next);
                            resultHead = result;
                        }else{
                            result.next = new ListNode(next);
                            result = result.next;
                        }   
                    }
                    break;
                }
            }


        }
        return resultHead;

    }
}
