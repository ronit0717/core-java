//Solution 1: Brute force
/*
1. Make an array representing row and column
2. Traverse each cell in matrix, and if cell is 0, make corresponding element in the array as 0
3. Again traverse the matrix, and based on the array make the cells as 0

Time complexity = O(m*n)
Space complexity = O(m+n)
*/

//Solution 2: Space O(1)
/*
1. Traverse each cell, and if it is zero, in the corresponding element in first row and column make it zero
Make a note of if the zero is in the first row or first column itself
2. Now again traverse each cell each first row and first column, corresponding to first row and first column
assign zero to the cell
3. If the first row itself contains the zero, assign all elements in first row as zero
4. If the first column itself contains the zero, assign all elements in first col as zero
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowContainsZero = false;
        boolean firstColContainsZero = false;

        //step 1
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    
                    if (i == 0) {
                        firstRowContainsZero = true;
                    }
                    if (j == 0) {
                        firstColContainsZero = true;
                    }
                }
            }
        }   

        //step 2
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //step 3
        if (firstRowContainsZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        //step 4
        if (firstColContainsZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}