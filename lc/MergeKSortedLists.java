/*
Solution 2: Using priority queue
TC = O(K) + O((NK - K) * LogK), N is the size of linkedlist

One time iterate all the linkedlists and store the first nodes in pq
Smallest element is pq.remove() which has smallest value
Next add to this pq, the smallest element's next
do this while pq is not empty
*/

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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            pq.add(lists[i]);
            lists[i] = lists[i].next;
        }
        while (!pq.isEmpty()) {
            ListNode cand = pq.remove();
            if (head == null) {
                head = cand;
                curr = cand;
            } else {
                curr.next = cand;
                curr = cand;
            }
            cand = cand.next;
            if (cand != null) {
                pq.add(cand);
            }
        }
        return head;
    }
}

/*
Solution 1: brute
Keep N pointers, and select a candidate.
Add the candidate to the result list
TC = O((N*K -  K) * K), N size of linkedlists
*/
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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr = null;
        ListNode cand = null;
        int candIndex = -1;
        
        boolean done = false;
        while (!done) {
            done = true;
            candIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                done = false;
                candIndex = (candIndex == -1 || lists[i].val < lists[candIndex].val) ? i : candIndex;
            }
            cand = candIndex != -1 ? lists[candIndex] : null;
            if (cand != null) {
                lists[candIndex] = lists[candIndex].next;
            }
            head = head == null ? cand : head;
            if (curr == null) {
                curr = cand;
            } else {
                curr.next = cand;
                curr = cand;
            }
            
        }
        return head;
    }
}