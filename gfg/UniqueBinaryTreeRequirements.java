//Problem Link: https://www.geeksforgeeks.org/problems/unique-binary-tree-requirements/1
class Solution{
    
    public static boolean isPossible(int a, int b){
        // Code here
        return (a == b || (a != 2 && b != 2)) ? false : true;
    }
}