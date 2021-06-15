/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//Solution 0: two pass crisp approach, TC = O(2N + 2M) = O(N+M), SC = O(1)
/* Algo
Traverse each list simultaneously
if first list reached end, switch it to the second head, and continue for a second pass
similarily, 
if second list reached end, switch it to the first head, and continue for a second pass

If there is a intersection point, it will definitely meet atleast in second pass
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode currA = headA;
        ListNode currB = headB;
        
        while (currA != currB) {
            currA = (currA == null) ? headB : currA.next;
            currB = (currB == null) ? headA : currB.next;
        }
        return currA;
    }
}

//or 

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        boolean firstAIteration = true;
        boolean firstBIteration = true;
        
        ListNode currA = headA;
        ListNode currB = headB;
        
        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
            
            if (currA == null && firstAIteration) {
                currA = headB;
                firstAIteration = false;
            }
            
            if (currB == null && firstBIteration) {
                currB = headA;
                firstBIteration = false;
            }
        }
        
        return null;
    }
}


// Solution 1: Diff of length approach, TC = O(2N + 2M) = O(N+M), SC = O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLength(headA); //length of 1st linkedlist
        int len2 = getLength(headB); //length of 2nd linkedlist
        
        if (len1 > len2) {
            int diff = len1 - len2;
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else if (len2 > len1) {
            int diff = len2 - len1;
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    private int getLength(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}

// Solution 2: Using hashset, TC = O(N + M), SC = O(N)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        
        curr = headB;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}

/* Solution 3: Brute Force => For each node in ListA, check every node in ListB
   TC = O(N*M), SC = O(1)
*/
