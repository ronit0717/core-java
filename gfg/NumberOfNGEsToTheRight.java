//Problem Link: https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    Stack<Integer> st1 = new Stack<>(); //stores in asc order (smallest at top)
    Stack<Integer> st2 = new Stack<>();
    int[] ngeCount = new int[N];
    for (int i = N - 1; i >= 0; i--) {
        while(!st1.isEmpty() && st1.peek() <= arr[i]) {
            st2.push(st1.pop());
        }
        ngeCount[i] = st1.size();
        
        st2.push(arr[i]);
        
        //refill
        while(!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }
    int[] ans = new int[queries];
    for (int i = 0; i < queries; i++) {
        ans[i] = ngeCount[indices[i]];
    }
    return ans;
     
  }
}