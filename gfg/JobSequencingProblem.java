//Link: https://www.geeksforgeeks.org/job-sequencing-problem/

/* Solution 2: TC = O(NLogN * x), where x is max deadline
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