// Link: https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/

/* Greedy approach, TC = O(NLogN) --to sort, SC = O(N)
Algo:
Sort the input in ascending order of end time
iterate over the input, if the currMeetingStartTime > lastMeetingEndTime => count++
return count

Intuition:
----------
Since we want to fit max meetings possible in the room, we sort it in ascending order of the end time. This ensures the meeting which ends first, are up in priority.

As its an optimization problem to find max number of meetings possible, with this approach it guarantees that even if there is a different combination, the count
wont be greater than count computed using this approach


Example: (1,3), (1,2), (4,6), (3,5)
*/

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        if (n == 0) {
            return 0;
        }
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(start[i]);
            list.add(end[i]);
            A.add(list);
        }
        Collections.sort(A, (a, b) -> (a.get(1) - b.get(1)));
        int count = 1;
        int lastEnd = A.get(0).get(1);
        for (int i = 1; i < n; i++) {
            if (A.get(i).get(0) > lastEnd) {
                count++;
                lastEnd = A.get(i).get(1);
            }
        }
        return count;
    }
}