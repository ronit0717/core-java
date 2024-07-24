//Link: https://practice.geeksforgeeks.org/problems/subset-sums2234/1#

/* Solution 2: Decision tree approach
say 3 numbers, 1 2 and 3
So we have three candidate positions, and we can decide to either take the element at that position
or skip it
So every step, we have two choice, either to pick current element or skip it

TC = O(2 ^ N) because every recursion, we have 2 choice
    + O(xlogx) where x = result list size to sort
SC = O(2 ^ N)
*/
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        subsetUtil(arr, N, 0, res, 0);
        Collections.sort(res);
        return res;
    }
    
    private void subsetUtil(ArrayList<Integer> arr, 
                            int N, 
                            int index,
                            ArrayList<Integer> res,
                            int sum
                            ) {
        if (index == N) {
            res.add(sum);
            return;
        }
        subsetUtil(arr, N, index + 1, res, sum); //current element not picked
        subsetUtil(arr, N, index + 1, res, sum + arr.get(index)); //current element picked
    }
}

/*
Solution 1: Recursive approach, where we get all the subset sums for the immediate right index
TC = O(2 ^ N) because every recursion, the result set size multiplies by 2 
    + O(xlogx) where x = result list size to sort
SC = O(2 ^ N)

Total subsets = N-C-0 + N-C-1 + N-C-2 + ..... + N-C-N = 2^N
*/

class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> res = subsetUtil(0, arr, N);
        Collections.sort(res);
        return res;
    }
    
    ArrayList<Integer> subsetUtil(int index, ArrayList<Integer> arr, int N) {
        ArrayList<Integer> res = new ArrayList<>();
        if (index == N) {
            res.add(0);
            return res;
        }
        ArrayList<Integer> inRes = subsetUtil(index + 1, arr, N);
        int curr = arr.get(index);
        
        for (Integer n : inRes) {
            res.add(n);
            res.add(curr + n);
        }
        
        return res;
    }
}

/* Solution 3: Recursion: Code simplified */
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        execute(0, 0, arr, result);
        return result;
    }
    
    void execute(int sum, int index, ArrayList<Integer> arr, ArrayList<Integer> result) {
        if (index >= arr.size()) {
            result.add(sum);
            return;
        }
        execute(sum, index+1, arr, result); //not pick
        execute(sum + arr.get(index), index+1, arr, result); //pick
    }
}