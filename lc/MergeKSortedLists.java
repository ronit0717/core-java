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

/*
Solution 2.2: Using priority queue
TC = O(K) + O((NK - K) * LogK), N is the size of linkedlist

One time iterate all the linkedlists and store the first nodes in pq
Smallest element is pq.remove() which has smallest value
Next add to this pq, the smallest element's next
do this while pq is not empty
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

//Solution 2.1
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ListNode head = null;
        ListNode node = null;
        int k = lists.length;
        ListNode[] currNodeArr = new ListNode[k];
        for (int i = 0; i < k; i++) {
            currNodeArr[i] = lists[i];
        }
        while(true) {
            boolean isBreak = true;
            for (int i = 0; i < k; i++) {
                if (currNodeArr[i] != null) {
                    isBreak = false;
                    pq.add(currNodeArr[i]);
                    currNodeArr[i] = currNodeArr[i].next;
                }
            }
            if (isBreak) {
                break;
            }
            if (!pq.isEmpty()) {
                if (head == null) {
                    head = pq.poll();
                    node = head;
                } else {
                    node.next = pq.poll();
                    node = node.next;
                }
            }
        }
        while(!pq.isEmpty()) {
            if (head == null) {
                head = pq.poll();
                node = head;
            } else {
                node.next = pq.poll();
                node = node.next;
            }
        }
        if (node != null) {
            node.next = null;
        }
        return head;
    }
}

/*
Solution 0: brute
Keep N pointers, and select a candidate.
Add the candidate to the result list
TC = O((N*K -  K) * K), N size of linkedlists
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

/*
Solution 0: Brute2 : Keep merging two lists at a time
TC = O(N*(K/2 * (K + 1))
SC = O(1)
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = merge(head, lists[i]);
        }
        return head;
    }

    private ListNode merge (ListNode node1, ListNode node2) {
        ListNode head = null;
        ListNode node = null;
        while(node1 != null && node2 != null) {
            ListNode selectedNode;
            if (node1.val < node2.val) {
                selectedNode = node1;
                node1 = node1.next;
            } else {
                selectedNode = node2;
                node2 = node2.next;
            }
            if (head == null) {
                head = selectedNode;
                node = selectedNode;
            } else {
                node.next = selectedNode;
                node = selectedNode;
            }
        }
        while(node1 != null) {
            if (head == null) {
                head = node1;
                node = node1;
            } else {
                node.next = node1;
                node = node1;
            }
            node1 = node1.next;
        }
        while(node2 != null) {
            if (head == null) {
                head = node2;
                node = node2;
            } else {
                node.next = node2;
                node = node2;
            }
            node2 = node2.next;
        }
        return head;
    }
}