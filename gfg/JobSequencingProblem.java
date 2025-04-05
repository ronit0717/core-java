//Link: https://www.geeksforgeeks.org/job-sequencing-problem/

/* Solution 3 More readable Soltion
    TC = O(NLogN) + O(N*MaxDeadline)
*/
class Job implements Comparable<Job> {
    int id;
    int deadline;
    int profit;
    
    Job(int id, int deadline, int profit) {
        this.id  = id;
        this.deadline = deadline;
        this.profit = profit;
    }
    
    @Override
    public int compareTo(Job j) {
        return j.profit - this.profit; //descending order
    }
}

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        List<Job> jobList = buildJobList(deadline, profit);
        int[] slot = buildSlot(deadline);
        int maxProfit = 0;
        int count = 0;
        for (Job job : jobList) {
            int dl = job.deadline;
            for (int i = dl - 1; i >= 0; i--) {
                if (slot[i] == -1) {
                    slot[i] = job.id;
                    maxProfit += job.profit;
                    count++;
                    break;
                }
            }
            if (count == slot.length) {
                break; //no more slots left
            }
        }
        ArrayList ans = new ArrayList<>(2);
        ans.add(count);
        ans.add(maxProfit);
        return ans;
        
    }
    
    private int[] buildSlot(int[] deadline) {
        int maxDeadline = 1;
        for (int i = 0; i < deadline.length; i++) {
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        int[] slot = new int[maxDeadline];
        for (int i = 0; i < maxDeadline; i++) {
            slot[i] = -1;
        }
        return slot;
    }
    
    private List<Job> buildJobList(int[] deadline, int[] profit) {
        List<Job> list = new ArrayList<>(deadline.length);
        for (int i = 0; i < deadline.length; i++) {
            Job job = new Job(i, deadline[i], profit[i]);
            list.add(job);
        }
        Collections.sort(list);
        return list;
    }
}

/* Solution 2: TC = O(NLogN * x), where x is max deadline
SC = O(x), where x is max deadline
Sort the array in descending order of profit
Then iterate the array, and try to do the task on last day of deadline.
If on that day already a task is assigned, move to previous day
Keep counting how many jobs can be done and the profit
*/
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        int jobStatus[] = new int[maxDeadline];
        Arrays.fill(jobStatus, -1);
        int count = 0, profit = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j >= 1; j--) {
                if (jobStatus[j-1] == -1) {
                    jobStatus[j-1] = arr[i].id;
                    count++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        
        return new int[]{count, profit};
    }
}

/* Solution 1: O(NLogN) => to sort + O(N * (deadlineGap)*LogN) => for loop and heapify each time
Overall TC = O(NLogN * x), SC = O(N), where x is directily proportional to max deadline

Logic:
1. Sort in decreasing order of deadline
2. Loop the array and find the max of all profits (using max heap), eligible for each 
deadline day in reverse
Note that the job which is eligible on nth day, is also eligible on (n-1)th, (n-2)th,..., 1st day
also
*/
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        if (n <= 0) {
            return new int[]{0, 0};    
        }
        
        Arrays.sort(arr, (a, b) -> (b.deadline - a.deadline));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        
        int profit = 0, prev = 0, count = 0, pqSize = 0;
        
        for (int i = 0; i < n; i++) {
            if (i != 0 && prev != arr[i].deadline) {
                pqSize = pq.size();
                for (int j = 0; (j < (prev - arr[i].deadline) && pqSize > 0); j++) {
                    count++;
                    profit += pq.poll();
                    pqSize--;
                }
            }
            prev = arr[i].deadline;
            pq.add(arr[i].profit);
        }
        
        pqSize = pq.size();
        for (int j = 0; (j < prev && pqSize > 0); j++) {
            count++;
            profit += pq.poll();
            pqSize--;
        }
        
        return new int[]{count, profit};
    }
}