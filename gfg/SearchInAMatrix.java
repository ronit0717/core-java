//Link: https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/

//Solution 2: TC = O(N + M), SC = O(1)
/*
Start at top right, if curr == X => we found it
                    else if curr < X => then move left 
                    else  => move down

*/
class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        // your code here
        
        int i = 0;
        int j = M - 1;
        //i j represent the top right position
        
        while (i < N && j >= 0) {
            if (X == mat[i][j]) {
                return 1;
            } else if (X > mat[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return 0;
    }
}


//Solution 1: TC = O(log N + log M), SC = O(1)
/* Algo:
Both row and columns are sorted
Step 1: In binary search manner identify the row
Step 2: In the identified row, in binary search manner find the index
*/

class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        // your code here
        
        //identify row
        int row = -1;
        int start = 0;
        int end = N - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if ( (mid == (N - 1)) || (mat[mid][0] <= X && mat[mid+1][0] > X) ) {
                row = mid;
                break;
            } else if (mat[mid][0] > X) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        if (row == -1) { //row not identified
            return 0;
        }
        
        //one row identified search the row in binary search manner
        start = 0;
        end = M - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (X == mat[row][mid]) {
                return 1;
            } else if (X > mat[row][mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return 0;
    }
}