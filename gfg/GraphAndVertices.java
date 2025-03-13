//Problem Link: https://www.geeksforgeeks.org/problems/graph-and-vertices/1

class Solution {
    static long count(int n) {
    // code here
        return (long)Math.pow(2, (n * (n - 1)) / 2);
  }
}
/*
Logic: Given N nodes, 
First node can or cannot connect to the other N-1 nodes. Hence 2 ^ (N - 1)
Second node can or cannot connect to the other N-2 nodes (First node case already considered above). Hence 2 ^ (N - 2)
...
Second Last node can or cannot connect to the last node. Hence 2 ^ 1

Thats why total combinations =  2 ^ 1 * 2 ^ 2 * .... * 2 ^ N - 1 
             = 2 ^ ( ((N - 1) * N) / 2 )
*/