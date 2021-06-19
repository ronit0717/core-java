//Link: https://www.interviewbit.com/problems/meeting-rooms/
//Similar to minimum number of platforms question

//Solution 1 -> TC = O(NLogN), SC = O(1)
public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int[] start = new int[A.size()];
        int[] end = new int[A.size()];

        for (int i = 0; i < A.size(); i++) {
            start[i] = A.get(i).get(0);
            end[i] = A.get(i).get(1);
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int currCount = 0; //stores the curr meeting rooms in use count at a given point of time
        int maxCount = 0; //stores max currCount at a given point of time
        int j = 0;
        for (int i = 0; i < A.size(); i++) {
            while (end[j] <= start[i]) {
                currCount--;
                j++;
            }
            currCount++;
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}


//Solution 2: Using a minHeap
//To find the minimum number of meeting rooms, TC = O(NLogN), SC = O(N)
/*
1. Order the events in increasing order of start time
2. Make a priorityQueue (PQ), and assign first meeting to the PQ
3. Iterate all events
    1. Iterate all events in PQ (in ascending order of end times)
        1. If currStartTime >= meetingEndTime in , we can use the same meeting room
            ie, update the meetingEndTime with the currEndTime

Intuition:
----------
Its a optimization problem, hence Greedy approach used.

This is very similar to some actual use case, like in Hotel room management, First come - First serve basis, keeping in mind to reuse the rooms available, 
instead of allocating new rooms. The room which is vacated first, should be reused first
*/

public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        Collections.sort(A, (a, b) -> (a.get(0) - b.get(0)));
        PriorityQueue<Integer> meet = new PriorityQueue<>();
        meet.add(A.get(0).get(1));
        
        for (int i = 1; i < A.size(); i++) {
            int removeObject = -1;
            int currStart = A.get(i).get(0);
            int currEnd = A.get(i).get(1);

            for (Integer m : meet) {
                if (currStart >= m) {
                    removeObject = m;
                    break;
                }
            }
            if (removeObject != -1) {
                meet.remove(removeObject);
            }
            meet.add(currEnd);
        }
        return meet.size();
    }
}
