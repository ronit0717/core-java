//Problem link: https://www.geeksforgeeks.org/problems/shortest-job-first/1
class Solution {
    static int solve(int bt[] ) {
    // code here
    int n = bt.length;
    int waitSum = 0;
    Arrays.sort(bt);
    int time = 0;
    for (int i = 0; i < n; i++) {
        waitSum += time;
        time += bt[i];
    }
    return waitSum / n;
  }
}