//Problem link: https://www.geeksforgeeks.org/problems/binary-search-trees/1
class Solution {
    static boolean isBSTTraversal(int arr[]) {
        // code here
        //If all numbers in increasing order then tru
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
