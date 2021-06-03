//Solution 2: TC = O(log(N * M)), SC = O(1)
/* Since the entire matrix is sorted we can do binary search end to end */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length; //number of rows
        int m = matrix[0].length; //number of columns
        
        int start = 0;
        int end = n * m - 1;
        
        while (start <= end) {
            int mid = (start + end)/2;
            
            int i = mid / m;
            int j = mid % m;
            int val = matrix[i][j]; //i j represent the position
            
            if (val == target) {
                return true;
            } else if (val > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
        }
        return false;
        
    }
}



//Solution 1: TC = O(N + log M), SC = O(1)
/* Algo:
Both row and columns are sorted
Step 1: Identify row
Step 2: In the identified row, in binary search manner find the index
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //identify row
        int row = -1;
        int currRow = 0;
        while (row == -1) {
            if (currRow == matrix.length) { //target not present in any row
                return false;
            }
            if (currRow == 0 && target < matrix[currRow][0]) {
                return false;
            }
            if (target >= matrix[currRow][0] && target <= matrix[currRow][matrix[currRow].length - 1]) {
                row = currRow;
            } else {
                currRow++;
            }
        }
        
        //one row identified search the row in binary search manner
        int start = 0;
        int end = matrix[row].length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return false;
    }
}