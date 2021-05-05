public class Solution {
    public int solve(ArrayList<Integer> A) {
        boolean status = checkBSTUtil(A, 0, A.size() - 1);
        if (status) return 1;
        return 0;
    }
    
    private boolean checkBSTUtil(ArrayList<Integer> A, int start, int end) {
        if (start > end) {
            return false;
        } else if (start == end || (end - start) == 1) {
            return true;
        }
        
        int maxLeft = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;
        
        int index = start + 1;
        while (index <= end && A.get(index) <= A.get(start)) {
            if (A.get(index) > maxLeft) {
                maxLeft = A.get(index);
            }
            index++;
        }
        int caseCheck = 0;
        int pivot = index - 1;
        if (index > end) { //only left subtree case
            caseCheck = -1;
        } else if (index == start + 1) { //only right sub tree case
            caseCheck = 1;
        }
        while (index <= end) {
            if (A.get(index) < minRight) {
                minRight = A.get(index);
            }
            index++;
        }
        if (caseCheck <= 0 && maxLeft > A.get(start)) {
            return false;
        }
        if (caseCheck >= 0 && minRight <= A.get(start)) {
            return false;
        }
        if (caseCheck == 0) {
            return checkBSTUtil(A, start + 1, pivot) && checkBSTUtil(A, pivot + 1, end);
        }
        return checkBSTUtil(A, start + 1, end);
    }
}


/*
explanation:

array : 7 7 10 10 9 5 2 8

for node at index 0, 
left subtree => 1 to ith index
right subtree => i+1 to end index

max of left subtree <= node.val < min of right subtree

recursive call to check for each subtrees
*/